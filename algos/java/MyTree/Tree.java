package MyTree;

import java.util.LinkedList;
import java.util.HashSet;
import java.util.ArrayList;

class Tree {

    protected int data;
    protected Tree left;
    protected Tree right;


    public Tree(int value) {
        this.data = value;
        this.left = null;
        this.right = null;
    }

    /*
                        20

           10                        30
        
        5       15               25       35
    
    4       7 12    18              27         38


    */



    public static void main (String[] args) {

        Tree root = new Tree(20);
        

        Tree sample = new Tree(10);
        root.left = sample;

        sample = new Tree(5);
        root.left.left = sample;

        sample = new Tree (4);
        root.left.left.left = sample;

        sample = new Tree(7);
        root.left.left.right = sample;

        sample = new Tree(15);
        root.left.right = sample;

        sample = new Tree(12);
        root.left.right.left = sample;

        sample = new Tree(18);
        root.left.right.right = sample;

        sample = new Tree (30);
        root.right = sample;

        sample = new Tree(25);
        root.right.left = sample;
    
        //sample = new Tree(13);
        //root.right.left.left=sample;
        
        sample = new Tree(27);
        root.right.left.right = sample;

        sample = new Tree(35);
        root.right.right = sample;

        sample = new Tree(38);
        root.right.right.right = sample;

        //sample = new Tree(12);
        //root.right.right.right.left = sample;

        //sample = new Tree(15);
        //root.right.right.right.left.left = sample;

        System.out.println("Least common ancestor of 27 and 30:");
        leastCommonAncestor(root, 28,27);
        System.out.println("\n");

        System.out.println("Printing Tree levelwise: ");
        printTreeLevelWise(root);
        System.out.println("\n");


        System.out.println("Recursive pre-order Traversal:");
        preOrderRecursive(root);
        System.out.println("\n");

        System.out.println("Recursive in-order Traversal:");
        inOrderRecursive(root);
        System.out.println("\n");

        System.out.println("Recursive post-order Traversal:");
        postOrderRecursive(root);
        System.out.println("\n");

        System.out.println("BFS:");
        BFS(root);
        System.out.println("\n");

        System.out.println("DFS:");
        DFS(root);
        System.out.println("\n");

        System.out.println("Max Depth: "+ MaxDepth(root));
        System.out.println("\n");

        System.out.println("Serialized tree: ("+serializeTree(root)+")");

        //Check if binary tree is a valid BST
        System.out.println("check if a BT is a binary search tree");
        try{
            System.out.println("The tree is valid and highest value is: "+isValidTree(root,-1));
        } catch(Exception e) {
            System.out.println("Its not a valid BST");
        }


        System.out.println("check if a BT is balanced");
        try{
            System.out.println("The tree is balanced and max height is: "+isTreeBalanced(root));
        } catch(Exception e) {
            System.out.println("The tree is not balanced");
        }


        System.out.println("check if a BT is a binary search tree - better method");
        if (isValidBST(root,-1)) {
            System.out.println("The tree is valid BST");
        } else {
            System.out.println("Its not a valid BST");
        }


        // Flatten the tree into linkedlists
        System.out.println("Converting the tree into linkedlists for each level");
        ArrayList<Tree> heads = treeToList(root);
        
        for( Tree temp : heads) {

            while (temp.right != null) {

                System.out.print(temp.data+"->");
                temp= temp.right;
            }
            System.out.println(temp.data+"->null");

            while(temp.left!=null) {
                System.out.print(temp.data+"->");
                temp= temp.left;


            }
            System.out.println(temp.data+"->head");

        }


            
            

        
        return;
    }


    public static String  serializeTree(Tree root) {

        StringBuilder serialize = new StringBuilder();

        if (root ==null) {
             return serialize.append("null").toString();
        } 

        serialize.append(root.data);
        serialize.append("("+serializeTree(root.left)+","+serializeTree(root.right)+")");

        return serialize.toString();

    }


    public static void BFS(Tree root) {

        LinkedList<Tree> queue = new LinkedList<Tree>();

        Tree current = root;

        while (current!=null) {

            System.out.print(current.data+" ");
            if (current.left != null ) {
                queue.addLast(current.left);
            }    

            if (current.right != null) {
                queue.addLast(current.right);
            }


            current = queue.pollFirst();

        }

        return;
    }

    /*
                            20

           10                             30
        
        5       15                  25           35
    
    4       7 12    18                   27            38


    */


