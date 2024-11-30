package factory;

import models.Content;
import models.Show;

public class ShowFactory extends ContentFactory{

	@Override
	public Content createMovie(Integer ID, String title, Integer duration, String genre, String director,
			String releaseDate, Float rating) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("ShowFactory cannot create shows.");
	}

	@Override
	public Content createShow(Integer ID, String title, Integer duration, String genre, Integer season, Integer episode,
			Integer current) {
		// TODO Auto-generated method stub
		return new Show(ID, title, duration, genre, season, episode, current);
	}

}
