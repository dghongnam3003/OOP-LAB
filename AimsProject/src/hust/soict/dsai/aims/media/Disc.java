package hust.soict.dsai.aims.media;

public class Disc extends Media {
	
	private String director;
	private int length;
	
	public Disc() {
		// TODO Auto-generated constructor stub
	}
	public Disc(String director, int length) {
		super();
		this.length = length;
		this.director = director;
	}
	public Disc(String title, String category, Float cost){
		super(title, category, cost);
	}
	
	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}
	
	public String toString() {
		return null;
	}

	@Override
	public boolean isMatch(String titleToSearch) {
		return false;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setLength(int length) {
		this.length = length;
	}

}
