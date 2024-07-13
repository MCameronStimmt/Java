
package cameronmordredassignment10;


class Parrot implements Comparable<Parrot>{
    private int id;
    private String name;
    private String songWord;
    
    public Parrot(int id, String name, String songWord){
        this.id = id;
        this.name = name;
        this.songWord = songWord;
    }
    //return name
    public String getName(){
        return name; 
    }
    //return song word
    public String sing(){
        return songWord;
    }
    //compare ids 
    @Override
    public int compareTo(Parrot otherParrot){
        int otherID = otherParrot.id;
        if(this.id < otherID){
            return -1;
        }
        else if(this.id > otherID){
            return 1;
        }
        else{
            return 0;
        }
    }
    
}//Parrot
