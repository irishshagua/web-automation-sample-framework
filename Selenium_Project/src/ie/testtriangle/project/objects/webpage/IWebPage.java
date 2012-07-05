package ie.testtriangle.project.objects.webpage;

public interface IWebPage {
	
	int ACTION_TIMEOUT = 30;
	
	public String getUrl();
	
	public void open();

}
