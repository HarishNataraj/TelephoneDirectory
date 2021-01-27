
public class Contact {
	private String name;
	private Address address;
	
	public Contact(String name, Address address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}
	
}
