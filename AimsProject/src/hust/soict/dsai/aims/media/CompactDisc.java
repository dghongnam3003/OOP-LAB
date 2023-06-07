package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}
	public String getArtist() {
		return artist;
	}
	public CompactDisc (String artist, List<Track> tracks) {
		super();
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public void addTrack(Track track) {
		for (int i = 0; i < tracks.size(); i++) {
			if (tracks.get(i).equals(track)) {
				System.out.println("the track already exists in the list");
			}
			else {
				tracks.add(track);
			}
		}
	}
	public void removeTrack(Track track) {
		for (int i = 0; i < tracks.size(); i++) {
			if (tracks.get(i).equals(track)) {
				tracks.remove(i);
			}
			else {
				System.out.println("track not in the list");
			}
		}
	}
	
	public int getLength() { 
		int sumLen = 0;
		for (int i = 0; i < tracks.size(); i++) {
			sumLen += tracks.get(i).getLength();
		}
		return sumLen;
	}
	
	public void play() {
		for (Track track : tracks) {
			track.play();
		}
	}
}
