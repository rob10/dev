
public class TVShow {

	private String title;
	private String director;
	private String mainStar;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getMainStar() {
		return mainStar;
	}
	public void setMainStar(String mainStar) {
		this.mainStar = mainStar;
	}
	@Override
	public String toString() {
		return "title=" + title + "\ndirector=" + director + "\nmainStar=" + mainStar;
	}
	
	
	
	
	
}
