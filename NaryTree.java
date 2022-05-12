import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class NaryTree<E extends Comparable<E>> {
    
    /**
     * This inner class encapsulates the data and children for a Node.
     * Do NOT edit this inner class.
     */
    protected class Node{
        E data;
        List<Node> children;
    
        /**
         * Initializes the node with the data passed in
         * 
         * @param data The data to initialize the node with
         */
        public Node(E data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    
        /**
         * Getter for data
         * 
         * @return Return a reference to data
         */
        public E getData() {
            return data;
        }

        /**
         * Setter for the data
         * 
         * @param data Data that this node is set to
         */
        public void setData(E data) {
            this.data = data;
        }

        /**
         * Getter for children
         * 
         * @return reference to the list of children
         */
        public List<Node> getChildren() {
            return children;
        }

        /**
         * Returns the number of children
         * 
         * @return number of children
         */
        public int getNumChildren() {
            // assume there are no nulls in list
            return children.size();
        }

        /**
         * Add the given node to this node's list of children
         * 
         * @param node The node to add
         */
        public void addChild(Node node) {
            children.add(node);
        }
    
    }
    
    Node root;
    int size;
    int N;

    /**
     * Constructor that initializes an empty N-ary tree, with the given N
     * 
     * @param N The N the N-tree should be initialized with
     */
    public NaryTree(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        this.root = null;
        this.size = 0;
        this.N = N;
    }

    /**
     * Adds an element to the N-ary tree in level order
     * @param element the element to be added
     */
    public void add(E element) {
        if (element == null) {
            throw new NullPointerException();
        }
        if (this.size == 0) {
            this.root = new Node(element);
        } else {
            // produce level order traversal
            Queue<Node> toVisit = new LinkedList<>();
            Queue<Node> traversed = new LinkedList<>();
            toVisit.add(this.root);
            while (!toVisit.isEmpty()) {
                Node visiting = toVisit.poll();
                traversed.add(visiting);
                for (int i = 0; i < visiting.getNumChildren(); i++) {
                    toVisit.add(visiting.getChildren().get(i));
                }
            }
            // iterate through traversal to find where
            // to add node
            for (Node n : traversed) {
                if (n.getNumChildren() < this.N) {
                    n.addChild(new Node(element));
                    break;
                }
            }
        }
        this.size++;
    }

    /**
     * Checks if the given element is found within
     * the N-ary tree
     * @param element the element to look for
     * @return true if the element is found, false
     * if it isn't
     */
    public boolean contains(E element) {
        if (element == null) {
            throw new NullPointerException();
        }
        // produce level order traversal
        Queue<Node> toVisit = new LinkedList<>();
        toVisit.add(this.root);
        while (!toVisit.isEmpty()) {
            Node visiting = toVisit.poll();
            // check if the node is present
            if (visiting.getData() == element) {
                return true;
            }
            for (int i = 0; i < visiting.getNumChildren(); i++) {
                toVisit.add(visiting.getChildren().get(i));
            }
        }
        return false;
    }

    /**
     * Returns an ArrayList of the N-ary tree
     * sorted in ascending order
     * @return ArrayList of the N-ary tree
     * sorted in ascending order
     */
    public ArrayList<E> sortTree(){
        ArrayList<E> result = new ArrayList<>();
        if (this.size == 0) {
            return result;
        } else {
            // use priority queue to store elements
            // in ascending order
            PriorityQueue<E> ordering = new PriorityQueue<>();
            Queue<Node> toVisit = new LinkedList<>();
            toVisit.add(this.root);
            while (!toVisit.isEmpty()) {
                Node visiting = toVisit.poll();
                ordering.add(visiting.getData());
                for (int i = 0; i < visiting.getNumChildren(); i++) {
                    toVisit.add(visiting.getChildren().get(i));
                }
            }
            int totalLen = ordering.size();
            for (int i = 0; i < totalLen; i++) {
                result.add(ordering.poll());
            }
        }
        return result;
    }
}