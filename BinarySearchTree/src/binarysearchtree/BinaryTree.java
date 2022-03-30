package binarysearchtree;

public class BinaryTree {

    class Node {

        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = right  = null;
        }
    }

    Node root = null;

    Node insert(Node r, int val) {
        if (r == null) {
            Node newNode = new Node(val);
            r = newNode;
        } else if (val < r.data) {
            r.left = insert(r.left, val);
        } else {
            r.right = insert(r.right, val);
        }
        return r;
    }

    void insert(int val) {
        root = insert(root, val);
    }

    void preorder(Node r) {         // root , left , right
        if (r == null) {
            return;
        }
        System.out.print(r.data + "\t");
        preorder(r.left);
        preorder(r.right);
    }

    void inorder(Node r) {          // left , root , right
        if (r == null) {
            return;
        }
        inorder(r.left);
        System.out.print(r.data + "\t");
        inorder(r.right);
    }

    void postorder(Node r) {        // left , right , root
        if (r == null) {
            return;
        }
        postorder(r.left);
        postorder(r.right);
        System.out.print(r.data + "\t");
    }
    
    Node search(Node r , int key){
        if(r==null)
            return null;
        else if(r.data==key)
            return r;
        else if(key<r.data)
            return search(r.left,key);
        else
            return search(r.right,key);
    }
    
    boolean search(int key){
        Node result = search(root,key);
        if(result==null)
            return false;
        else
            return true;
    }
    
    Node findMin(Node r){
        if(r==null)
            return null;
        else if(r.left==null)
            return r;
        else
            return findMin(r.left);
    }
    
    Node findMax(Node r){
        if(r==null)
            return null;
        else if(r.right==null)
            return r;
        else
            return findMax(r.right);
    }
    
    Node delete(Node r , int val){
        if(r==null)
            return null;
        else if(val<r.data)
            r.left = delete(r.left,val);
        else if(val>r.data)
            r.right = delete(r.right,val);
        else{
            if(r.left==null && r.right==null)       // leaf node
                r = null;
            else if(r.left==null && r.right!=null){ // has one child on right
                r.data = r.right.data;
                r.right = null;
                System.gc();
            }
            else if(r.left!=null && r.right==null){ // has one child on left
                r.data = r.left.data;
                r.left = null;
                System.gc();
            }
            else{                                   // has many childs
                Node max = findMax(r.left);
                r.data = max.data;
                r.left = delete(r.left,max.data);
            }
        }
        return r;
    }

}
