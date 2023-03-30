/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package weekendfitnessclub;

import java.io.Serializable;

/**
 *
 * @author Sc
 */
public class Customer implements Serializable{

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public final void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public final void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public final void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
     // Private data members
    private String name;
    private String address;
    private String phoneNumber;
    

    /**
     * Customer constructor
     * sets all the values.
     *
     * @param name          Customer Name
     * @param address       Customer Address
     * @param phoneNumber   Customer Mobile Number
     */
    public Customer(String name, String address, String phoneNumber) {
        this.setName(name);
        this.setAddress(address);
        this.setPhoneNumber(phoneNumber);
        
    }
    
    
   
 @Override
    public String toString() {
        return String.format("%-15s | %-25s | %-15s", getName(), getAddress(), getPhoneNumber());
    }
   
}