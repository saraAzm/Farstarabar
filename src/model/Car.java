package model;

import java.time.LocalDate;
import java.util.Date;


public class Car {
	private String pelakNumber = new String();
	private String pelakSeries = new String();
	private String ensuranceCode;
	private LocalDate startDate;
	private LocalDate finishDate;
	private String ITINumber;
	private LocalDate ITIfinish;
	private String measuranceCode;
	private Person Driver;
	private String desc;
        public String driverName;
        private int ID;

    
	public Car(String pn, String ps, String ensrCode, LocalDate ensStDate, LocalDate ensEndDate,
                String itiNm, LocalDate itiFnm, String measureCode, Person dr, String ds){
		this.pelakNumber = pn;
		this.pelakSeries = ps;
                this.ensuranceCode = ensrCode;
                this.startDate = ensStDate;
                this.finishDate = ensEndDate;
                this.ITINumber = itiNm;
                this.ITIfinish = itiFnm;
                this.measuranceCode = measureCode;
                this.Driver = dr;
                if(this.Driver != null){
                    this.driverName = this.Driver.getFirstName().
                            concat(" ").concat(this.Driver.getLastName());
                }
                this.desc = ds;
                this.ID = Database.database.addCar(this);
                
	}
        
        public Car(String pn, String ps, String ensrCode, LocalDate ensStDate, LocalDate ensEndDate,
                String itiNm, LocalDate itiFnm, String measureCode, Person dr, String ds, boolean flag){
		this.pelakNumber = pn;
		this.pelakSeries = ps;
                this.ensuranceCode = ensrCode;
                this.startDate = ensStDate;
                this.finishDate = ensEndDate;
                this.ITINumber = itiNm;
                this.ITIfinish = itiFnm;
                this.measuranceCode = measureCode;
                this.Driver = dr;
                this.desc = ds;
                this.driverName = null;
                if(this.Driver != null){
                    this.driverName = this.Driver.getFirstName().
                            concat(" ").concat(this.Driver.getLastName());
                }
                
                if(flag)
                    this.ID = Database.database.addCar(this);
                
	}
        
        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        
	public String getPelakNumber() {
		return pelakNumber;
	}

	public void setPelakNumber(String pelakNumber) {
		this.pelakNumber = pelakNumber;
	}

	public String getPelakSeries() {
		return pelakSeries;
	}

	public void setPelakSeries(String pelakSeries) {
		this.pelakSeries = pelakSeries;
	}

	public String getEnsuranceCode() {
		return ensuranceCode;
	}

	public void setEnsuranceCode(String ensuranceCode) {
		this.ensuranceCode = ensuranceCode;
	}

	public LocalDate getStartDate() {
		return startDate;
	}
       
        
        
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
	}

	public String getITINumber() {
		return ITINumber;
	}

	public void setITINumber(String iTINumber) {
		ITINumber = iTINumber;
	}

	public LocalDate getITIfinish() {
		return ITIfinish;
	}

	public void setITIfinish(LocalDate iTIfinish) {
		ITIfinish = iTIfinish;
	}

	public String getMeasuranceCode() {
            return measuranceCode;
	}

	public void setMeasuranceCode(String measuranceCode) {
            this.measuranceCode = measuranceCode;
	}

	public Person getDriver() {
            return Driver;
	}

        public String getDriverName() {
            return driverName;
        }
        
	public void setDriver(Person driver) {
                this.driverName = null;
                this.Driver = driver;
                if(this.Driver != null){
                    this.driverName = this.Driver.getFirstName().
                            concat(" ").concat(this.Driver.getLastName());
                }
		
	}
	
	
        public String getDesc() {
            return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    @Override
    public String toString(){
        return this.pelakNumber.concat(" ").concat(this.pelakSeries);
    }
	
	
}
