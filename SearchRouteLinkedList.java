
package cameronmordredassignment9;


class SearchRouteLinkedList {
    private Node head;
    
    public SearchRouteLinkedList(){
        head = null;
    }
    //find size of list
    public int getSize(){
        Node current = head;
        int size = 0;
        while (current != null){
            size++;
            current = current.next;
        }
        return size;
    }
    //add elements in order 
    public void addInOrder(Location locationToAdd){
        Node node = new Node(locationToAdd);
        //if list is empty
        if(head == null){
            head = new Node(locationToAdd);
        }
        //if location is less then head
        else if(head.location.compareTo(locationToAdd) == 1){
                node.next = head;
                head = node;
            }
        //if location is greater then head
        else{
            Node current = head;
            Node previous = null;
            while(current != null && node.location.compareTo(current.location) == 1){
                previous = current;
                current = current.next;
            }


            previous.next = node;
            node.next = current;
            
        } 
       
    }
    //remove all instances of specific type 
    public void removeType(String typeToRemove){
        Node current = head;
        Node previous = null;
        while(current != null){
            Node nextNode = current.next;
            if(current.location.getType().equals(typeToRemove)){
                if(previous == null){
                    head = nextNode;
                }
                else{
                previous.next = nextNode;
                }
            }
            
            else{
                 previous = current;   
            }
            current = current.next;
        }
       
    }
    //remove head 
    public Location removeFirstLocation(){
        Node first = head;
        head = head.next;
        return first.location;
    }
    //print in order 
    public void printSearchRoute(){
        System.out.format("%-30s %-20s %-10s %n", "Location Name", "Type", "Activity");
        System.out.println("-------------------------------------------------"
                + "---------------------------------");
        Node current = head;
        while (current != null){
            System.out.println(current.location.toString());
            current = current.next;
        }
    }
    //node class 
    private class Node{
        
        private Location location;
        private Node next;
        
        public Node(Location location){
            this.location = location;
            next = null;
        }
        
    }//Node
}
