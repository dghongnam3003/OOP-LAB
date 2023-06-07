package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.setId(++nbDigitalVideoDiscs);
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
	}
	public DigitalVideoDisc(String title) {
		super();
		this.setId(++nbDigitalVideoDiscs);
		this.setTitle(title);
	}
	public DigitalVideoDisc(int id) {
		super();
		this.setId(id);
	}
	
	private static int nbDigitalVideoDiscs = 0;
	private String director;
	private int length;
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.setId(++nbDigitalVideoDiscs);
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
		this.director = director;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.setId(++nbDigitalVideoDiscs);
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
		this.director = director;
		this.length = length;
	}
	public String toString() {
		return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.director + " - " + this.length + ": " + this.getCost() + " $";
	}
	public boolean isMatch(String title) {
		return this.getTitle().equalsIgnoreCase(title);
	}
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}