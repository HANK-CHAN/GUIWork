package Web;

public class List {
	
	private String title;
	private String date;
	private String story;
	private String link;
	
	
	public List(String title,String date, String story,String link) {
		this.title= title;
		this.date = date;
		this.story = story;
		this.link = link;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		link = link;
	}
	
	
}
