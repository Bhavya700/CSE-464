public class Person {
    private String last;
    private String first;
    private String middle;


	public Person(String last, String first, String middle) {
		this.last = last;
		this.first = first;
		this.middle = middle;

	}

    public String getLast() { return last; }
    public String getFirst() { return first; }
    public String getMiddle() { return middle; }

    public String FIRST_MIDDLE_LAST() {
        return first + " " + middle + " " + last;
    }

    public String LAST_MIDDLE_FIRST() {
        return last + ", " + middle + " " + first;
    }

    public String LAST_FIRST_MIDDLE() {
        return last + ", " + first + " " + middle;
    }
}
