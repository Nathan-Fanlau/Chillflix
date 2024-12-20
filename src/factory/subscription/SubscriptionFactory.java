package factory.subscription;

import models.subscription.Subscription;

public abstract class SubscriptionFactory {
	public abstract Subscription createPremium(Integer ID, String title, Integer duration, Float price, String Subscription);
	public abstract Subscription createFree(Integer ID, String title, Integer duration, Float price);
}
