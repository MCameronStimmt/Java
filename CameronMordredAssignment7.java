/*
 * Mordred Cameron
CS1450(T/R)
3/31
Assignment 7
Vending Machine Cars and Queues
 */
package cameronmordredassignment7;

import java.util.*;
import java.io.*;
public class CameronMordredAssignment7 {


    public static void main(String[] args) throws IOException{
        
        //scanner file
        Scanner input = new Scanner(new File("VendingMachineCars7.txt"));
        int nmbrRows = input.nextInt();
        int nmbrColumns = input.nextInt();
        //create vending machine
        VendingMachine machine = new VendingMachine(nmbrRows, nmbrColumns);
        //read rest of file
        while(input.hasNext()){
            int row = input.nextInt();
            int column = input.nextInt();
            String washPlan = input.next();
            double price = input.nextDouble();
            int year = input.nextInt();
            String make = input.next();
            String model = input.next();
            //create car and add to tower
            Car car = new Car(washPlan, price, year, make, model);
            machine.addCarToTower(column, row, car);
        }
       //print table
        machine.displayTower();
        System.out.println();
        
        //print car wash line
        System.out.println("Controller: Moving cars from vending machine to car wash line: ");
        CarWash carWash = new CarWash();
        CarWashController carWashController = new CarWashController();
        carWashController.moveCarsToWaitingLine(machine, carWash);
        //Show empty tower
        System.out.println("Show empty vending machine...");
        machine.displayTower();
        
        //move cars from waiting line to car wash
        System.out.println("Controller: Moving cars waiting in line into car wash: \n" +
                            "-------------------------------------------------------------------");
        carWashController.moveCarsIntoCarWash(carWash);
        carWashController.displayBasicConveyor(carWash);
        System.out.println();
        carWashController.displayUnlimitedConveyor(carWash);
        System.out.println();
        //move cars back into vending machine
        System.out.println("Controller: Moving clean cars from car wash back into Vending Machine: \n" +
                            "-------------------------------------------------------------------");
        carWashController.moveCarsBackToVendingMachine(machine, carWash);
        System.out.println();
        //print vending machine
        System.out.println("Show restored vending machine...");
        machine.displayTower();
        
    }//main
    
    //printInventory method
    public static void printInventory(VendingMachine machine){
        ArrayList<Car> inventory = new ArrayList<>();
        for(int i = 0; i < machine.getRows(); i++){
            for(int j = 0; j < machine.getColumns(); j++){
                if(machine.getCarInTower(i, j) == null){
                    
                }
                else{
                    inventory.add(machine.getCarInTower(i, j));
                }
            }
        }
        Collections.sort(inventory);
        for(int i = 0; i < inventory.size(); i++){
            System.out.println(inventory.get(i).toString());
        }
    }//printInventory
    
}//Assignment 7

class VendingMachine {
    private int nmbrRows;
    private int nmbrColumns;
    private Car[][] tower;
    
    public VendingMachine(int nmbrRows, int nmbrColumns){
        this.nmbrRows = nmbrRows;
        this.nmbrColumns = nmbrColumns;
        this.tower = new Car[nmbrRows][nmbrColumns];
    }
    
    public int getRows(){
        return nmbrRows;
    }
    public int getColumns(){
        return nmbrColumns;
    }
    
    public void addCarToTower(int row, int column, Car car){
        tower[row][column] = car;
    }
    public Car getCarInTower(int row, int column){
        return tower[row][column];
    }
    public void removeCarFromTower(int row, int column){
        tower[row][column] = null;
    }
    //find next open location in vending machine tower
    public int[] findOpenLocation(){
        int[] tempArray = new int[2];
        for(int column = nmbrColumns - 1; column >= 0; column--){
            for(int row = 0; row < nmbrRows; row++){
                if(tower[row][column] == null){
                    tempArray[0] = row;
                    tempArray[1] = column;
                    break;
                }
            }
        }
        return tempArray;
    }
    //print out rows and columns for tower
    public void displayTower(){
       System.out.print("         ");
       for(int i = 0; i < nmbrColumns; i++){
           System.out.printf("%-15s", "Column" + " " + i);
       }
       System.out.println();
       System.out.println();
       for(int i = 0; i < nmbrRows; i++){
           System.out.print("Row " + i + ":    ");
           for(int j = 0; j < nmbrColumns; j++){
               if(tower[i][j] == null){
                   System.out.printf("%-15s", "------");
               }
               else{
                System.out.printf("%-15s", tower[i][j].getMake());
               }
           }
           System.out.println();
       }
    }
     
}//VendingMachine

class Car implements Comparable<Car>{
    private String washPlan;
    private double price;
    private int year;
    private String make;
    private String model;
    
