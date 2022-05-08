public class MergeSortedList {
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

    public static Node mergeSortedList(Node A, Node B) {
        if (A == null) {
            return B;
        }
        if (B == null) {
            return A;
        }

        if (A.val < B.val) {
            A.next = mergeSortedList(A.next, B);
            return A;
        } else {
            B.next = mergeSortedList(A, B.next);
            return B;
        }
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

        n1.setNext(n3);
        n2.setNext(n4);
        n3.setNext(n5);

        printLinkedList(n1);
        printLinkedList(n2);
        mergeSortedList(n1, n2);
        printLinkedList(n1);
    }
}