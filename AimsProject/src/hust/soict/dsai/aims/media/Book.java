package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	
	private List<String> authors = new ArrayList<String>();
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	public void addAuthor(String authorName) {
		for (int i = 0; i < authors.size(); i++) {
			if (authors.get(i).equals(authorName)) {
				System.out.println("the author already exists in the list");
			}
			else {
				authors.add(authorName);
			}
		}
	}
	public void removeAuthor(String authorName) {
		for (int i = 0; i < authors.size(); i++) {
			if (authors.get(i).equals(authorName)) {
				authors.remove(i);
			}
			else {
				System.out.println("The author is not in the list");
			}
		}
	}

}