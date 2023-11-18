/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libmgmtsys;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.math.RoundingMode;  
import java.text.DecimalFormat;  

/**
 *
 * @author Ali Usmani
 */
public class txtreader {
// Name of the associated file
    
    BufferedReader input;
    BufferedWriter output;
    private static txtreader record_instance;

    public static txtreader getInstance()
    {
        if (record_instance == null){
            record_instance = new txtreader();
        }
        return record_instance;
    }
    
    private txtreader(){
        readCustomer("customerRecord.txt");
        readBooks("bookRecord.txt");
    }
  //  private static Customers record_instance;

// Effects: Reads and prints the contents of the associated
// file to the standard output.

    private void readCustomer(String filename) {
        Customers custList=Customers.getInstance();
        try {
// Write the code here
        input=new BufferedReader(new FileReader(filename));

            String line;
            while ((line = input.readLine()) != null) {
                //process the line
                String[] split = line.split(",");
                custList.addCustomers(new Customer(parseInt(split[2]),split[0],split[1]));
            }
            
        input.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    private void readBooks(String filename) {
        editBooks booksList=editBooks.getInstance();
        try {
// Write the code here
        input=new BufferedReader(new FileReader(filename));

            String line;
            while ((line = input.readLine()) != null) {
                //process the line
                String[] split = line.split(",");
                booksList.addBook(new book(split[0],parseDouble(split[1])));
            }
            
        input.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
// Effects: Appends the specified message, msg, to the
// associated file.

    public void writeBooks(String filename) {
        editBooks booksList=editBooks.getInstance();
        try {
            output=new BufferedWriter(new FileWriter(filename));
            for (int i=0;i<booksList.getBookList().size();i++){
                output.write(booksList.getBookList().get(i).getBookName());
                output.write(",");
                //output.write(Double.toString(booksList.getBookList().get(i).getBookPrice()));
                output.write(String.format("%.2f",booksList.getBookList().get(i).getBookPrice()));
                output.write("\n");
                output.flush();
            }

// Write the code here
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public void writeCustomer(String filename) {
        Customers custList=Customers.getInstance();
        try {
            output=new BufferedWriter(new FileWriter(filename));
            for (int i=0;i<custList.getCustomerList().size();i++){
                output.write(custList.getCustomerList().get(i).getUsername());
                output.write(",");
                output.write(custList.getCustomerList().get(i).getPassword());
                output.write(",");
                output.write(Integer.toString(custList.getCustomerList().get(i).getPoints()));
                output.write("\n");
                output.flush();
            }

// Write the code here
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
