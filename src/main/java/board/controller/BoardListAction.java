package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardVO;
import common.controller.AbstractAction;

public class BoardListAction extends AbstractAction {
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		BoardDAO dao =new BoardDAO();
		
		// 0. 현재 보여줄 페이지(cpage)값 받기
		String cpStr = req.getParameter("cpage");
		if(cpStr == null || cpStr.trim().isEmpty()) {
			cpStr = "1"; // 1페이지를 기본값으로 설정
		}
		int cpage = Integer.parseInt(cpStr.trim());
		if(cpage<=0) {
			cpage = 1; 
		}
		
		
		// 1. 총 게시글 수 가져오기
		int totalCount = dao.getTotalCount();
		
		// 2. 페이지당 출력할 목록의 개수 정하기
		final int pageSize = 5;
		
		// 3. 페이지 수 구하기 => req에 저장하기
		int pageCount = (totalCount-1)/pageSize +1;
		
		if(pageCount<=0) {
			pageCount = 1; 
		}else if(cpage>pageCount) {
			cpage = pageCount;
		}
		
		// 4. JSP에서 pageCount 수만큼 반복문 돌면서 페이지 링크를 출력한다.
		
		// 5 . cpage를 이용해서 DB에서 끊어올 데이터 범위를 정한다.
		
		// 6. BoardDAO 에 start, end 값 넘겨서 subquery이용해서 현재 보여줄 페이지에 해당하는 데이터만 출력한다		
		int end = cpage * pageSize;
		int start = end - (pageSize-1);
		List<BoardVO> boardArr = dao.listBoard(start, end);
		

		
		// 글 목록 가져오기
//		List<BoardVO> boardArr = dao.listBoard(); 페이징 처리 안할때
		
		req.setAttribute("boardArr", boardArr);
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("pageCount",pageCount);
		req.setAttribute("cpage", cpage);
		req.setAttribute("pageSize", pageSize);
		
		this.setViewPage("/board/boardList.jsp");
		this.setRedirect(false);
		

	}
}


/*
 
 
totalCount	pageSize		pageCount
 
1~4,5		   5			1
6~9,10		   5			2
11~14,15	   5			3
16~19,20	   5			4

/////////////////////////////////////////
if(totalCount%pageSize==0)
	pageCount=totalCount/pageSize;
else
	pageCount=totalCount/pageSize +1
/////////////////////////////////////////////
==> 1줄로 줄여보자
pageCount=(totalCount-1)/pageSize+1;

*/

/*		
	select * from (
	select rownum rn, A.* from 
		(select * from board order by num desc) A)
where rn between start and end;

end = cpage * pageSize;
start = end -(pageSize-1);
			
*/

