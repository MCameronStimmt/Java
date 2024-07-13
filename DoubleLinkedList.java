
package cameronmordredassignment9;


class DoubleLinkedList {
    private Node head;
    private Node tail;
    
    public DoubleLinkedList(){
        head = null;
        tail = null;
    }
    //build new double list 
    public void build (SearchRouteLinkedList searchRoute){
       //get size of list
        int size = searchRoute.getSize();
        //loop through list 
        for(int i = 0; i < size ; i++){
            Node node = new Node(searchRoute.removeFirstLocation());
            //if empty
            if(head == null){
                head = tail = node;
                head.previous = null;
                tail.next = null;
            }
            //add to end 
            else{
                tail.next = node;
                node.previous = tail;
                tail = node;
                tail.next = null;
            
            }
        } 
               
    }
    //print double list backwards 
    public void printListBackwards(){
        System.out.format("%-30s %-20s %-10s %n", "Location Name", "Type", "Activity");
        System.out.println("-------------------------------------------------"
                + "---------------------------------");
        Node current = tail;
        while(current != null){
            System.out.println(current.location.toString());
            current = current.previous;
        }
        
    }
    //node class 
    private class Node{
        private Location location;
        private Node previous;
        private Node next;
        
        public Node(Location location){
            this.location = location;
            previous = null;
            next = null;
        }
    }//Node
    
}
