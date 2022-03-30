package binarysearchtree;

public class BinarySearchTree {

    public static void main(String[] args) {
        BinaryTree bst = new BinaryTree();
        
        bst.insert(45);
        bst.insert(15);
        bst.insert(79);
        bst.insert(90);
        bst.insert(10);
        bst.insert(55);
        bst.insert(12);
        bst.insert(20);
        bst.insert(50);
        
        bst.preorder(bst.root);
        System.out.println();
        bst.inorder(bst.root);
        System.out.println();
        bst.postorder(bst.root);
        
        System.out.println();
        
        System.out.println("Search for 79 : "+bst.search(79));
        System.out.println("Search for 88 : "+bst.search(88));
        
        System.out.println("Delete 15 and 90");
        bst.delete(bst.root, 90);
        bst.delete(bst.root, 15);
        bst.preorder(bst.root);
        System.out.println();
        bst.inorder(bst.root);
        System.out.println();
        bst.postorder(bst.root);
    }
    
}
