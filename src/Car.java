import java.util.Date;


public class Car {
	private String pelakNumber;
	private String pelakSeries;
	private String ensuranceCode;
	private Date startDate;
	private Date finishDate;
	private String ITINumber;
	private Date ITIfinish;
	private String measuranceCode;
	private Person Driver;
	private String desc;
	
	Car(String pn, String ps){
		pelakNumber = pn;
		pelakSeries = ps;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public String getITINumber() {
		return ITINumber;
	}

	public void setITINumber(String iTINumber) {
		ITINumber = iTINumber;
	}

	public Date getITIfinish() {
		return ITIfinish;
	}

	public void setITIfinish(Date iTIfinish) {
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

	public void setDriver(Person driver) {
		Driver = driver;
	}
	
	
	
	
	
}
