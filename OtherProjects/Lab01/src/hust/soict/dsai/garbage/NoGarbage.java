package hust.soict.dsai.garbage;

public class NoGarbage {
	public static void main(String[] args) {
		String s = "garbage";
		while (true) {
			String unused = s;
		}
	}
}
