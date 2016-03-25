package model;

import java.util.Date;


public class Barname {
	private Date initiateDate;
	private Car carInc;
	private Person owner;
	private String destination;
	private String source;
	private String bijak;
	private double distance;
	private double weightSource;
	private double weightDest;
	private int price;
	public Date getInitiateDate() {
		return initiateDate;
	}
	public void setInitiateDate(Date initiateDate) {
		this.initiateDate = initiateDate;
	}
	public Car getCarInc() {
		return carInc;
	}
	public void setCarInc(Car carInc) {
		this.carInc = carInc;
	}
	public Person getOwner() {
		return owner;
	}
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getBijak() {
		return bijak;
	}
	public void setBijak(String bijak) {
		this.bijak = bijak;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getWeightSource() {
		return weightSource;
	}
	public void setWeightSource(double weightSource) {
		this.weightSource = weightSource;
	}
	public double getWeightDest() {
		return weightDest;
	}
	public void setWeightDest(double weightDest) {
		this.weightDest = weightDest;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
