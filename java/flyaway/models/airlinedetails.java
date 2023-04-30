package flyaway.models;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;


@Entity
//@Table(name="airlinedetails")
public class airlinedetails {

	@Id
	@Column(name = "airlineindex")
	private String airlineindex;	
	@Column(name="airlinename")
	private String airlinename;
	@Column(name="airlinetype")
	private String airlinetype;
	@Column(name="seatingcapacity")
	private int seatingcapacity;
	

	public airlinedetails() {
		
		// TODO Auto-generated constructor stub
	}


	public String getAirlineindex() {
		return airlineindex;
	}

	public void setAirlineindex(String airlineindex) {
		this.airlineindex = airlineindex;
	}

	public String getAirlinename() {
		return airlinename;
	}

	public void setAirlinename(String airlinename) {
		this.airlinename = airlinename;
	}

	public int getSeatingcapacity() {
		return seatingcapacity;
	}

	public void setSeatingcapacity(int seatingcapacity) {
		this.seatingcapacity = seatingcapacity;
	}


	public String getAirlinetype() {
		return airlinetype;
	}

	public void setAirlinetype(String airlinetype) {
		this.airlinetype = airlinetype;
	}


	
	
	
}
