package entity;

import java.util.ArrayList;

public class App_Manager {

    private String App_Manager_ID;
    private String name;
    private String dob;

    public App_Manager(String app_Manager_ID, String name, String dob) {

        this.App_Manager_ID = app_Manager_ID;
        this.name = name;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

}
