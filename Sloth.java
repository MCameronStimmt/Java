/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cameronmordredassignment3;

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
 
}
