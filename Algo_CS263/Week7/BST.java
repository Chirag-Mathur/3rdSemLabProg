package Algo_CS263.Week7;

public class BST {
    public static int random(int min, int max) {
        return ((int) (Math.random() * (max - min))) + min;
    }

    public class Node {
        int data;
        Node left, right = null;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    public void add_node(int data) {
        Node new_node = new Node(data);
        if (root == null) {
            root = new_node;
        } else {
            Node focus_node = root;
            Node parent_node;
            while (true) {
                parent_node = focus_node;
                if (data < focus_node.data) {
                    focus_node = focus_node.left;
                    if (focus_node == null) {
                        parent_node.left = new_node;
                        return;
                    }
                } else {
                    focus_node = focus_node.right;
                    if (focus_node == null) {
                        parent_node.right = new_node;
                        return;
                    }
                }
            }
        }
    }

    public void inorder_traverse(Node focus_node) {
        if (focus_node != null) {
            inorder_traverse(focus_node.left);
            System.out.println(focus_node.data);
            inorder_traverse(focus_node.right);
        }
    }

    public Node minNode(Node root) {
        if (root.left != null)
            return minNode(root.left);
        else
            return root;
    }

    public Node deleteNode(Node node, int value) {
        if (node == null) {
            return null;
        } else {
            if (value < node.data)
                node.left = deleteNode(node.left, value);
            else if (value > node.data)
                node.right = deleteNode(node.right, value);
            else {
                if (node.left == null && node.right == null)
                    node = null;
                else if (node.left == null) {
                    node = node.right;
                } else if (node.right == null) {
                    node = node.left;
                } else {
                    Node temp = minNode(node.right);
                    node.data = temp.data;
                    node.right = deleteNode(node.right, temp.data);
                }
            }
            return node;
        }
    }

    public static void main(String[] args) {
        BST treep = new BST();
        int n = 2000;
        long starttime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            treep.add_node(i + 1);
        }
        long finaltime = System.nanoTime();
        // System.out.println((finaltime-starttime)/1000);//Node root;
        // treep.inorder_traverse(treep.root);
        long starttimee = System.nanoTime();
        for (int i = 0; i < n; i++) {
            treep.deleteNode(treep.root, i + 1);
        }
        long finaltimee = System.nanoTime();
        System.out.println((finaltimee - starttimee) / 1000);
        // treep.inorder_traverse(treep.root);
    }
}