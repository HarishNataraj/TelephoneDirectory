
public class DeleteContact implements DirectoryOperations {

	@Override
	public Contact performOperation(long phoneNumber, Directory directory) {
		return directory.getContacts().remove(phoneNumber);	
	}

}
