package ch.bioontology.emonto.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Emontobrowse implements EntryPoint, ClickHandler {

	private DockLayoutPanel mainPanel;
	private EmontoHeaderPanel headerPanel;
	private EmontoFooterPanel footerPanel;
	private EmontoSearchPanel searchPanel;
	private EmontoAboutPanel aboutPanel;
	private EmontoBrowsePanel browsePanel;
	private EmontoContactPanel contactPanel;
	private FlowPanel mainCenterPanel;

	private EmontoKBServiceAsync kbSvc = GWT.create(EmontoKBService.class);

	private enum ActivePage {ABOUT, SEARCH, CONTACT, BROWSE};
	private ActivePage activePage;

	public ActivePage getActivePage() {
		return activePage;
	}

	public void onModuleLoad() {
		mainPanel = new DockLayoutPanel(Unit.EM);
		mainCenterPanel = new FlowPanel();
		headerPanel = new EmontoHeaderPanel();
		headerPanel.addClickHandler(this);
		searchPanel = new EmontoSearchPanel();
		aboutPanel = new EmontoAboutPanel();
		contactPanel = new EmontoContactPanel();
		footerPanel = new EmontoFooterPanel();
		browsePanel = new EmontoBrowsePanel();

		mainPanel.addNorth(headerPanel, 15);
		mainPanel.addSouth(footerPanel, 2);
		mainPanel.addEast(new HTML(""), 4);
		mainPanel.addWest(new HTML(""), 4);
		mainPanel.add(mainCenterPanel);
		setActivePage(ActivePage.ABOUT);

		// Attach the LayoutPanel to the RootLayoutPanel. The latter will listen for
		// resize events on the window to ensure that its children are informed of
		// possible size changes.
		RootLayoutPanel.get().add(mainPanel);

		//initialize the ontology knowledge base on the server side
		AsyncCallback<Void> callback = new AsyncCallback<Void>() {
			public void onFailure(Throwable caught) {
				// TODO: Do something with errors. (e.g. status message: not connected!)
			}
			public void onSuccess(Void result) {
				// TODO: Do something on success (e.g. status message: connected!)
			}
		};

		kbSvc.initializeKB(callback);
	}

	/**
	 * Navigation between pages
	 * @param activePage
	 */
	private void setActivePage(ActivePage activePage) {
		this.activePage = activePage;  

		switch (activePage) {
		case ABOUT:
			mainCenterPanel.clear();
			mainCenterPanel.add(aboutPanel);
			break;
		case SEARCH:
			mainCenterPanel.clear();
			mainCenterPanel.add(searchPanel);
			break;
		case BROWSE:
			mainCenterPanel.clear();
			mainCenterPanel.add(browsePanel);
			break;	
		case CONTACT:
			mainCenterPanel.clear();
			mainCenterPanel.add(contactPanel);
			break;
		default:
			break;
		}
	}

	/**
	 * Handle button pushing events
	 */
	public void onClick(ClickEvent event) {
		// note that in general, events can have sources that are not Widgets.
		Widget sender = (Widget) event.getSource();

		if (sender == headerPanel.getAboutButton()) {
			// about has been clicked. Show about panel. 
			setActivePage(ActivePage.ABOUT);
		} else if (sender == headerPanel.getSearchButton()) {
			//Search
			setActivePage(ActivePage.SEARCH);
		} else if (sender == headerPanel.getBrowseButton()) {
			//Browse
			setActivePage(ActivePage.BROWSE);
		}  else if (sender == headerPanel.getContactButton()) {
			//Contact
			setActivePage(ActivePage.CONTACT);
		}

	}


}
