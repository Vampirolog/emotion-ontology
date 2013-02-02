package ch.bioontology.emonto.client;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;

public class EmontoFooterPanel extends FlowPanel {
	
	private HTML contentText;
	
	public EmontoFooterPanel() {
		super();
		
		String contentTextString = "The Emotion Ontology Browser website is maintained by janna. Supported by NSF. ";
		
		contentText = new HTML(contentTextString);		
		
		add(contentText);
	}


}
