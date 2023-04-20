package common.controller;

abstract public class AbstractAction implements Action {
	// execeute() 추상메서드를 가짐
	private String viewPage; // 보여줄 뷰 페이지 이름
	private boolean isRedirect; // true이면 redirect 이동, false면 forward 이동
	
	
	//setter, getter
	public void setViewPage(String viewPage) {
		this.viewPage = viewPage;
	}
	
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	public String getViewPage() {
		return viewPage;
	}
	
	public boolean isRedirect() {
		return isRedirect;
	}
	
	
	
}// AbstractAction end -------------
