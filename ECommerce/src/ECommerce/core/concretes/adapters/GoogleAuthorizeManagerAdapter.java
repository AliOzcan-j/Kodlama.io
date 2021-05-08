package ECommerce.core.concretes.adapters;

import ECommerce.core.abstracts.AuthorizeService;
import ECommerce.googleAuth.GoogleAuthorizeManager;

public class GoogleAuthorizeManagerAdapter implements AuthorizeService{
	
	private GoogleAuthorizeManager googleAuthorizeManager;
	
	public GoogleAuthorizeManagerAdapter(GoogleAuthorizeManager googleAuthorizeManager) {
		super();
		this.googleAuthorizeManager = googleAuthorizeManager;
	}

	@Override
	public Boolean AuthrizeUser() {		
		return googleAuthorizeManager.AuthorizeUser();
	}

}
