import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;

public class Application {
	static Scanner scanner = new Scanner(System.in);
	private static Contact contact;
	private static Address contactAddress;
	private static Directory directory = new Directory();
	private static DirectoryOperations directoryOperations;

	public static void main(String[] args) {
		int option = 0;
		long phoneNumber;
		String name;
		String addressLine1;
		String addressLine2;
		String city;
		String state;
		String pincode;

		printmenu();

		while (true) {
			System.out.println("Enter option : ");
			option = scanner.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter phone number");
				phoneNumber = scanner.nextLong();
				scanner.nextLine();
				System.out.println("Enter Name");
				name = scanner.nextLine();
				System.out.println("Enter addressline 1");
				addressLine1 = scanner.nextLine();
				System.out.println("Enter addressline 2");
				addressLine2 = scanner.nextLine();
				System.out.println("Enter city");
				city = scanner.nextLine();
				System.out.println("Enter State");
				state = scanner.nextLine();
				System.out.println("Enter pincode");
				pincode = scanner.nextLine();
				if (addNewContact(phoneNumber, name, new Address(addressLine1, addressLine2, city, state, pincode))) {
					System.out.println("Contact added successfully");
				} else {
					System.out.println("Contact with same phone number already present");
				}
				break;
			case 2:
				SortedMap<Long, Contact> contacts = directory.getContacts();
				printDirectory(contacts);
				break;
			case 3:
				directoryOperations = new SearchContact();
				System.out.println("Enter phone number");
				phoneNumber = scanner.nextLong();
				contact = directoryOperations.performOperation(phoneNumber, directory);
				if(contact == null) {
					System.out.println("Contact not found");
				} else {
					contactAddress = contact.getAddress();
					System.out.println(phoneNumber + "---------->" + contact.getName() + "\n" + "Address:\n"
							+ contactAddress.getAddressLine1() + "\n" + contactAddress.getAddressLine2() + "\n"
							+ contactAddress.getCity() + "\n" + contactAddress.getState() + "\n"
							+ contactAddress.getPincode());
					System.out.println("..............................................................................");
				}
				break;
			case 4:
				directoryOperations = new DeleteContact();
				System.out.println("Enter phone number");
				phoneNumber = scanner.nextLong();
				contact = directoryOperations.performOperation(phoneNumber, directory);
				if(contact == null) {
					System.out.println("Contact not present");
				} else {
					System.out.println("Contact deleted successfully");
				}
				break;
			default:
				System.out.println("Invalid option");
				printmenu();
				break;
			}
		}

	}

	private static void printDirectory(SortedMap<Long, Contact> contacts) {
		if (contacts.isEmpty()) {
			System.out.println("Empty directory");
		} else {
			for (Map.Entry<Long, Contact> m : contacts.entrySet()) {
				contact = m.getValue();
				contactAddress = contact.getAddress();
				System.out.println(m.getKey() + "---------->" + contact.getName() + "\n" + "Address:\n"
						+ contactAddress.getAddressLine1() + "\n" + contactAddress.getAddressLine2() + "\n"
						+ contactAddress.getCity() + "\n" + contactAddress.getState() + "\n"
						+ contactAddress.getPincode());
				System.out.println("..............................................................................");
			}
		}

	}

	private static void printmenu() {
		System.out.println("1.Add new contact \n" + "2.Get directory \n" + "3.Search Contact \n" + "4.Delete Contact");
	}

	private static boolean addNewContact(long phoneNumber, String name, Address address) {
		contact = new Contact(name, address);
		return directory.addContact(contact, phoneNumber);

	}

}
