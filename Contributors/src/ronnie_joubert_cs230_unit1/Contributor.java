/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ronnie_joubert_cs230_unit1;

/**
 *
 * @author Ronnie Joubert
 */
public class Contributor {
    
    //Declare variables needed for contributors
    private final String name;
    private final String city;
    private final String country;
    private final String phoneNumber;
    private final double amount;
    private final int accountID;
    
    public Contributor(String name, String city, String country, String phone, double amount, int id) //Custom constructor
    {
        this.name = name;
        this.city = city;
        this.country = country;
        this.phoneNumber = phone;
        this.amount = amount;
        this.accountID = id;        
    }
    
    @Override
    public String toString() //Format data
    {
        return String.format("Name: %s%n  City: %s%n  Country: %s%n  Phone Number: %s%n  Amount: %s%n  Account ID: %s%n%n", getName(), getCity(), getCountry(), getPhoneNumber(), getAmount(), getAccountID());
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return the city
     */
    public String getCity()
    {
        return city;
    }

    /**
     * @return the country
     */
    public String getCountry()
    {
        return country;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    /**
     * @return the amount
     */
    public double getAmount()
    {
        return amount;
    }

    /**
     * @return the accountID
     */
    public int getAccountID()
    {
        return accountID;
    }
}
