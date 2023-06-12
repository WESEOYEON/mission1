package example;


public class run {
	public void update() {
		long lastNum = JsonParsing.getFinal();
		wifi.delete();
		int first = 1;
		int last = 1000;
		JsonParsing.addDB(first, last);
		while (last <= lastNum && first <= lastNum) {
		JsonParsing.addDB(first, last);
		first = first+1000;
		last = last+1000;
			if (last>lastNum) {
				last = (int)lastNum;
			}
		}
	}
}
