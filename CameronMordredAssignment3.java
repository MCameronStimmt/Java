/*
 *Mordred Cameron
CS1450(T/R)
2/10
Assignment 3
Interfaces and Abstract classes 
 */
package cameronmordredassignment3;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;


public class CameronMordredAssignment3 {
    
    public static void addAnimal(Scanner input, Animal[] animals){
        for(int i = 0; i < animals.length; i++){
            String species = input.next();
            String name = input.next();
            int swimSpeed = input.nextInt();
            int runSpeed = input.nextInt();
            int climbSpeed = input.nextInt();
            
            if(species.toLowerCase().contains("alligator")){
                animals[i] = new Alligator(name, swimSpeed, runSpeed);
            }
            else if(species.toLowerCase().contains("bear")){
                animals[i] = new Bear(name, swimSpeed, runSpeed, climbSpeed);
            }
            else if(species.toLowerCase().contains("giraffe")){
                animals[i] = new Giraffe(name, runSpeed);
            }
            else if(species.toLowerCase().contains("monkey")){
                animals[i] = new Monkey(name, runSpeed, climbSpeed);
            }
            else if(species.toLowerCase().contains("sloth")){
                animals[i] = new Sloth(name, swimSpeed, climbSpeed);
            }
        }
    }
    
    
    public static void printAnimal(Animal animal){
        String aName = animal.getName();
        String aSpecies = animal.getSpecies();
        String aSound = animal.sound();
        System.out.println(aName + " the " + aSpecies + " says " + aSound);
        if(animal instanceof Swimmer){
            System.out.println("Swimming Speed: " + ((Swimmer) animal).swim());
        }
        if(animal instanceof Runner){
            System.out.println("Running Speed: " + ((Runner) animal).run());
        }
        if(animal instanceof Climber){
            System.out.println("Climbing Speed: " + ((Climber) animal).climb());
        }
        System.out.println("");
    }
    
    public static ArrayList<Animal> findClimber(Animal[] animals){
        ArrayList<Animal> climbers = new ArrayList<>();

        for(int i = 0; i < animals.length; i++){
            if(animals[i] instanceof Climber){
                climbers.add(animals[i]);
            }
        }
        return climbers;
    }
    
    public static int findMostSkilled(Animal[] animals){
        int bestSkillValue = 0;
        int bestIndex = 0;
        
        for(int i = 0; i < animals.length; i++){
            int swimValue = 0;
            int runValue = 0;
            int climbValue = 0;
            if(animals[i] instanceof Swimmer){
                swimValue = ((Swimmer)animals[i]).swim();
            }
            if(animals[i] instanceof Runner){
                runValue = ((Runner)animals[i]).run();
            }
            if(animals[i] instanceof Climber){
                climbValue = ((Climber)animals[i]).climb();
            }
            int skillValue = swimValue + runValue + climbValue;
            if(skillValue > bestSkillValue){
                bestSkillValue = skillValue;
                bestIndex = i;
            }
        }
        return bestIndex;
    }

    
    public static void main(String[] args) throws IOException {
        
        Scanner input = new Scanner(new File("Animals.txt"));
        int size = input.nextInt();
        Animal[] animals = new Animal[size];
        
        //add animals to array
        addAnimal(input, animals);
        //print all animals in array
       System.out.println("------------------------------------------------------------\n"
        + "ALL ANIMALS IN ARRAY\n" + "------------------------------------------------------------");
        for(int i = 0; i < animals.length; i++){
            printAnimal(animals[i]);
        }
        System.out.println("");
        
        //find climbers and print
        ArrayList<Animal> climbers = findClimber(animals);
        
        System.out.println("------------------------------------------------------------\n" +
                           "ANIMALS THAT CAN CLIMB\n" +
                           "------------------------------------------------------------\n" +
                           "Animal               Species            Climbing Speed\n" +
                           "------------------------------------------------------------");
        for(int i = 0; i < climbers.size(); i++){
            String name = climbers.get(i).getName();
            String species = climbers.get(i).getSpecies();
            int speed = ((Climber)climbers.get(i)).climb();
            System.out.printf("%-15s %10s %20s %n", name, species, speed);
        }
        System.out.println("");
        
        //find most skilled animal and print
        System.out.println("---------------------------\n" +
                            "MOST SKILLED ANIMAL\n" +
                            "---------------------------");
        int bestIndex = findMostSkilled(animals);   
        Animal bestAnimal = animals[bestIndex];
        
        System.out.print("The winner is ");
        printAnimal(bestAnimal);
        
    }//main
    
}//Assignment3 

