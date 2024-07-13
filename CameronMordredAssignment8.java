/*
 * Mordred Cameron
CS1450(T/R)
4/7
Assignment 8
Decode ft. Iterator
 */
package cameronmordredassignment8;

import java.util.*;
import java.io.*;

public class CameronMordredAssignment8 {

    public static void main(String[] args) throws IOException{
        //LIST MESSAGE////////////////////////////////////////////
        //arraylists
        ArrayList<Character> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> listKey = new ArrayList<>();
        //scanners
        Scanner inputList1 = new Scanner(new File("ListMessage1.txt"));
        Scanner inputList2 = new Scanner(new File("ListMessage2.txt"));
        Scanner inputListKey = new Scanner(new File("ListKey.txt"));
        //read char
        while(inputList1.hasNext()){
            String temp = inputList1.next();
            for(int i = 0; i < temp.length(); i++){
                list1.add(temp.charAt(i));
            }
        }
        //read int
        int size = inputList2.nextInt();
        while(inputList2.hasNextInt()){
            list2.add(inputList2.nextInt());
        }
        //read key
        int keySize = inputListKey.nextInt();
        while(inputListKey.hasNextInt()){
            listKey.add(inputListKey.nextInt());
        }
        
        //iterators
        Iterator<Character> list1Iter = list1.iterator();
        Iterator<Integer> list2Iter = list2.iterator();
        Iterator<Integer> listKeyIter = listKey.iterator();
        
        //decrypt
        Decryptor decryptor = new Decryptor();
        String message = decryptor.unscramble(listKeyIter, list1Iter, list2Iter);
        System.out.println("The secret message is: " + message);
        System.out.println();
        
        //QUEUE MESSAGE/////////////////////////////////////////////
        //queues
        Queue<Character> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        Queue<Integer> queueKey = new LinkedList<>();
        //scanners
        Scanner inputQueue1 = new Scanner(new File("QueueMessage1.txt"));
        Scanner inputQueue2 = new Scanner(new File("QueueMessage2.txt"));
        Scanner inputQueueKey = new Scanner(new File("QueueKey.txt"));
        //read char
        while(inputQueue1.hasNext()){
            String temp = inputQueue1.next();
            for(int i = 0; i < temp.length(); i++){
                queue1.add(temp.charAt(i));
            }
        }
        //read int
        int sizeQ = inputQueue2.nextInt();
        while(inputQueue2.hasNextInt()){
            queue2.add(inputQueue2.nextInt());
        }
        //read key
        int keySizeQ = inputQueueKey.nextInt();
        while(inputQueueKey.hasNextInt()){
            queueKey.add(inputQueueKey.nextInt());
        }
        //iterators
        Iterator<Character> queue1Iter = queue1.iterator();
        Iterator<Integer> queue2Iter = queue2.iterator();
        Iterator<Integer> queueKeyIter = queueKey.iterator();
        //decrypt
        Decryptor decryptorQueue = new Decryptor();
        String messageQueue = decryptorQueue.unscramble(queueKeyIter, queue1Iter, queue2Iter);
        System.out.println("The secret message is: " + messageQueue);

    }//main
    
}//Assignment 8

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
    
}//Decryptor
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
}//MessageStack

