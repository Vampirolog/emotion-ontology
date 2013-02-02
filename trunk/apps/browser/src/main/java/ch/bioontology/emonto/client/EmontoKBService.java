package ch.bioontology.emonto.client;

import ch.bioontology.emonto.shared.EmontoTerm;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("kbService")
public interface EmontoKBService extends RemoteService {

	public EmontoTerm[] getAllTerms();
		
	public EmontoTerm[] getTerms(String[] symbols);

	public void initializeKB();
	
}
