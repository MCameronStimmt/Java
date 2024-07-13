
package cameronmordredassignment9;


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
}
