package ch.bioontology.emonto.client;

import ch.bioontology.emonto.shared.EmontoTerm;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface EmontoKBServiceAsync {

	void initializeKB(AsyncCallback<Void> callback);

	void getAllTerms(AsyncCallback<EmontoTerm[]> callback);

	void getTerms(String[] symbols, AsyncCallback<EmontoTerm[]> callback);

}
