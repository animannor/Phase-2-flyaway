package flyaway.models;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;


import javax.persistence.Table;


@Entity
@Table(name="routeinfo")
public class routeinfo {

	@Id
	@Column(name = "routeindex")
	private String routeindex;		
	@Column(name="departure")
	private String departre;
	@Column(name="destination")
	private String destination;
	
	
	
	public routeinfo() {
		;
		// TODO Auto-generated constructor stub
	}


	public String getRouteindex() {
		return routeindex;
	}


	public void setRouteindex(String routeindex) {
		this.routeindex = routeindex;
	}


	public String getDepartre() {
		return departre;
	}


	public void setDepartre(String departre) {
		this.departre = departre;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	@Override
	public String toString() {
		return "routeinfo [routeindex=" + routeindex + ", departre=" + departre + ", destination=" + destination + "]";
	}


	
	
	
}
    
	