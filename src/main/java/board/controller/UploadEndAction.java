package board.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://www.servlets.com/cos/
// 파일업로드 라이브러리 다운로드 cos.jar 다운로드 받아서 WEB-INF/lib에 붙여넣기
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.controller.AbstractAction;
public class UploadEndAction extends AbstractAction {
	String upDir="C:/Web/myJava/Upload";
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 동일한 파일명이 있을 경우 "파일명+인덱스 번호" 식으로 업로드시킴
		DefaultFileRenamePolicy df = new DefaultFileRenamePolicy();
		// 업로드 최대 용량 : 100mb => 초과하면 예외 발생
		MultipartRequest mr = new MultipartRequest(req, upDir,100*1024*1024,"utf-8",df);
		System.out.println("파일 업로드 성공!! "+upDir+"에서 확인하세요!");
		
		String writer = mr.getParameter("writer");
		System.out.println("writer : "+writer);
		
		// 첨부파일명
		String fname = mr.getFilesystemName("fname");
		System.out.println("fname:"+fname);
		
		// 첨부파일 크기
		File file = mr.getFile("fname");
		long fsize=0;
		if(file!=null) {
			fsize =file.length();
			System.out.println("파일크기 : "+fsize);
		}
		
		req.setAttribute("fname", fname);
		req.setAttribute("fsize", fsize);
		req.setAttribute("writer", writer);
		
		
		req.setAttribute("msg", "파일 업로드 성공!! "+upDir+"에서 확인하세요!");
		this.setViewPage("board/uploadResult.jsp");
		this.setRedirect(false);
	}

}
