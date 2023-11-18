/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528project;

import java.util.ArrayList;

/**
 *
 * @author Ali Usmani
 */
public abstract  class User {
    String username;
    ArrayList<book> bookList=new ArrayList<book>();
    String password;
    
    void login(){};
    void logout(){};
}
