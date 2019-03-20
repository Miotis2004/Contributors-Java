/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ronnie_joubert_cs230_unit1;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author Ronnie Joubert
 */
public class HashFunction {
    
    private static Scanner input;
    @SuppressWarnings("UseOfObsoleteCollectionType")
    private static Hashtable<String, Contributor> conList = new Hashtable();
    private static LinkedData contributors;
    private static int count;
    private static ArrayList<Contributor> myList = new ArrayList();
    
     /**
     * @return the conList
     */
    public Hashtable<String, Contributor> getConList()
    {
        return conList;
    }

    /**
     * @param conList the conList to set
     */
    public void setConList(Hashtable<String, Contributor> conList)
    {
        this.conList = conList;
    }

    /**
     * @return the contributors
     */
    public LinkedData getContributors()
    {
        return contributors;
    }

    /**
     * @param contributors the contributors to set
     */
    public void setContributors(LinkedData contributors)
    {
        this.contributors = contributors;
    }
    
    public static ArrayList<Contributor> getMyList()
    {
        return myList;
    }

    
    public static void setMyList(ArrayList<Contributor> aMyList)
    {
        myList = aMyList;
    }
    
    
    public HashFunction()
    {
        //Create a linked list and a hashtable
        contributors = new LinkedData();
        createList();
        populateHash();
    }
    
    public HashFunction(String name)
    {
        //Create a linked list and a hashtable
        contributors = new LinkedData();
        createList();
        populateNameHash();
    }
    
    public void createNewList()
    {
        createList();
    }
    
    public static void createList()
    {
        //Open the csv file and read the data into the linked list
        Openfile();
        
        input.useDelimiter(",|\\r\\n");  //Tell the program to consider a comma, return or new line the end of an entry
        
        count = 0;
        // load all of the data into the stack
        while (input.hasNext()) {
            contributors.Push(
                new Contributor(
                    input.next(),input.next(),input.next(),input.next(),
                    input.nextInt(),input.nextInt()
                )
            ); 
            count ++;
            
            
        }
        
        // close scanner 
        input.close();
    }
    
    public static void populateHash()
    {
        //Populate the hash table
        
            for (int i = 0; i < count; i++)
            {
                Contributor con = (Contributor) contributors.Pop();
                conList.put(Integer.toString(con.getAccountID()), con);
            }
        
        
        
        createList();
    }
    
    public static void populateNameHash()
    {
        //Populate the hash table
        
            for (int i = 0; i < count; i++)
            {
                Contributor con = (Contributor) contributors.Pop();
                conList.put(con.getName(), con);
            }
        
        
        
        createList();
    }
    
        public static void Openfile()
    {
        try {  //Use a try/catch block to access the csv file.  
            input = new Scanner(Paths.get("files\\contributors.csv"));
        }
        catch (IOException E) { //if the csv file cannot be found
            System.err.println("Unable to open file. Terminating!");
            System.exit(1);
        }
    }

    
    

    
        
    
   

}
