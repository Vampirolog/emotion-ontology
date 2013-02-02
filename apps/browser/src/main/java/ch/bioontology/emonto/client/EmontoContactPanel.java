package ch.bioontology.emonto.client;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;

public class EmontoContactPanel extends FlowPanel {

	private HTML contentText;
	
	public EmontoContactPanel() {
		super();
		
		String contentTextString = "<p>To contact: Janna Hastings</p>";
		
		contentText = new HTML(contentTextString);		
		
		add(contentText);
	}
}
