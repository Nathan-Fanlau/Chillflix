package models;

public class Show extends Content{
	
	private Integer seasons;
	private Integer episodes;
	private Integer current;
	
	public Integer getSeasons() {
		return seasons;
	}
	public void setSeasons(Integer seasons) {
		this.seasons = seasons;
	}
	public Integer getEpisodes() {
		return episodes;
	}
	public void setEpisodes(Integer episodes) {
		this.episodes = episodes;
	}
	public Integer getCurrent() {
		return current;
	}
	public void setCurrent(Integer current) {
		this.current = current;
	}
	
	public Show(Integer iD, String title, Integer duration, String genre, Integer seasons, Integer episodes,
			Integer current) {
		super(iD, title, duration, genre);
		this.seasons = seasons;
		this.episodes = episodes;
		this.current = current;
	}
	
	
	
	
	
	
}
