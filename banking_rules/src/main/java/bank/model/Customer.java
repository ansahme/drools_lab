package bank.model;

import java.util.Date;

public class Customer {
	
	private static String phoneNumber;
	
	private String firstName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public long getUuid() {
		return uuid;
	}
	public void setUuid(long uuid) {
		this.uuid = uuid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Account getAccounts() {
		return accounts;
	}
	public void setAccounts(Account accounts) {
		this.accounts = accounts;
	}
	public static String getPhoneNumber() {
		return phoneNumber;
	}
	public static void setPhoneNumber(String phoneNumber) {
		Customer.phoneNumber = phoneNumber;
	}
	private String lastName;
	private Date dateOfBirth;
	private long uuid;
	private String email;
	private Address address;
	private Account accounts;

}
