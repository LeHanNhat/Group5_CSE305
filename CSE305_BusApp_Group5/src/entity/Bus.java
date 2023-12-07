package entity;
import java.util.*;
public class Bus  {
    private String Bus_ID;
	private String Model;
	private int seating_capacity;
	private int standing_capacity;
	private Routes route;
	public Bus(String bus_ID, String model, int seating_capacity, int standing_capacity) {
		super();
		this.Bus_ID = bus_ID;
		this.Model = model;
		this.seating_capacity = seating_capacity;
		this.standing_capacity = standing_capacity;
	}
	public Bus(String bus_ID, String model, int seating_capacity, int standing_capacity,Routes route) {
		super();
		this.Bus_ID = bus_ID;
		this.Model = model;
		this.seating_capacity = seating_capacity;
		this.standing_capacity = standing_capacity;
		this.route=route;
	}
	public void addBus(Routes route) {
		System.out.println("add route:"+route.getRoute_ID());
		this.route=route;
	}
	public void DeleteBus(Routes route) {
		System.out.println("delete route:"+route.getRoute_ID());
		this.route=null;
	}
	public void UpdateBus(Routes route) {
		System.out.println("update new route:"+route.getRoute_ID());
		this.route=route;
	}
	public String getBus_ID() {
		return Bus_ID;
	}
	public void setBus_ID(String bus_ID) {
		Bus_ID = bus_ID;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public int getSeating_capacity() {
		return seating_capacity;
	}
	public void setSeating_capacity(int seating_capacity) {
		this.seating_capacity = seating_capacity;
	}
	public int getStanding_capacity() {
		return standing_capacity;
	}
	public void setStanding_capacity(int standing_capacity) {
		this.standing_capacity = standing_capacity;
	}
	
}
