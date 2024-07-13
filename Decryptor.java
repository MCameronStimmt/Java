
package cameronmordredassignment8;

import java.util.*;
class Decryptor {
    private MessageStack stack;
    
    //constructor
    public Decryptor(){
        stack = new MessageStack();
    }
    //unscramble
    public String unscramble(Iterator<Integer>keyIterator, Iterator<Character> msg1Iterator, 
                                Iterator<Integer> msg2Iterator){
        //push onto stack
        while(keyIterator.hasNext()){
            if(keyIterator.next() == 0){
                stack.push(msg1Iterator.next());
            }
            else{
                int tempInt = msg2Iterator.next();
                char temp = (char)tempInt;
                stack.push(temp);
            }
        }
        //pop onto string
        String msgString = "";
        while(!stack.isEmpty()){
            msgString += stack.pop();
        }
        return msgString;
    }
    
}
