
package cameronmordredassignment3;


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

}
