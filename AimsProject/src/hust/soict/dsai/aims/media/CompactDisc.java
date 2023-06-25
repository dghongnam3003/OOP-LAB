package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	
	public CompactDisc(String artist, List<Track> tracks) {
		super();
		this.artist = artist;
		this.tracks = tracks;
	}
	public CompactDisc(String director, int length) {
		super(director, length);
		// TODO Auto-generated constructor stub
	}
	public CompactDisc(List<Track> tracks) {
		super();
		this.tracks = tracks;
	}
	public CompactDisc(String artist) {
		super();
		this.artist = artist;
	}
	public CompactDisc(String title, String category, String artist, Float cost) {
		super(title, category, cost);
		this.artist = artist;
	}
	
	public CompactDisc(String title, String category, Float cost) {
		super();
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
	}
	
	private static int nbCompactDiscs = 0;
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	public CompactDisc() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CompactDisc(String title, String category, float cost, ArrayList<Track> tracks, String artist) {
		super();
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
		this.setArtist(artist);
		this.setTracks(tracks);
	}
	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println("The track already in the list");
		} else tracks.add(track);
	}
	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
		} else System.out.println("The track not in the list");
	}
	
	public int getLength() { 
		int sumLen = 0;
		for (int i = 0; i < tracks.size(); i++) {
			sumLen += tracks.get(i).getLength();
		}
		return sumLen;
	}
	
	@Override
	public String toString() {
		return "CD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getLength() + " - " + this.getDirector() + ": " + this.getCost() + " $";
	}
	
	public boolean isMatch(String title) {
		return this.getTitle().equalsIgnoreCase(title);
	}
	
	public void play() {
		for (Track track : tracks) {
			track.play();
		}
	}
	public String playGUI() throws NullPointerException {
		String CDPlay = "";
		if (this.tracks == null) {
			return "Cannot play this CD";
		} else {
			for (Track track : tracks) {
				CDPlay += track.playGUI();
			}
			
			return CDPlay;
		}
	}
	public List<Track> getTracks() {
		return tracks;
	}
	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
}
