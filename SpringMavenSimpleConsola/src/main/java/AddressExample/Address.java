package AddressExample;

public class Address {
	
	private Long id;
	private String street;
	private String postCode;
	
	public Address() {
		super();
	}
	
	public Address(Long id, String street, String postCode) {
		super();
		this.id = id;
		this.street = street;
		this.postCode = postCode;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", postCode=" + postCode + "]";
	}
}
