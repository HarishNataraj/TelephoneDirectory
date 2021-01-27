import java.util.SortedMap;

public class SearchContact implements DirectoryOperations {

	@Override
	public Contact performOperation(long phoneNumber, Directory directory) {
		SortedMap<Long, Contact> contactsMap = directory.getContacts();
		return contactsMap.get(phoneNumber);
	}

}
