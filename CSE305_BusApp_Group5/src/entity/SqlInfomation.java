/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Asus
 */
public class SqlInfomation {

    private String url;
    private String acc;
    private String pass;

    public SqlInfomation() {
        this.url = "jdbc:mysql://localhost:3306/bus_app";
        this.acc = "root";
        this.pass = "Halazara979489";
    }

    public String getUrl() {
        return url;
    }

    public String getAcc() {
        return acc;
    }

    public String getPass() {
        return pass;
    }

}
