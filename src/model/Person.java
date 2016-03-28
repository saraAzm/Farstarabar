package model;

import Database.database;
import java.time.LocalDate;
import java.util.Date;


public class Person {
	private String firstName = new String();
	private String lastName = new String();
	private String nationCode;
	private String phoneNumber;
	private LocalDate birthday;
	private String desc;
	private BankAccount account;
        
        public Person(String first, String last, String nationCode, String phone, LocalDate birthday, String ds){
            this.firstName = first;
            this.lastName = last;
            this.nationCode = nationCode;
            this.phoneNumber = phone;
            this.birthday = birthday;
            this.desc = ds;
            //this.account = here we introduce an account our self!
            database.addPerson(this);
        }
        
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
	public String getNationCode() {
		return nationCode;
	}
	public void setNationCode(String nationCode) {
		this.nationCode = nationCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
        
        
        @Override
        public String toString(){
            return this.firstName.concat(" ").concat(this.lastName);
        }
	
}
