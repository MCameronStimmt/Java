/*
 * Mordred Cameron
CS1450(T/R)
4/21
Assignment 9
Linked Lists
 */
package cameronmordredassignment9;

import java.io.*;
import java.util.*;
public class CameronMordredAssignment9 {


    public static void main(String[] args) throws IOException{
        //LinkedLists
        SearchRouteLinkedList singleList = new SearchRouteLinkedList();
        DoubleLinkedList doubleList = new DoubleLinkedList();
        
        //scanner
        Scanner inputLocations = new Scanner(new File("Locations.txt"));
        //add to single linked list
        while(inputLocations.hasNext()){
            int number = inputLocations.nextInt();
            String type = inputLocations.next();
            String name = inputLocations.next();
            String activity = inputLocations.nextLine();
            Location location = new Location(number, type, name, activity);
            singleList.addInOrder(location);
        }
        //print list
        singleList.printSearchRoute();

        //remove types
        singleList.removeType("start");
        singleList.removeType("gas-station");
        singleList.removeType("attraction");
        //print again
        System.out.println("Updated Search Route - No start, gas stations, or attraction types");
        singleList.printSearchRoute();
        
        //new file
        SearchRouteLinkedList updateSingleList = new SearchRouteLinkedList();
        Scanner inputUpdate = new Scanner(new File("Update.txt"));
        //add to new updated linkedlist
        while(inputUpdate.hasNext()){
            int number = inputUpdate.nextInt();
            String type = inputUpdate.next();
            String name = inputUpdate.next();
            String activity = inputUpdate.nextLine();
            Location location = new Location(number, type, name, activity);
            singleList.addInOrder(location);
        }
        //print updated linked list
        System.out.println("Updated Search Route - New Activities With Parrots");
        singleList.printSearchRoute();
        //build double linkedlist
        doubleList.build(singleList);
        //print doubly linkedlist
        System.out.println("Location in Doubly Linked List - Printed Backwards");
        doubleList.printListBackwards();
    }//main
    
}//Assignment 9

class Location implements Comparable<Location>{
    private int location;
    private String type;
    private String name;
    private String activity;
    //constructor 
    public Location(int location, String type, String name, String activity){
        this.location = location;
        this.type = type;
        this.name = name;
        this.activity = activity;
    }
    //ge type 
    public String getType(){
        return type;
    }
    //to string
    @Override
    public String toString(){
        return String.format("%-30s %-20s %-10s %n", name, type, activity);
    }
    //compare to
    @Override
    public int compareTo(Location otherLocation){
        int compare = otherLocation.location;
        if(this.location < compare){
            return -1;
        }
        else if(this.location == compare){
            return 0;
        }
        else{
            return 1;
        }
    }
}// Location

class SearchRouteLinkedList {
    private Node head;
    
    public SearchRouteLinkedList(){
        head = null;
    }
    //find size of list
    public int getSize(){
        Node current = head;
        int size = 0;
        while (current != null){
            size++;
            current = current.next;
        }
        return size;
    }
    //add elements in order 
    public void addInOrder(Location locationToAdd){
        Node node = new Node(locationToAdd);
        //if list is empty
        if(head == null){
            head = new Node(locationToAdd);
        }
        //if location is less then head
        else if(head.location.compareTo(locationToAdd) == 1){
                node.next = head;
                head = node;
            }
        //if location is greater then head
        else{
            Node current = head;
            Node previous = null;
            while(current != null && node.location.compareTo(current.location) == 1){
                previous = current;
                current = current.next;
            }


            previous.next = node;
            node.next = current;
            
        } 
       
    }
    //remove all instances of specific type 
    public void removeType(String typeToRemove){
        Node current = head;
        Node previous = null;
        while(current != null){
            Node nextNode = current.next;
            if(current.location.getType().equals(typeToRemove)){
                if(previous == null){
                    head = nextNode;
                }
                else{
                previous.next = nextNode;
                }
            }
            
            else{
                 previous = current;   
            }
            current = current.next;
        }
       
    }
    //remove head 
    public Location removeFirstLocation(){
        Node first = head;
        head = head.next;
        return first.location;
    }
    //print in order 
    public void printSearchRoute(){
        System.out.format("%-30s %-20s %-10s %n", "Location Name", "Type", "Activity");
        System.out.println("-------------------------------------------------"
                + "---------------------------------");
        Node current = head;
        while (current != null){
            System.out.println(current.location.toString());
            current = current.next;
        }
    }
    //node class 
    private class Node{
        
        private Location location;
        private Node next;
        
        public Node(Location location){
            this.location = location;
            next = null;
        }
        
    }//Node
}//SearchRouteLinkedList

class DoubleLinkedList {
    private Node head;
    private Node tail;
    
    public DoubleLinkedList(){
        head = null;
        tail = null;
    }
    //build new double list 
    public void build (SearchRouteLinkedList searchRoute){
       //get size of list
        int size = searchRoute.getSize();
        //loop through list 
        for(int i = 0; i < size ; i++){
            Node node = new Node(searchRoute.removeFirstLocation());
            //if empty
            if(head == null){
                head = tail = node;
                head.previous = null;
                tail.next = null;
            }
            //add to end 
            else{
                tail.next = node;
                node.previous = tail;
                tail = node;
                tail.next = null;
            
            }
        } 
               
    }
    //print double list backwards 
    public void printListBackwards(){
        System.out.format("%-30s %-20s %-10s %n", "Location Name", "Type", "Activity");
        System.out.println("-------------------------------------------------"
                + "---------------------------------");
        Node current = tail;
        while(current != null){
            System.out.println(current.location.toString());
            current = current.previous;
        }
        
    }
    //node class 
    private class Node{
        private Location location;
        private Node previous;
        private Node next;
        
        public Node(Location location){
            this.location = location;
            previous = null;
            next = null;
        }
    }//Node
    
}//DoubleLinkedList
