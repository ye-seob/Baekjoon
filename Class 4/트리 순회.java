import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class Node {
    char val;
    Node left;
    Node right;

    Node(char val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class Main {
    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val);
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Map<Character, Node> nodes = new HashMap<>();
        Node root = null;

        for (int i = 0; i < N; i++) {
            char parentVal = sc.next().charAt(0);
            char leftVal = sc.next().charAt(0);
            char rightVal = sc.next().charAt(0);

            Node parent = nodes.getOrDefault(parentVal, new Node(parentVal));
            nodes.put(parentVal, parent);

            if (root == null) root = parent;

            if (leftVal != '.') {
                Node leftNode = nodes.getOrDefault(leftVal, new Node(leftVal));
                parent.left = leftNode;
                nodes.put(leftVal, leftNode);
            }

            if (rightVal != '.') {
                Node rightNode = nodes.getOrDefault(rightVal, new Node(rightVal));
                parent.right = rightNode;
                nodes.put(rightVal, rightNode);
            }
        }

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }
}