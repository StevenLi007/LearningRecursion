public class BinarySearchTree {
    Node head;

    static class Node {
        private int val;
        private Node parent;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }

        public void setParent(Node node) {
            this.parent = node;
        }

        public void setLeft(Node node) {
            this.left = node;
        }

        public void setRight(Node node) {
            this.right = node;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getParent() {
            return this.parent;
        }

        public Node getLeft() {
            return this.left;
        }

        public Node getRight() {
            return this.right;
        }

        public int getVal() {
            return this.val;
        }
    }

    public BinarySearchTree(Node head) {
        this.head = head;
    }

    public void add(Node node) {
        Node curr = this.head;
        while (curr != null) {
            if (node.getVal() <= curr.getVal()) {
                if (curr.getLeft() == null) {
                    curr.setLeft(node);
                    node.setParent(curr);
                    break;
                }
                curr = curr.getLeft();
            } else {
                if (curr.getRight() == null) {
                    curr.setRight(node);
                    node.setParent(curr);
                    break;
                }
                curr = curr.getRight();
            }
        }
    }

    // inorder traversal

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        BinarySearchTree bst = new BinarySearchTree(n3);
        bst.add(n2);
        System.out.println(bst.head.getVal());
        System.out.println(bst.head.getLeft().getVal());
    }
}