interface Swimmer {
  public abstract int swim();  
} //swimmer

interface Runner {
    public abstract int run();
}//runner

interface Climber {
    public abstract int climb();
}//climber

abstract class Animal {
    private String name;
    private String species;
    
    public void setName(String name){
        this.name = name;
    }
    public void setSpecies(String species){
        this.species = species;
    }
    public String getName(){
        return name;
    }
    public String getSpecies(){
        return species;
    }
    
    public String sound(){
        return "teehee";
    }

}//animal

public class Alligator extends Animal implements Swimmer, Runner{
    
    private int swimSpeed;
    private int runSpeed;
    
    public Alligator(String name, int swimSpeed, int runSpeed){
        setName(name);
        setSpecies("Alligator");
        this.swimSpeed = swimSpeed;
        this.runSpeed = runSpeed;
    }
    
    @Override
    public int swim(){
        return swimSpeed;
    }
    @Override
    public int run(){
        return runSpeed;
    }
    @Override
    public String sound(){
        return "Crunch Crunch Crunch";
    }

}//Alligator

public class Bear extends Animal implements Swimmer, Runner, Climber{
    
    private int swimSpeed;
    private int runSpeed;
    private int climbSpeed;
    
    public Bear(String name, int swimSpeed, int runSpeed, int climbSpeed){
        setName(name);
        setSpecies("Bear");
        this.swimSpeed = swimSpeed;
        this.runSpeed = runSpeed;
        this.climbSpeed = climbSpeed;
    }
    @Override
    public int swim(){
        return swimSpeed;
    }
    @Override
    public int run(){
        return runSpeed;
    }
    @Override
    public int climb(){
        return climbSpeed;
    }
    @Override
    public String sound(){
        return "Growl growl growl!!!";
    }

}//Bear

public class Giraffe extends Animal implements Runner{
    
    private int runSpeed;
    
    public Giraffe(String name, int runSpeed){
        setName(name);
        setSpecies("Giraffe");
        this.runSpeed = runSpeed;
    }
    
    @Override
    public int run(){
        return runSpeed;
    }
    @Override
    public String sound(){
        return "Bleat Bleat Bleat!!!";
    }

}//Giraffe

public class Monkey extends Animal implements Runner, Climber{
    
    private int runSpeed;
    private int climbSpeed;
    
    public Monkey(String name, int runSpeed, int climbSpeed){
        setName(name);
        setSpecies("Monkey");
        this.runSpeed = runSpeed;
        this.climbSpeed = climbSpeed;
    }
    
    @Override
    public int run(){
        return runSpeed;
    }
    @Override
    public int climb(){
        return climbSpeed;
    }
    @Override
    public String sound(){
        return "Screech Screech Screech!!!";
    }

}//Monkey

public class Sloth extends Animal implements Swimmer, Climber{
    
    private int swimSpeed;
    private int climbSpeed;
    
    public Sloth(String name, int swimSpeed, int climbSpeed){
        setName(name);
        setSpecies("Sloth");
        this.swimSpeed = swimSpeed;
        this.climbSpeed = climbSpeed;
    }
    

    @Override
    public int swim(){
        return swimSpeed;
    }
    @Override
    public int climb(){
        return climbSpeed;
    }
    @Override
    public String sound(){
        return "Squeak Squeak Squeak";
    }
 
}//sloth
