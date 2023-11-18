/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528project;

/**
 *
 * @author Ali Usmani
 */
public class Customer extends User{
    private int points;
    private String username;
    private String password;
    private String status;
    
    public Customer(int Points, String Username,String Password){
        this.username=Username;
        this.password=Password;
        this.points=Points;
        status = (Points>=1000) ? "Gold" : "Silver";
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return password;
    }
    public int getPoints(){
        return this.points;
    }
    
    public void setPoints(int Points){
        this.points=Points;

    }
    public String getStatus(){
        return status;
    }
    public String welcomeCustomer(){
        return("Welcome "+username+". You have "+points+" points. Your status is "+status);
    }
}
