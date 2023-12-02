package Quy;
import java.util.ArrayList;

public class App_Manager {
    public ArrayList<User> listofPassenger;
    public ArrayList<Routes> listofRoutesAvailable;
    private int App_Manager_ID;
    private String accesss_level;
    private String reporting_line;
    

public App_Manager(int app_Manager_ID, String accesss_level, String reporting_line,ArrayList<User> listofPassenger,ArrayList<Routes> listofRoutesAvailable) {

	this.App_Manager_ID = app_Manager_ID;
	this.accesss_level = accesss_level;
	this.reporting_line = reporting_line;
	this.listofPassenger=listofPassenger;
    this.listofRoutesAvailable=listofRoutesAvailable;
}
    // public void addPassenger(User user) {
    //     listofPassenger.add(user);
    // }
    // public void listPassenger() {
    //     for (int i=0; i<listofPassenger.size(); i++) {
    //         System.out.println(listofPassenger.get(i)+"\n");
    //     }
    // }
    // chưa đủ đi kiện hiện thực
    public void addRoutes(Routes routes) {
        listofRoutesAvailable.add(routes);
    }
    public void listRoutes() {
        for (int i=0; i<listofRoutesAvailable.size(); i++) {
            System.out.println(listofRoutesAvailable.get(i)+"\n");
        }
    }

    public void UpdateRoutes(int route_ID,double distance, double duration, String route_Status) {
        listofRoutesAvailable.get(route_ID).UpdateRoute(route_ID, distance, duration, route_Status);
    }

    

    public void DeleteRoutes(int id) {
        listofRoutesAvailable.remove(id);
    }

    public void DeletePassenger(int id) {
        listofPassenger.remove(id);
    }
}