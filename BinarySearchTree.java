
package cameronmordredassignment10;

import java.util.*;
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