    public static int MaxDepth(Tree root) {

       if (root ==null) {
            return 0;
        }

        int leftDepth =1, rightDepth=1;

        if  (root.left !=null) {
            leftDepth =  MaxDepth(root.left) + 1;
        } 

        if (root.right !=null) {
            rightDepth =  MaxDepth(root.right) + 1;
        }

        if (leftDepth > rightDepth) {
            return leftDepth;

        } else {
            return rightDepth;
        }

    }


    public static void DFS(Tree root) {

        LinkedList<Tree> stack = new LinkedList<Tree>();

        Tree current = root;


        while (current!=null) {
            System.out.print(current.data+" ");

            if (current.left != null) {
                stack.addFirst(current.left);
            }

            if (current.right !=null) {
                stack.addFirst(current.right);
            }

            current = stack.pollFirst();

        }

        return;


    }


    public static void preOrderRecursive(Tree root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data+"->");
        preOrderRecursive(root.left);
        preOrderRecursive(root.right); 
        return;

    }


    public static void inOrderRecursive(Tree root) {

        if (root == null) {
            return;
        }

        inOrderRecursive(root.left);
        System.out.print(root.data+"->");
        inOrderRecursive(root.right);

        return;
    }


    public static int isValidTree(Tree root, int current) throws Exception{

        if (root ==null) {
            return current;
        }
        
        
        current= isValidTree(root.left, current);
        if (current > root.data) 
            throw new Exception();
        else 
            current = root.data;
        int right = isValidTree(root.right, current);
        if (right < current) 
            throw new Exception();
        else 
            return right; 
    }


    public static boolean isValidBST(Tree root, int prev){

        if (root ==null) {
            return true;
        }
        
        
        if ((isValidBST(root.left, prev)) && (prev < root.data)) {

            prev = root.data;
            if (isValidBST(root.right, prev)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    public static void postOrderRecursive(Tree root) {

        if(root==null) {
            return;
        }


        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(root.data+"->");

        return;


    }


    public static void leastCommonAncestor(Tree root, int value1, int value2) {


        Tree current = root; 
        while (true) {

            if (current ==null) {
                System.out.println("Invalid value, cannot find LCA");
                return;
            }
            System.out.println("current is: "+current.data);
            if (value1 > current.data && value2 > current.data) {
                current = current.right;
            } else if (value1 < current.data && value2 < current.data) {
                current = current.left;
            } else {
                System.out.println("the LCA is: " + current.data);
                return;
            }
        }


    }

    public static int isTreeBalanced(Tree root) throws Exception {

        if (root == null) {
            return 0;
        }


        int left = isTreeBalanced(root.left);
        int right = isTreeBalanced(root.right);
        if (left - right > 1) { throw new Exception();}
        return (left>right ? left+1 : right+1);

    }


    public static ArrayList<Tree> treeToList(Tree root) {

        ArrayList<Tree> heads = new ArrayList<Tree>();
        LinkedList<Tree> queue = new LinkedList<Tree>();
        int currentLevelCount =1, nextLevelCount=0;

        Tree current = root;
        Tree prev = null;

        boolean newLevel = true;

        while (current!=null) {
            
            if (current.left != null) {
                queue.addLast(current.left);
                nextLevelCount++;
            }

            if (current.right != null) {
                queue.addLast(current.right);
                nextLevelCount++;
            }

            Tree temp = queue.pollFirst();
            currentLevelCount--;

            if (newLevel) {
                current.left = null;
                heads.add(current);
                newLevel = false;
            } else {
                current.left = prev;
            }
            


            if (currentLevelCount ==0) {
                current.right =null;
                currentLevelCount = nextLevelCount;
                nextLevelCount = 0;
                newLevel = true;
            } else {
                current.right = temp;
                prev = current;
            }
            current = temp;

                


        }

        return heads;


    }



    

    public static void printTreeLevelWise(Tree root) {

        
        LinkedList<Tree> queue = new LinkedList<Tree>();
        int currentLevelCount =0, nextLevelCount = 0, level =1;

        boolean newLevel = true;

        Tree current = root;

        while (current!=null) {

            if (newLevel) {
                System.out.print("Level "+(level++)+": ");
                newLevel = false;
            }

            System.out.print(current.data+ " ");

            if (current.left!=null) {
                queue.addLast(current.left);
                nextLevelCount++;
            }

            if (current.right!=null) {
                queue.addLast(current.right);
                nextLevelCount++;
            }

            if (currentLevelCount == 0) {
                currentLevelCount = nextLevelCount;
                nextLevelCount = 0;
                System.out.print("\n");
                newLevel = true;
            }


            current = queue.pollFirst();
            currentLevelCount--;
        }

        return;
    }

}
