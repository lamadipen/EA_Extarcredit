package edu.mum.hw2.domain;

import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
public class Beneficiary {

	private String name;
	private String city;
	private String phone;
	@Lob
	private byte[] pic;
	
	public Beneficiary() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

}
