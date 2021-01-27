import java.util.SortedMap;
import java.util.TreeMap;

public class Directory {
	private SortedMap<Long, Contact> contacts;
	
	public Directory() {
		contacts = new TreeMap<>();
	}

	public SortedMap<Long, Contact> getContacts() {
		return contacts;
	}
	
	public boolean addContact(Contact contact,long phoneNumber) {
		if(contacts.containsKey(phoneNumber)) {
			return false;
		} 
		contacts.put(phoneNumber, contact);
		return true;
	}
}
