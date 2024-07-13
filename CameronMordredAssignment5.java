/*
 * Mordred Cameron
CS1450(T/R)
3/3
Assignment 5
Stacks
 */
package cameronmordredassignment5;

import java.util.*;
import java.io.*;
public class CameronMordredAssignment5 {
    

    public static void main(String[] args) throws IOException {
        //part 1
        int[] values = {12, 9, 3, 10, 4, 2, 5, 15, 7, 11, 14};
        Stack<Integer> stack = new Stack<>();
        //push array into stack
        for(int i = 0; i < values.length; i++){
            stack.push(values[i]);
        }
        int numEven = findNumEven(stack);
        //print stack
        System.out.println("Stack Values After Find Number of Even Values\n" +
                            "----------------------------------------------");
        printStack(stack);
        System.out.println("Number of even values: " + numEven);
        //part 2
        //fill 1st generic stack
        Scanner inputN1 = new Scanner(new File("Numbers1.txt"));
        GenericStack<Integer> intStack1 = new GenericStack<>();
        while(inputN1.hasNext()){
            intStack1.push(inputN1.nextInt());
        }
        //fill 2nd generic stack
        Scanner inputN2 = new Scanner(new File("Numbers2.txt"));
        GenericStack<Integer> intStack2 = new GenericStack<>();
        while(inputN2.hasNext()){
            intStack2.push(inputN2.nextInt());
        }
        //print generic stack
        System.out.println("Values read from Numbers1.txt and pushed onto stack1\n" +
                            "-------------------------------------------------------");
        printStack(intStack1);
        System.out.println("Values read from Numbers1.txt and pushed onto stack2\n" +
                            "-------------------------------------------------------");
        printStack(intStack2);
        
        //combine both stacks 
        GenericStack<Integer> combinedIntStack = combineStack(intStack1, intStack2);
        
        //sort the stacks 
        GenericStack<Integer> sortedIntStack = new GenericStack<>();
        sortStack(combinedIntStack, sortedIntStack);
        
        //print sorted stack
        
        System.out.println("Combined Number Stack With Duplicates - lowest value on top: \n" +
                            "------------------------------------------------------------");
        printStack(sortedIntStack);
        
        //remove duplicate stacks 
        GenericStack<Integer> duplicateStack = removeDuplicates(sortedIntStack);
        
        //print stack
        
        System.out.println("Combined Number Stack Duplicates Removed - lowest value on top: \n" +
                            "-------------------------------------------------------");
        printStack(sortedIntStack);
        System.out.println("Duplicates Number Stack - largest value on top: \n" +
                            "----------------------------------------------");
        printStack(duplicateStack);
        
        //STRINGS
        Scanner inputS1 = new Scanner(new File("Strings1.txt"));
        GenericStack<String> stringStack1 = new GenericStack<>();
        while(inputS1.hasNext()){
            stringStack1.push(inputS1.next());
        }
        
        Scanner inputS2 = new Scanner(new File("Strings2.txt"));
        GenericStack<String> stringStack2 = new GenericStack<>();
        while(inputS2.hasNext()){
            stringStack2.push(inputS2.next());
        }
        //print generic stack
        System.out.println("Values read from Strings1.txt and pushed onto stack1\n" +
                            "-------------------------------------------------------");
        printStack(stringStack1);
        System.out.println("Values read from Strings2.txt and pushed onto stack2\n" +
                            "-------------------------------------------------------");
        printStack(stringStack2);
        GenericStack<String> combinedStringStack = combineStack(stringStack1, stringStack2);
        
        GenericStack<String> sortedStringStack = new GenericStack<>();
        sortStack(combinedStringStack, sortedStringStack);
        
        System.out.println("Combined String Stack With Duplicates - lowest value on top: \n" +
                            "------------------------------------------------------------");
        printStack(sortedStringStack);
        
        GenericStack<String> duplicateStringStack = removeDuplicates(sortedStringStack);
        
        System.out.println("Combined String Stack Duplicates Removed - lowest value on top: \n" +
                            "-------------------------------------------------------");
        printStack(sortedStringStack);
        System.out.println("Duplicates String Stack - largest value on top: \n" +
                            "----------------------------------------------");
        printStack(duplicateStringStack);
        
    }//main
    
        //find even numbers of first stack
    public static int findNumEven(Stack<Integer> stack){
        int even = 0;
        int length = stack.size();
        Stack<Integer> tempStack = new Stack<>();
        //pop stack and iterate even
        for(int i = 0; i < length; i++){
            int num = stack.pop();
            tempStack.push(num);
            if(num % 2 == 0){
                even++;
            }
        }
        //replace stack w/ integers
        for(int i = 0; i < length; i++){
            stack.push(tempStack.pop());
        }
        return even;
    }

    //print step 1 stack
    public static void printStack(Stack<Integer> stack){
        int length = stack.size();
        Stack<Integer> tempStack = new Stack<>();
        //pop stack and print
        for(int i = 0; i < length; i++){
            int num = stack.pop();
            System.out.println(num);
            tempStack.push(num);
        }
        //replace stack w/ integers
        for(int i = 0; i < length; i++){
            stack.push(tempStack.pop());
        }
    }
    
    //print step 2 stack
    public static <E> void printStack(GenericStack<E> stack){
        int length = stack.getSize();
        GenericStack<E> tempStack = new GenericStack<>();
        //pop stack and print
        for(int i = 0; i < length; i++){
            E temp = stack.pop();
            System.out.println(temp);
            tempStack.push(temp);
        } 
        //replace stack w/ E
        for(int i = 0; i < length; i++){
            stack.push(tempStack.pop());
        }
    }
    
    //combine stacks read from file
    public static <E> GenericStack<E> combineStack(GenericStack<E> stack1, GenericStack<E> stack2){
        //create new combined stack
        GenericStack<E> combinedStack = new GenericStack<>();
        while(!stack1.isEmpty()){
            combinedStack.push(stack1.pop());
        }
        while(!stack2.isEmpty()){
            combinedStack.push(stack2.pop());
        }
        return combinedStack;
    }
    
    //sort stack by least to greatest
    public static <E extends Comparable<E>> void sortStack(GenericStack<E> unsortedStack,
                                                            GenericStack<E> sortedStack){
        while(!unsortedStack.isEmpty()){
            E current = unsortedStack.pop();
            while(!sortedStack.isEmpty() && (sortedStack.peek().compareTo(current) < 0)){
                unsortedStack.push(sortedStack.pop());
            }
            sortedStack.push(current);
        }
    }
    
    //remove extra duplicates of element
    public static <E extends Comparable<E>> GenericStack<E> removeDuplicates(GenericStack<E> stack){
        //stack for duplicates
        GenericStack<E> duplicates = new GenericStack<>();
        //temporary stack for rest of elements
        GenericStack<E> tempStack = new GenericStack<>();
        tempStack.push(stack.pop()); 
        while(!stack.isEmpty()){
            E next = stack.pop();
            if(next.compareTo(tempStack.peek()) == 0){
                duplicates.push(next);
                
            }
            else{
                tempStack.push(next);
            }
            
        }

        //replace original stack
        int length = tempStack.getSize();
        for(int i = 0; i < length; i++){
            stack.push(tempStack.pop());
        }
        return duplicates;
    }
    
}//Assignment 5

        
        //GenericStack Class
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
    
}//GenericStack
