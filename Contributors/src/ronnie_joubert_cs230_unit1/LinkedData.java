/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ronnie_joubert_cs230_unit1;
import java.util.LinkedList;
/**
 *
 * @author Ronnie Joubert
 * @param <T>
 */
public class LinkedData<T>
{
    protected LinkedList<T> contributorList; //Declare linked list
    
    
    
    public LinkedData()
    {
        contributorList = new LinkedList<>(); //Create a new linked list within the constructor
    }
    
    public void Push(T item) //Push new data to the list
    {
        contributorList.push(item);
    }
    
    public T Pop() //Pull the data from the list
    {
        T item = null;
        
        if (!contributorList.isEmpty())
        {
            item = contributorList.pop();
        }
        
        return item;
    }
    
    @Override
    public String toString() //Format data to replace carriage returns with spaces
    {
        return contributorList.toString().replace(" ", "\n ");
    }
}
