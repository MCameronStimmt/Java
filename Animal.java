
package cameronmordredassignment3;


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

}
