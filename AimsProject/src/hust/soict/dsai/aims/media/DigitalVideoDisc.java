package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
	}
	public DigitalVideoDisc(String title) {
		super();
		
		this.setTitle(title);
	}
	public DigitalVideoDisc(int id) {
		super();
		this.setId(id);
	}
	
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
		
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
		this.director = director;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
		this.director = director;
		this.length = length;
	}
	
	@Override
	public String toString() {
		return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.director + " - " + this.length + ": " + this.getCost() + " $";
	}
	public boolean isMatch(String title) {
		return this.getTitle().equalsIgnoreCase(title);
	}
	public void play() throws PlayerException {
		if (this.length > 0 ) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
	}
	
	public String playGUI() throws PlayerException {
		if (this.getLength() > 0) {
			//return "<html>Playing DVD:...<html"
			return "Playing DVD: " + this.getTitle() + "\n" + "DVD length: " + this.getLength();
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
	}
}
