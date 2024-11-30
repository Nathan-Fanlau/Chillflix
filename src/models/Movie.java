package models;

public class Movie extends Content{
	private String director;
	private String releaseDate;
	private Float rating;
	
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Float getRating() {
		return rating;
	}
	public void setRating(Float rating) {
		this.rating = rating;
	}
	
	public Movie(Integer iD, String title, Integer duration, String genre, String director, String releaseDate,
			Float rating) {
		super(iD, title, duration, genre);
		this.director = director;
		this.releaseDate = releaseDate;
		this.rating = rating;
	}
	
}
