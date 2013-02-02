package ch.bioontology.emonto.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EmontoHeaderPanel extends VerticalPanel {
	
	private HorizontalPanel buttonPanel;
	private Image image;
	
	private Button browseButton;
	private Button searchButton;
	private Button aboutButton;
	private Button contactButton;
	
	public EmontoHeaderPanel() {
		super();
		
		buttonPanel = new HorizontalPanel();
		buttonPanel.setHorizontalAlignment(ALIGN_CENTER);

		browseButton = new Button("Browse");
		searchButton = new Button("Search");
		aboutButton = new Button("About");
		contactButton = new Button("Contact");

		buttonPanel.add(aboutButton);
		buttonPanel.add(searchButton);
		buttonPanel.add(browseButton);
		buttonPanel.add(contactButton);
		
		image = new Image();

	    // Point the image at a real URL.
	    image.setUrl(GWT.getModuleBaseURL()+"images/emontobanner.png");
		
		add(image);
		add(buttonPanel);

		setVerticalAlignment(ALIGN_MIDDLE);
		setHorizontalAlignment(ALIGN_CENTER);

	}
	
	public void addClickHandler(ClickHandler handler) {
		browseButton.addClickHandler(handler);
		searchButton.addClickHandler(handler);
		aboutButton.addClickHandler(handler);
		contactButton.addClickHandler(handler);
	}

	public Button getBrowseButton() {
		return browseButton;
	}

	public void setBrowseButton(Button browseButton) {
		this.browseButton = browseButton;
	}

	public Button getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(Button searchButton) {
		this.searchButton = searchButton;
	}

	public Button getAboutButton() {
		return aboutButton;
	}

	public void setAboutButton(Button aboutButton) {
		this.aboutButton = aboutButton;
	}

	public Button getContactButton() {
		return contactButton;
	}

	public void setContactButton(Button contactButton) {
		this.contactButton = contactButton;
	}
	
	

}
