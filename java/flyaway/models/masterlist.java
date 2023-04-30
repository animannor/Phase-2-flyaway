package flyaway.models;


import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
//@Table(name="masterlist")
public class masterlist {
	
	@Id
	private String flightindex;
	private String departure;
	private String destination;
	private String airlinename;
	private String aircrafttype;	
	private double flightprice;
	private int avaiableseats;
	private String dday;
	private String dhour;
	


	public masterlist() {
		// TODO Auto-generated constructor stub
	}
	
    
	public String getAirlinename() {
		return airlinename;
	}


	public void setAirlinename(String airlinename) {
		this.airlinename = airlinename;
	}


	public String getAircrafttype() {
		return aircrafttype;
	}




	public void setAircrafttype(String aircrafttype) {
		this.aircrafttype = aircrafttype;
	}




	public String getFlightindex() {
		return flightindex;
	}

	public void setFlightindex(String flightindex) {
		this.flightindex = flightindex;
	}



	public double getFlightprice() {
		return flightprice;
	}

	public void setFlightprice(double flightprice) {
		this.flightprice = flightprice;
	}

	public int getAvaiableseats() {
		return avaiableseats;
	}

	public void setAvaiableseats(int avaiableseats) {
		this.avaiableseats = avaiableseats;
	}



	public String getDday() {
		return dday;
	}



	public void setDday(String dday) {
		this.dday = dday;
	}



	public String getDhour() {
		return dhour;
	}


   public void setDhour(String dhour) {
		this.dhour = dhour;
	}

public String getDeparture() {
	return departure;
}


public void setDeparture(String departure) {
	this.departure = departure;
}


public String getDestination() {
	return destination;
}


public void setDestination(String destination) {
	this.destination = destination;
}


@Override
public String toString() {
	return "masterlist [flightindex=" + flightindex + ", departure=" + departure + ", destination=" + destination
			+ ", airlinename=" + airlinename + ", aircrafttype=" + aircrafttype + ", flightprice=" + flightprice
			+ ", avaiableseats=" + avaiableseats + ", dday=" + dday + ", dhour=" + dhour + "]";
}


	
}
