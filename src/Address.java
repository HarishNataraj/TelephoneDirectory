
public class Address {
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String pincode;
	
	public Address(String addressLine1, String addressLine2, String city, String state, String pincode) {
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPincode() {
		return pincode;
	}
	
	
	
	

}
