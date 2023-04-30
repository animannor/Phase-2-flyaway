package flyaway.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
public class reservation {

	
	@Id
	@Column(name = "Rvnumid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Rvnumid;
	@Column(name = "flightindex")
	private String flightindex;
	@Column(name="passengername")
	private String passengername;
	
	
	public reservation() {
		// TODO Auto-generated constructor stub
	}

	public reservation(int rvnumid, String flightindex, String passengername, String bookingtime, String emergencyc) {
		super();
		Rvnumid = rvnumid;
		this.flightindex = flightindex;
		this.passengername = passengername;
		
	}

	public int getRvnumid() {
		return Rvnumid;
	}

	public void setRvnumid(int rvnumid) {
		Rvnumid = rvnumid;
	}

	public String getFlightindex() {
		return flightindex;
	}

	public void setFlightindex(String flightindex) {
		this.flightindex = flightindex;
	}

	public String getPassengername() {
		return passengername;
	}

	public void setPassengername(String passengername) {
		this.passengername = passengername;
	}

	@Override
	public String toString() {
		return "reservation [Rvnumid=" + Rvnumid + ", flightindex=" + flightindex + ", passengername=" + passengername
				+ "]";
	}

	

	}

	
	

