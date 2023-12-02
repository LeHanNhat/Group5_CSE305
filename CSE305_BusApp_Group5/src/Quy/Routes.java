package Quy;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Routes {

    private int Route_ID;
    private double Distance;
    private double duration;
    private String Route_Status;
    private ArrayList<Routes> listofRoutes;

    public Routes(int route_ID, double distance, double duration, String route_Status) {

        this.Route_ID = route_ID;
        this.Distance = distance;
        this.duration = duration;
        this.Route_Status = route_Status;
    }

    public int getRoute_ID() {
        return Route_ID;
    }

    public void setRoute_ID(int route_ID) {
        Route_ID = route_ID;
    }

    public double getDistance() {
        return Distance;
    }

    public void setDistance(double distance) {
        Distance = distance;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getRoute_Status() {
        return Route_Status;
    }

    public void setRoute_Status(String route_Status) {
        Route_Status = route_Status;
    }

    public void AddRoute(Routes routes) {
        listofRoutes.add(routes);
    }

    public void DeleteRoute(int id) {
        listofRoutes.remove(id);
    }

    public void UpdateRoute(int id, double distance, double duration, String route_Status) {
        if (listofRoutes.contains(id)) {

            listofRoutes.get(id).setDistance(distance);
            listofRoutes.get(id).setDuration(duration);
            listofRoutes.get(id).setRoute_Status(route_Status);
        } else {
            System.out.println("error");
        }
    }
}
