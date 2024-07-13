
package cameronmordredassignment4;

class VendingMachine {
    private int nmbrRows;
    private int nmbrColumns;
    private Car[][] tower;
    
    public VendingMachine(int nmbrRows, int nmbrColumns){
        this.nmbrRows = nmbrRows;
        this.nmbrColumns = nmbrColumns;
        this.tower = new Car[nmbrRows][nmbrColumns];
    }
    
    public int getRows(){
        return nmbrRows;
    }
    public int getColumns(){
        return nmbrColumns;
    }
    
    public void addCarToTower(int row, int column, Car car){
        tower[row][column] = car;
    }
    public Car getCarInTower(int row, int column){
        return tower[row][column];
    }
    public void removeCarFromTower(int row, int column){
        tower[row][column] = null;
    }
    //find next open location in vending machine tower
    public int[] findOpenLocation(){
        int[] tempArray = new int[2];
        for(int column = nmbrColumns - 1; column >= 0; column--){
            for(int row = 0; row < nmbrRows; row++){
                if(tower[row][column] == null){
                    tempArray[0] = row;
                    tempArray[1] = column;
                    break;
                }
            }
        }
        return tempArray;
    }
    //print out rows and columns for tower
    public void displayTower(){
       System.out.print("         ");
       for(int i = 0; i < nmbrColumns; i++){
           System.out.printf("%-15s", "Column" + " " + i);
       }
       System.out.println();
       System.out.println();
       for(int i = 0; i < nmbrRows; i++){
           System.out.print("Row " + i + ":    ");
           for(int j = 0; j < nmbrColumns; j++){
               if(tower[i][j] == null){
                   System.out.printf("%-15s", "------");
               }
               else{
                System.out.printf("%-15s", tower[i][j].getMake());
               }
           }
           System.out.println();
       }
    }
     
}
