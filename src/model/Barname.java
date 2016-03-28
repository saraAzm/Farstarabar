package model;

import java.time.LocalDate;
import java.util.Date;


public class Barname {
	private LocalDate initiateDate;
        public String initiateDateString;
	private Car carInc;
	private Person owner;
	private String destination;
	private String source;
	public String bijak;
        public String ownerName;
        public String pelakNumber;
	private double distance;
	private double weightSource;
	private double weightDest;
	private int price;
        private String ID;
        
        
        public Barname(LocalDate initDate, Car car, Person own, String dst, 
                String src, double dist, double wSrc, double wDest, int pr){
            this.initiateDate = initDate;
            this.carInc = car;
            this.owner = own;
            this.destination = dst;
            this.source = src;
            this.distance = dist;
            this.weightSource = wSrc;
            this.weightDest = wDest;
            this.price = pr;
            this.initiateDateString = initDate.toString();
            
            this.ownerName = this.owner.getFirstName().concat(" ").concat(
                                this.owner.getLastName());
            
            this.pelakNumber = this.carInc.getPelakNumber().concat(" ").concat(
                                   this.carInc.getPelakSeries());
            
            Database.database.addBarname(this);
        }
        
	public LocalDate getInitiateDate() {
		return initiateDate;
	}
	public void setInitiateDate(LocalDate initiateDate) {
		this.initiateDate = initiateDate;
	}
	public Car getCarInc() {
		return carInc;
	}
	public void setCarInc(Car carInc) {
		this.carInc = carInc;
                this.pelakNumber = this.carInc.getPelakNumber().concat(" ").concat(
                                   this.carInc.getPelakSeries());
	}
	public Person getOwner() {
		return owner;
	}
	public void setOwner(Person owner) {
		this.owner = owner;
                this.ownerName = this.owner.getFirstName().concat(" ").concat(
                                this.owner.getLastName());
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
