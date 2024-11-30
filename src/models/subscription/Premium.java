package models.subscription;

public class Premium extends Subscription{
	private String subscription;

	public String getSubscription() {
		return subscription;
	}

	public void setSubscription(String subscription) {
		this.subscription = subscription;
	}

	public Premium(Integer iD, String title, Integer duration, Float price, String subscription) {
		super(iD, title, duration, price);
		this.subscription = subscription;
	}
	
	
	
	
}