    public Car(String washPlan, double price, int year, String make, String model){
        this.washPlan = washPlan;
        this.price = price;
        this.year = year;
        this.make = make;
        this.model = model;
    }
    
    public String getWashPlan(){
        return washPlan;
    }
    
    public double getPrice(){
        return price;
    }
    public int getYear(){
        return year;
    }
    public String getMake(){
        return make;
    }
    public String getModel(){
        return model;
    }
    
    @Override
    public String toString(){
        return String.format("%-4d\t%-10s\t%-15s",
                year, make, model);
    }
    //compare cars by year
    @Override
    public int compareTo(Car otherCar){
        if(this.year > otherCar.year){
            return 1;
        }
        else if(this.year < otherCar.year){
            return -1;
        }
        else{
            return 0;
        }
    }
}//Car

class CarWash {
    private PriorityQueue<Car> waitingLine;
    private Queue<Car> unlimitedConveyor;
    private Queue<Car> basicConveyor;
    
    public CarWash(){
        this.waitingLine = new PriorityQueue<>();
        basicConveyor = new LinkedList<>();
        this.unlimitedConveyor = new LinkedList<>();
    }
    
    public boolean isWaitingLineEmpty(){
        return waitingLine.isEmpty();
    }
    
    public void addCarToWaitingLine(Car car){
        waitingLine.offer(car);
    }
    
    public Car removeCarFromWaitingLine(){
        return waitingLine.poll();
    }
    public int waitingLineSize(){
        return waitingLine.size();
    }
    
    //Unlimited Conveyor methods
    public boolean unlimitedIsEmpty(){
        return unlimitedConveyor.isEmpty();
    }
    public void unlimitedAdd(Car car){
        unlimitedConveyor.offer(car);
    }
    public Car unlimitedRemove(){
        return unlimitedConveyor.remove();
    }
    public int unlimitedSize(){
        return unlimitedConveyor.size();
    }
    
    //Basic Conveyor methods
    public boolean basicIsEmpty(){
        return basicConveyor.isEmpty();
    }
    public void basicAdd(Car car){
        basicConveyor.offer(car);
    }
    public Car basicRemove(){
        return basicConveyor.remove();
    }
    public int basicSize(){
        return basicConveyor.size();
    }
    
    
}//CarWash

class CarWashController {
    
    //move cars from machine to waiting line
    public void moveCarsToWaitingLine(VendingMachine vendingMachine, CarWash carWash){
        for(int row = 0; row < vendingMachine.getRows(); row++){
            for(int column = 0; column < vendingMachine.getColumns(); column++){
                Car car = vendingMachine.getCarInTower(row, column);
                if(car == null){
                    
                }
                else{
                    carWash.addCarToWaitingLine(car);
                    vendingMachine.removeCarFromTower(row, column);
                    System.out.println("Moved to waiting line: " + car.toString());
                }
            }
        }
    }
    
    //move cars from waiting line to respective wash type
    public void moveCarsIntoCarWash(CarWash carWash){
        int size = carWash.waitingLineSize();
        for(int i = 0; i < size; i++){
            Car car = carWash.removeCarFromWaitingLine();
            if(car.getWashPlan().equals("Basic")){
                carWash.basicAdd(car);
            }
            else{
                carWash.unlimitedAdd(car);
            }
        }
    }
    //display all cars in basic car wash
    public void displayBasicConveyor(CarWash carWash){
        int size = carWash.basicSize();
        for(int i = 0; i < size; i++){
            Car car = carWash.basicRemove();
            System.out.println("On basic wash conveyor: " + car);
            carWash.basicAdd(car);
        }
    } 
    //display all cars in unlimited car wash
    public void displayUnlimitedConveyor(CarWash carWash){
        int size = carWash.unlimitedSize();
        for(int i = 0; i < size; i++){
            Car car = carWash.unlimitedRemove();
            System.out.println("On unlimited wash conveyor: " + car);
            carWash.unlimitedAdd(car);
        }
    } 
    //move cars back from both car washes in round robin order to vending machine
    public void moveCarsBackToVendingMachine(VendingMachine vendingMachine, CarWash carWash){
        while(!carWash.basicIsEmpty() || !carWash.unlimitedIsEmpty()){
            if(!carWash.unlimitedIsEmpty()){
                int[] location = vendingMachine.findOpenLocation();
                int row = location[0];
                int column = location[1];
                Car car = carWash.unlimitedRemove();
                vendingMachine.addCarToTower(row, column, car);
                System.out.println("Reloading: " + car);
            }
            if(!carWash.basicIsEmpty()){
                int[] location = vendingMachine.findOpenLocation();
                int row = location[0];
                int column = location[1];
                Car car = carWash.basicRemove();
                vendingMachine.addCarToTower(row, column, car);
                System.out.println("Reloading: " + car);
            }
        }
    }
    
    
}//CarWashController


