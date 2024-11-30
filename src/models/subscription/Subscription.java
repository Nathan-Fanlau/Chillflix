package models.subscription;

public abstract class Subscription {
	private Integer ID;
	private String title;
	private Integer duration;
	private Float price;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Subscription(Integer iD, String title, Integer duration, Float price) {
		super();
		ID = iD;
		this.title = title;
		this.duration = duration;
		this.price = price;
	}
	
	
	
	
	
}
