package factory;

import models.Content;
import models.Movie;

public class MovieFactory extends ContentFactory{

	@Override
	public Content createMovie(Integer ID, String title, Integer duration, String genre, String director,
			String releaseDate, Float rating) {
		// TODO Auto-generated method stub
		return new Movie(ID, title, duration, genre, director, releaseDate, rating);
	}

	@Override
	public Content createShow(Integer ID, String title, Integer duration, String genre, Integer season, Integer episode,
			Integer current) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("MovieFactory cannot create shows.");
	}

	

}
