/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528project;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Ali Usmani
 */
public class editBooks {
private List<book> bookList;
private static editBooks record_instance;

    public List<book> getBookList(){
        return bookList;
    }

    private editBooks() {
        bookList=new ArrayList<>();
    }
    
    public static editBooks getInstance()
    {
        if (record_instance == null){
            record_instance = new editBooks();
        }
        return record_instance;
    }
    
    
    public void addBook(book Book){
        bookList.add(Book);
    }
    
    public void deleteBook(book bookName){
        int i=0;
        for (book bookListItem : bookList) {
            if (bookListItem.equals(bookName)){
                bookList.remove(i);
                break;
            }
            i++;
        }
    }
    /* Check if there are duplicates
    public boolean checkName(String Name){
        for(book c: bookList){     
            if(c.getBookName().equals(Name)){
                return(false);
            }
        }
    return(true);
}*/
    public boolean isEmpty(){
        if(bookList.isEmpty()){
            return true;
        } else{
            return false;
        }
    }
}