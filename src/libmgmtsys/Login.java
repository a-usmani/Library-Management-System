/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libmgmtsys;

/**
 *
 * @author rchedde
 */
public class Login {
//    
////Instance variables    
//    private String userName;
//    private String password;
//    
    
//method
    boolean IsOwner(String userName,String password){
        txtreader r = txtreader.getInstance();
        if(userName.equals("admin")){
            if (password.equals("admin")) {
                return true;
            }
        }
        
        return false;
        
    }
    boolean IsCustomer(String userName,String password){
        txtreader r = txtreader.getInstance();
        Customers custList= Customers.getInstance();
        for(int i=0;i<custList.getCustomerList().size();i++){
            if((custList.getCustomerList().get(i).getUsername().equals(userName))&&(custList.getCustomerList().get(i).getPassword().equals(password))){
                custList.setCustNum(i);
                return true;
            }
        }
        
        return false;
        
    }
    
}