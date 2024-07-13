/*
 * Mordred Cameron
CS1450(T/R)
4/28
Assignment 10
Binary Search Tree 
*/
package cameronmordredassignment10;

import java.io.*;
import java.util.*;
public class CameronMordredAssignment10 {


    public static void main(String[] args) throws IOException{
        //scan file
        Scanner input = new Scanner(new File("parrots.txt"));
        //create search tree 
        BinarySearchTree searchTree = new BinarySearchTree();
        //read file and create parrot
        while(input.hasNext()){
            int id = input.nextInt();
            String name = input.next();
            String songWord = input.next();
            Parrot parrot = new Parrot(id, name, songWord);
            //add to search tree
            searchTree.insert(parrot);
        }
        //print song words
        System.out.println("Parrot's Song\n" +
        "-------------------------------");
        searchTree.levelOrder();
        System.out.println();
        //print leaf parrots
        System.out.println("Parrots on Leaf Nodes\n" +
        "-------------------------------");
        searchTree.visitLeaves();
    }//main
  
}//Assignment10

class Parrot implements Comparable<Parrot>{
    private int id;
    private String name;
    private String songWord;
    
    public Parrot(int id, String name, String songWord){
        this.id = id;
        this.name = name;
        this.songWord = songWord;
    }
    //return name
    public String getName(){
        return name; 
    }
    //return song word
    public String sing(){
        return songWord;
    }
    //compare ids 
    @Override
    public int compareTo(Parrot otherParrot){
        int otherID = otherParrot.id;
        if(this.id < otherID){
            return -1;
        }
        else if(this.id > otherID){
            return 1;
        }
        else{
            return 0;
        }
    }
    
}//Parrot

class BinarySearchTree {
    private TreeNode root;
    
    public BinarySearchTree(){
        root = null;
    }
    //insert parrt
    public boolean insert(Parrot parrotToAdd){
        //check if empty
        if(root == null){
            root = new TreeNode(parrotToAdd);
        }
        
        else{
            TreeNode parent = null;
            TreeNode current = root;
            while(current != null){
                //if parrot to add is less than
                if(parrotToAdd.compareTo(current.parrot) == -1){
                    parent = current;
                    current = current.left;
                }
                //if parrot to add is greater than
                else if(parrotToAdd.compareTo(current.parrot) == 1){
                    parent = current;
                    current = current.right;
                }
                else{
                    return false;
                }
            }
            //add parrot to left
            if(parrotToAdd.compareTo(parent.parrot) == -1){
                parent.left = new TreeNode(parrotToAdd);
            }
            //add parrot to right
            else{
                parent.right = new TreeNode(parrotToAdd);
            }
        }
        return true;
    }
    //print song
    public void levelOrder(){
        if(root != null){
            //create queue
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            
            while(!queue.isEmpty()){
                TreeNode tempNode = queue.remove();
                System.out.println(tempNode.parrot.sing());
                //left side
                if(tempNode.left != null){
                    queue.offer(tempNode.left);
                }
                //right side
                if(tempNode.right != null){
                    queue.offer(tempNode.right);
                }
            }
        }
    }
    
    public void visitLeaves(){
        visitLeaves(root);
    }
    //recursively print leaves 
    private void visitLeaves(TreeNode aNode){
        if(aNode.left == null && aNode.right == null){
            System.out.println(aNode.parrot.getName());
        }
        //left side
        if(aNode.left != null){
            visitLeaves(aNode.left);
        }
        //right side
        if(aNode.right != null){
            visitLeaves(aNode.right);
        }
    }

    
    //TreeNode
    private class TreeNode{
    private Parrot parrot;
    private TreeNode left;
    private TreeNode right;
    public TreeNode(Parrot parrot){
        this.parrot = parrot;
        left = null;
        right = null;
    }
  }//TreeNode
}//BinarySearchTree
