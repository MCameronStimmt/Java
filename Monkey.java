/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cameronmordredassignment3;

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

}
