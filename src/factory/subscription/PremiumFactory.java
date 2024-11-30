package factory.subscription;

import models.subscription.Premium;
import models.subscription.Subscription;

public class PremiumFactory extends SubscriptionFactory{

	@Override
	public Subscription createPremium(Integer ID, String title, Integer duration, Float price, String subscription) {
		// TODO Auto-generated method stub
		return new Premium(ID, title, duration, price, subscription);
	}


	
	@Override
	public Subscription createFree(Integer ID, String title, Integer duration, Float price) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("PremiumFactory cannot create Free");
	}

	

}
