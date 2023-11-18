/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528project;

import javafx.scene.control.CheckBox;

/**
 *
 * @author Ali Usmani
 */
public class book {
    private double bookPrice;
    private String bookName;
    private CheckBox select;
    
    public book(String bookName, double bookPrice){
        this.bookPrice=bookPrice;
        this.bookName=bookName;
        this.select=new CheckBox();
    }
    
    public String getBookName(){
        return bookName;
    }
    
    public double getBookPrice(){
        return bookPrice;
    }
    
    public void setBookName(String bookName){
        this.bookName=bookName;
    }
    
    public void setBookPrice(double bookPrice){
        this.bookPrice=bookPrice;

    }
    
    public CheckBox getSelect(){
        return select;
    }
    
    public void setSelect(CheckBox select){
        this.select=select;
    }
    
}