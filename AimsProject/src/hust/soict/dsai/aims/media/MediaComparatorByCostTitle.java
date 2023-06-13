package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

	public int compare(Media media1, Media media2) {
		int costCompare = Float.compare(media2.getCost(), media1.getCost());
		if (costCompare == 0) {
			return media1.getTitle().compareTo(media2.getTitle());
		}
		return costCompare;
	}

}
