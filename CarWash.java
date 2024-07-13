
package cameronmordredassignment4;

import java.io.*;
import java.util.*;
class CarWash {
    private PriorityQueue<Car> waitingLine;
    private Queue<Car> unlimitedConveyor;
    private Queue<Car> basicConveyor;
    
    public CarWash(){
        this.waitingLine = new PriorityQueue<>();
        basicConveyor = new LinkedList<>();
        this.unlimitedConveyor = new LinkedList<>();
    }
    
    public boolean isWaitingLineEmpty(){
        return waitingLine.isEmpty();
    }
    
    public void addCarToWaitingLine(Car car){
        waitingLine.offer(car);
    }
    
    public Car removeCarFromWaitingLine(){
        return waitingLine.poll();
    }
    public int waitingLineSize(){
        return waitingLine.size();
    }
    
    //Unlimited Conveyor methods
    public boolean unlimitedIsEmpty(){
        return unlimitedConveyor.isEmpty();
    }
    public void unlimitedAdd(Car car){
        unlimitedConveyor.offer(car);
    }
    public Car unlimitedRemove(){
        return unlimitedConveyor.remove();
    }
    public int unlimitedSize(){
        return unlimitedConveyor.size();
    }
    
    //Basic Conveyor methods
    public boolean basicIsEmpty(){
        return basicConveyor.isEmpty();
    }
    public void basicAdd(Car car){
        basicConveyor.offer(car);
    }
    public Car basicRemove(){
        return basicConveyor.remove();
    }
    public int basicSize(){
        return basicConveyor.size();
    }
    
    
}
