
package cameronmordredassignment5;

import java.util.*;
class GenericStack<E> {
    
    private ArrayList<E> list;
    
    public GenericStack(){
        list = new ArrayList<>();
    }
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    public int getSize(){
        return list.size();
    }
    
    public E peek(){
        return list.get(getSize() - 1);
    }
    
    public void push(E value){
        list.add(value);
    }
    
    public E pop(){
        E value = list.remove(getSize() - 1);
        return value;
    }
    
}
