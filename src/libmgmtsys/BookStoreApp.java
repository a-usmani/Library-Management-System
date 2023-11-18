/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libmgmtsys;

import java.util.List;

/**
 *
 * @author Ali Usmani
 */
public class BookStoreApp {
    private static List<book> isSelected;
    private double totalCost=0;
    private static boolean redeem;
    private static int points;
    private static String status;
    private static Customers currentCust;
    public BookStoreApp(List<book> isSelected,Boolean redeem){
        currentCust=Customers.getInstance();
        this.points=currentCust.getCustomerList().get(currentCust.getCustNum()).getPoints();
        this.status=currentCust.getCustomerList().get(currentCust.getCustNum()).getStatus();
        this.isSelected=isSelected;
        this.redeem=redeem;
    }
    
    public BookStoreApp(){}
    
    public int getPoints(){
        return points;
    }
    
    public String getStatus(){
        return status;
    }
    
    public double totalCost(){
        for (int i=0;i<isSelected.size();i++){
            totalCost+=isSelected.get(i).getBookPrice();
        }
        if (redeem){
            
            //NOT SURE WHAT THIS IS
            /*while (totalCost<0){
                totalCost+=1;
                points+=100;
            }*/
            
            if(totalCost < points/100){
                points-=((int)totalCost)*100;
                totalCost=0;
            }else{
                
                totalCost -= points/100;
                points = (int)totalCost*10;
            }
        }else{
            points+=((int)totalCost)*10;
        }
        currentCust.getCustomerList().get(currentCust.getCustNum()).setPoints(points);
        if(points < 1000){
            status = "Silver";
        }else{
            status = "Gold";
        }
        return totalCost;
    }
    
}
