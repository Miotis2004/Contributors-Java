/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ronnie_joubert_cs230_unit1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 *
 * @author Ronnie
 */
public class Ronnie_Joubert_CS230_Unit1 
{
    
    private static Scanner input = new Scanner(System.in);
    private static HashFunction myHash;
    private static HashFunction myNameHash;
    private static ArrayList<Contributor> myList = new ArrayList();
    
    
    public static void main(String[] args)
    {
       TestScriptUnit4();
                     
       InputConstructor();
    }
    
    public static void TestScriptUnit4()
    {
       // Create two hashes.  The first will sort by accountID,the second by name.
       myHash = new HashFunction();
       
       myNameHash = new HashFunction("Bob");
       
       //Add data to myHash.
       for (int i = 0; i < 5; i++)
       {
           Contributor con = (Contributor) myHash.getContributors().Pop();
           myList.add(con);
           
       }
        
        
    }
    
    public static void binarySearch(int acctNum)
    {
        TimerClass tc = new TimerClass();
        
        System.out.println("Conducting binary search for account number " + acctNum + ".");
         
        ArrayList<Integer> al = new ArrayList();
        
        for (int i = 0; i < myList.size(); i++)
        {
            if (myList.get(i) != null){
                //System.out.println(myList.get(i));
                al.add(myList.get(i).getAccountID());
            }
            
        }
        
        int key = acctNum;
        int res = Collections.binarySearch(al, key);
        
        if (res >= 0)
        {
            System.out.println(key + " found at index " + res);
            tc.StopTimer();
            System.out.println();
        }
        else
        {
            System.out.println(key + " not found.");
        }
    }
    
    public static void InputConstructor()  //This will prompt the user for input and perform the appropriate functions.
    {
        //Create variables to contol the main loop and handle user input.
        boolean active = true;
        String userInput;
        
        // This is the main loop to accept and process user input.
        while(active)
        {
            System.out.println("SELECT ONE:  1-Sort by name  2-Print contributor data  3-Add a contributor   4-Search for entry  5-Quit");
            userInput = input.next();
            
            switch (userInput){
                case "1":
                    System.out.println("You selected 1");
                    System.out.println("Sorting by first name.");
                    System.out.println();
                    sortByName();
                    break;
                case "2":
                    System.out.println("You selected 2");
                    System.out.println();
                    printList();
                    break;
                case "3":
                    System.out.println("You selected 3");
                    addContributor();
                    System.out.println();
                    printList();
                    break;
                case "4":
                    System.out.println("You selected 4");
                    System.out.println();
                    searchFor();
                    break;
                case "5":
                    System.out.println("Exiting application.");
                    active = false;
                    break;
                default:
                    System.out.println("Unrecognized input.  Please try again.");
                    break;
                
            }
            
            
            
        }
    }
    
    public static void searchFor() //Search for specific data.
    {
        TimerClass overall = new TimerClass();
        
        String name = "";
        String city = "";
        String country = "";
        String phone = "";
        String amount = "";
        String iD = "";
        boolean found = false;
        int count = 0;
        //Determine what data should be searched for.    
        System.out.println("Enter term to search for.");
        String userInput = input.next();
        System.out.println();
        
        binarySearch(Integer.parseInt(userInput));
        
        TimerClass tc = new TimerClass();
        System.out.println("Searching for " + userInput + " by sequential search.");
        
        //Iterate through the list.  If the correct data is found, retrieve the contributor.
        for (int i = 0; i < myList.size(); i++)
        {
            count++;
            
            if (myList.get(i) != null)
            {
                name = myList.get(i).getName();
                city = myList.get(i).getCity();
                country = myList.get(i).getCountry();
                phone = myList.get(i).getPhoneNumber();
                amount = Double.toString(myList.get(i).getAmount());
                iD = Integer.toString(myList.get(i).getAccountID());
            
                if (userInput.equals(name) || userInput.equals(city) || userInput.equals(country) || userInput.equals(phone) || userInput.equals(amount) || userInput.equals(iD))
                {
                    System.out.println("Entry found in " + count + " tries.");
                    System.out.println(myList.get(i));
                    found = true;
                    tc.StopTimer();
                    System.out.println();
                    break;
                }
            
            }
        }
        
        if (!found)
            {
                System.out.println("No entries found that conform to search term.");
                found = false;
            }
        System.out.print("Total time elapsed: ");
        overall.StopTimer();
    }
    
    public static void sortByName() //Sort the list by first name.
    {
        ArrayList<String> names = new ArrayList();
        
        for (int i = 0; i < myList.size(); i++)
        {
            if (myList.get(i) != null){
                //System.out.println(myList.get(i));
                names.add(myList.get(i).getName());
            }
            
        }
              
        Collections.sort(names);
        
        ArrayList<Contributor> tempList = new ArrayList();
        
        for (int i = 0; i < names.size(); i++)
        {
            System.out.println(myNameHash.getConList().get(names.get(i)));
            tempList.add(myNameHash.getConList().get(names.get(i)));
        }
        
        
        System.out.println();
    }
    
    public static void printList() //Print the contents of the list
    {
        for (int i = 0; i < myList.size(); i++)
        {
            if (myList.get(i) != null)
            {
                System.out.println(myList.get(i));
            }
        }
        System.out.println();
    }
    
    public static void addContributor()  //Add a new contributor to the list.
    {
        System.out.println();
        System.out.println("Enter new contributor name: ");
        String name = input.next();
        System.out.println("Enter new contributor city: ");
        String city = input.next();
        System.out.println("Enter new contributor country: ");
        String country = input.next();
        System.out.println("Enter new contributor phone number: ");
        String phone = input.next();
        System.out.println("Enter new contributor amount: ");
        String amount = input.next();
        System.out.println("Enter new contributor account ID: ");
        String accountID = input.next();
        System.out.println();
        
        Contributor con = new Contributor(name, city, country, phone, Double.parseDouble(amount), Integer.parseInt(accountID));
        
        myList.add(con);
        
    }
    
    
    
    public static <T> void PrintContributors(T contributors) //Print the contibutors
    {
        System.out.println(contributors+"\n");
    }

    

    
    
}
