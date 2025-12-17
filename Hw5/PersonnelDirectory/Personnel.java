import java.util.*;
public class Personnel {

	private ArrayList<Person> personList;

	public Personnel()
    {
	   personList = new ArrayList<Person>();
	}

	public void addPersonnel(Person p)
	{
		personList.add(p);
	}

    public Person findPerson(String firstN, String lastN) {
        for (int i = 0; i < personList.size(); i++) {
            Person p = personList.get(i);
            if (p.getFirst().equals(firstN) && p.getLast().equals(lastN)) {
                return p;
            }
        }
        return null;
    }

    public int getTotalCount() {
        return personList.size();
    }

    public ArrayList<Person> getAllPersonnel() {
        return personList;
    }

}