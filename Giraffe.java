/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cameronmordredassignment3;

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

}