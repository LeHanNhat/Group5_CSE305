package entity;

import java.util.ArrayList;

public class App_Manager {

    public ArrayList<User> listofPassenger;
    public ArrayList<Routes> listofRoutesAvailable;
    private int App_Manager_ID;
    private String name;
    private String dob;

    public App_Manager(int app_Manager_ID, String name, String dob, ArrayList<User> listofPassenger, ArrayList<Routes> listofRoutesAvailable) {

        this.App_Manager_ID = app_Manager_ID;
        this.name = name;
        this.dob = dob;
        this.listofPassenger = listofPassenger;
        this.listofRoutesAvailable = listofRoutesAvailable;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }
    
    public void addRoutes(Routes routes) {
        listofRoutesAvailable.add(routes);
    }

    public void listRoutes() {
        for (int i = 0; i < listofRoutesAvailable.size(); i++) {
            System.out.println(listofRoutesAvailable.get(i) + "\n");
        }
    }

    public void UpdateRoutes(int route_ID, double distance, double duration, String route_Status) {
        listofRoutesAvailable.get(route_ID).UpdateRoute(route_ID, distance, duration, route_Status);
    }

    public void DeleteRoutes(int id) {
        listofRoutesAvailable.remove(id);
    }

    public void DeletePassenger(int id) {
        listofPassenger.remove(id);
    }
}
