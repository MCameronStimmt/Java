
package cameronmordredassignment4;

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
}
