package models.content;

public abstract class Content {
	private Integer ID;
	private String title;
	private Integer duration;
	private String genre;
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
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Content(Integer iD, String title, Integer duration, String genre) {
		super();
		ID = iD;
		this.title = title;
		this.duration = duration;
		this.genre = genre;
	}
	
	
}
