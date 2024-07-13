/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cameronmordredassignment3;

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

}
