package ie.testtriangle.automation.widget.iface;

public interface IReadableWidget extends IWidget {
	public String getText();
	
	public boolean compareText(String comparison);
}
