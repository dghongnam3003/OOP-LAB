package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {
	
	private String title;
	private int length;
	
	public Track() {
		// TODO Auto-generated constructor stub
	}
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}
	
	public void play() throws PlayerException {
		if (this.length > 0) {
			System.out.println("Playing CD: " + this.getTitle());
			System.out.println("CD length: " + this.getLength());
		} else {
			throw new PlayerException("ERROR: Track length is non-positive!");
		}
	}
	
	public String playGUI() throws PlayerException {
		if (this.getLength() > 0) {
			return "Playing track: " + this.getTitle() + " - Track length: " + this.getLength() + "\n";
		} else {
			throw new PlayerException("ERROR: Track length is non-positive!");
		}
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Track otherTrack = (Track) obj;
	    return title.equals(otherTrack.title) && length == otherTrack.length;
	}

}
