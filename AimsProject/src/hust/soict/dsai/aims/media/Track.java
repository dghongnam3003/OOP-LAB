package hust.soict.dsai.aims.media;

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
	
	public void play() {
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("CD length: " + this.getLength());
	}
	
	public String playGUI() {
		if (this.getLength() > 0) {
			return "Playing track: " + this.getTitle() + " - Track length: " + this.getLength() + "\n";
		} else {
			return "Cannot play this track";
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
