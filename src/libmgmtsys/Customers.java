/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libmgmtsys;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ali Usmani
 */
public class Customers {
    private static int custNum;
    private static Customers record_instance;
    private static List<Customer> CustomersVar;

    private Customers() {
        CustomersVar=new ArrayList<>();
    }
    
    public static Customers getInstance()
    {
        if (record_instance == null){
            record_instance = new Customers();
        }
        return record_instance;
    }
    
    public List<Customer> getCustomerList(){
        return CustomersVar;
    }
    public void addCustomer(Customer cust){
        CustomersVar.add(cust);
    }
    public void deleteCustomer(Customer cust){
        int i=0;
        for (Customer CustomersVarItem : CustomersVar) {
            if (CustomersVarItem.equals(cust)){
                CustomersVar.remove(i);
                break;
            }
            i++;
        }
    }
    
    
    public int getCustNum(){
        return custNum;
    }
    public void setCustNum(int x){
        custNum=x;
    }
    public void addCustomers(Customer customer){
        CustomersVar.add(customer);
    }
    public boolean checkUsername(String U){
        for(Customer c: CustomersVar){     
            if(c.getUsername().equals(U)){
                return(false);
            }
        }
    return(true);
}}
    
