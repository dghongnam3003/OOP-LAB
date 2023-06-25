package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {

	public Media(String title, String category, float cost) {
		super();
		this.id = nbMedias++;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	private static int nbMedias = 1;
	private int id;
	private String title;
	private String category;
	private float cost;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	public Media() {
		super();
		this.id = nbMedias++;
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public abstract boolean isMatch(String titleToSearch);
	
	public abstract String toString();
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Media otherMedia = (Media) obj;
	    return title.equals(otherMedia.title);
	}

}
