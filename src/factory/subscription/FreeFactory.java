package factory.subscription;

import models.subscription.Free;
import models.subscription.Subscription;

public class FreeFactory extends SubscriptionFactory{

	@Override
	public Subscription createPremium(Integer ID, String title, Integer duration, Float price, String subscription) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("FreeFactory cannot create Premium");
	}

	
	
	@Override
	public Subscription createFree(Integer ID, String title, Integer duration, Float price) {
		// TODO Auto-generated method stub
		return new Free(ID, title, duration, price);
	}

}
