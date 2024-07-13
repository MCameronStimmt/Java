
package cameronmordredassignment4;


class CarWashController {
    
    //move cars from machine to waiting line
    public void moveCarsToWaitingLine(VendingMachine vendingMachine, CarWash carWash){
        for(int row = 0; row < vendingMachine.getRows(); row++){
            for(int column = 0; column < vendingMachine.getColumns(); column++){
                Car car = vendingMachine.getCarInTower(row, column);
                if(car == null){
                    
                }
                else{
                    carWash.addCarToWaitingLine(car);
                    vendingMachine.removeCarFromTower(row, column);
                    System.out.println("Moved to waiting line: " + car.toString());
                }
            }
        }
    }
    
    //move cars from waiting line to respective wash type
    public void moveCarsIntoCarWash(CarWash carWash){
        int size = carWash.waitingLineSize();
        for(int i = 0; i < size; i++){
            Car car = carWash.removeCarFromWaitingLine();
            if(car.getWashPlan().equals("Basic")){
                carWash.basicAdd(car);
            }
            else{
                carWash.unlimitedAdd(car);
            }
        }
    }
    //display all cars in basic car wash
    public void displayBasicConveyor(CarWash carWash){
        int size = carWash.basicSize();
        for(int i = 0; i < size; i++){
            Car car = carWash.basicRemove();
            System.out.println("On basic wash conveyor: " + car);
            carWash.basicAdd(car);
        }
    } 
    //display all cars in unlimited car wash
    public void displayUnlimitedConveyor(CarWash carWash){
        int size = carWash.unlimitedSize();
        for(int i = 0; i < size; i++){
            Car car = carWash.unlimitedRemove();
            System.out.println("On unlimited wash conveyor: " + car);
            carWash.unlimitedAdd(car);
        }
    } 
    //move cars back from both car washes in round robin order to vending machine
    public void moveCarsBackToVendingMachine(VendingMachine vendingMachine, CarWash carWash){
        while(!carWash.basicIsEmpty() || !carWash.unlimitedIsEmpty()){
            if(!carWash.unlimitedIsEmpty()){
                int[] location = vendingMachine.findOpenLocation();
                int row = location[0];
                int column = location[1];
                Car car = carWash.unlimitedRemove();
                vendingMachine.addCarToTower(row, column, car);
                System.out.println("Reloading: " + car);
            }
            if(!carWash.basicIsEmpty()){
                int[] location = vendingMachine.findOpenLocation();
                int row = location[0];
                int column = location[1];
                Car car = carWash.basicRemove();
                vendingMachine.addCarToTower(row, column, car);
                System.out.println("Reloading: " + car);
            }
        }
    }
    
    
}
