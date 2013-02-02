package ch.bioontology.emonto.client;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;

public class EmontoAboutPanel extends FlowPanel {
	
	private HTML contentText;
	
	public EmontoAboutPanel() {
		super();
		
		String contentTextString = "<h1>The Emotion Ontology Browser</h1> \n" +
				"<p>The emotion ontology browser offers a search and browse interface to the Emotion Ontology " +
				"being developed at the University of Geneva and the University at Buffalo</p>";
		
		contentText = new HTML(contentTextString);		
		
		add(contentText);
	}

}
