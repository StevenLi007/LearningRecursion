public class LinkedListReverse {
    static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public void setNext(Node node) {
            this.next = node;
        }

        public Node getNext() {
            return this.next;
        }
    }

    public static Node reverseList(Node node) {
        // this makes sense because to write the base case, we are
        // looking for the most trivial version(s) of the problem to
        // solve
        if (node == null || node.next == null) {
            return node;
        }
        // Note to self: originally thought p was useless, but realized 
        // its use is to determine the new head of the reversed list

        // In terms of reflecting on the solution retrospectively, I'm 
        // fully capable of tracing through the algorithm, but I cannot
        // ascertain how I would arrive at this elegant and concise
        // solution on my own.
        Node p = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return p;
    }

    private static void printLinkedList(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.println(temp.val + " ");
            temp = temp.getNext();
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);

        printLinkedList(n1);
        Node reversedHead = reverseList(n1);
        System.out.println();
        printLinkedList(reversedHead);
    }
}