
package cameronmordredassignment8;
import java.util.*;
class MessageStack {
    private Stack<Character> aStack;
    
    public MessageStack(){
        aStack = new Stack<>();
    }
    
    //empty
    public boolean isEmpty(){
        return aStack.empty();
    }
    //size
    public int getSize(){
        return aStack.size();
    }
    //peek
    public Character peek(){
        return aStack.get(getSize() - 1);
    }
    //push
    public void push(Character value){
        aStack.add(value);
    }
    //pop
    public Character pop(){
        Character value = aStack.remove(getSize() - 1);
        return value;
    }
}
