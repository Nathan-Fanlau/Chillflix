package factory.content;

import models.content.Content;

public abstract class ContentFactory {
	
	
	public abstract Content createMovie(Integer ID, String title, Integer duration, String genre, String director, String releaseDate, Float rating);
	
	public abstract Content createShow(Integer ID, String title, Integer duration, String genre, Integer season, Integer episode, Integer current);
	
}
