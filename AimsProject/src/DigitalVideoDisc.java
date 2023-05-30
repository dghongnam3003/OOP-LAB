
public class DigitalVideoDisc {
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.id = ++nbDigitalVideoDiscs;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title) {
		super();
		this.id = ++nbDigitalVideoDiscs;
		this.title = title;
	}
	public DigitalVideoDisc(int id) {
		super();
		this.id = id;
	}
	
	private static int nbDigitalVideoDiscs = 0;
	private int id;
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.id = ++nbDigitalVideoDiscs;
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.id = ++nbDigitalVideoDiscs;
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
}
