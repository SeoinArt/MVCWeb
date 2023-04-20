package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 상속
// 재정의
// req에 저장 msg, "From TestAction"
// hello.jsp 로 forward 이동하도록 설정


public class TestAction extends AbstractAction {

	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("TestAction의 execute() 호출됨...");
		req.setAttribute("msg", "From TestAction");
		
		this.setViewPage("/hello.jsp");
		this.setRedirect(false);
	}

}
