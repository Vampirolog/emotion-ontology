package ch.bioontology.emonto.client;

import java.util.Arrays;

import ch.bioontology.emonto.shared.EmontoTerm;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EmontoSearchPanel extends VerticalPanel {

	private TextBox searchBox;
	private Button searchButton;
	private HorizontalPanel searchPanel;
	
	private EmontoTerm[] searchResults;
	private CellTable<EmontoTerm> searchResultsTable;
	private ScrollPanel searchResultsScrollPanel;
	
	private EmontoKBServiceAsync kbSvc = GWT.create(EmontoKBService.class);

	public EmontoSearchPanel() {
		super();

		searchBox = new TextBox();
		searchButton = new Button("Search");
		searchButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				AsyncCallback<EmontoTerm[]> callback = new AsyncCallback<EmontoTerm[]>() {
					public void onFailure(Throwable caught) {
						// TODO: Do something with errors!
					}
					public void onSuccess(EmontoTerm[] result) {
						if (result != null) {
							searchResults = result;
							buildResultTable();
						}
					}
				};
				//Do the search
				kbSvc.getTerms(new String[] {searchBox.getText()}, callback);
			}
		});

	    searchResultsTable = new CellTable<EmontoTerm>();
//	    searchResultsTable.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

	    TextColumn<EmontoTerm> idColumn = new TextColumn<EmontoTerm>() {
	    	@Override
	    	public String getValue(EmontoTerm object) {
	    		return object.getId();
	    	}
	    };
	    searchResultsTable.addColumn(idColumn, "ID");

	    TextColumn<EmontoTerm> nameColumn = new TextColumn<EmontoTerm>() {
	    	@Override
	    	public String getValue(EmontoTerm object) {
	    		return object.getLabel();
	    	}
	    };
	    searchResultsTable.addColumn(nameColumn, "Name");	   

	    TextColumn<EmontoTerm> definitionColumn = new TextColumn<EmontoTerm>() {
	    	@Override
	    	public String getValue(EmontoTerm object) {
	    		return object.getDefinition();
	    	}
	    };
	    searchResultsTable.addColumn(definitionColumn, "Definition");
	    
	    searchResultsTable.setVisible(false);

//	    // Add a selection model to handle user selection.
//	    final SingleSelectionModel<Contact> selectionModel = new SingleSelectionModel<Contact>();
//	    table.setSelectionModel(selectionModel);
//	    selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
//	      public void onSelectionChange(SelectionChangeEvent event) {
//	        Contact selected = selectionModel.getSelectedObject();
//	        if (selected != null) {
//	          Window.alert("You selected: " + selected.name);
//	        }
//	      }
//	    });

	    searchResultsScrollPanel = new ScrollPanel(searchResultsTable);
	    searchResultsScrollPanel.setAlwaysShowScrollBars(false);
	    searchResultsScrollPanel.setSize("800px", "400px");
	    searchResultsScrollPanel.setVisible(true);

		searchPanel = new HorizontalPanel();
		searchPanel.add(searchBox);
		searchPanel.add(searchButton);

		add(searchPanel);
		add(searchResultsScrollPanel);

	}

	private void buildResultTable() {
		//need to think a bit how to store search results
		//search can return: emotions, appraisals, feelings etc. 
		//do we display these differently? 
		
	    // Set the total row count. This isn't strictly necessary, but it affects
	    // paging calculations, so its good habit to keep the row count up to date.
	    searchResultsTable.setRowCount(searchResults.length, true);

	    // Push the data into the widget.
	    searchResultsTable.setRowData(0, Arrays.asList(searchResults));

	    searchResultsTable.setVisible(true);
	    
	}


	public Button getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(Button searchButton) {
		this.searchButton = searchButton;
	}

	public TextBox getSearchBox() {
		return searchBox;
	}

	public void setSearchBox(TextBox searchBox) {
		this.searchBox = searchBox;
	}



}
