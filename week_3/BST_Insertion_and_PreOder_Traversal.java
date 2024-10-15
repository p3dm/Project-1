package week_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/***
 * Given a BST initialized by NULL. Perform a sequence of operations on a BST including:
 * insert k: insert a key k into the BST (do not insert if the key k exists)
 * Input
 * •Each line contains command under the form: “insert k”
 * •The input is terminated by a line containing #
 * Output
 * •Write the sequence of keys of nodes visited by the pre-order traversal (separated by a SPACE character)
 * Example
 * Input
 * insert 20
 * insert 10
 * insert 26
 * insert 7
 * insert 15
 * insert 23
 * insert 30
 * insert 3
 * insert 8
 * #
 * Output
 * 20 10 7 3 8 15 26 23 30
 */
class Node1{
    int key;
    Node1 left;
    Node1 right;
    public Node1(int item){
        key = item;
        left = right = null;
    }
}
public class BST_Insertion_and_PreOder_Traversal {
    public static Node1 nodeInsert(Node1 node, int key) {
        if (node == null) {
            return new Node1(key);
        }

        if(node.key == key){
            return node;
        }

        if(node.key > key){
            node.left = nodeInsert(node.left, key);
        } else {
            node.right = nodeInsert(node.right, key);
        }
        return node;
    }
    public static void preOrder(Node1 node){
        if(node != null){
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node1 root = null;
        String line;
        while((line = br.readLine()) != null){
            if(line.equals("#")){
                break;
            }
            String[] arr = line.split(" ");
            if(arr[0].equals("insert")){
                int k = Integer.parseInt(arr[1]);
                root = nodeInsert(root,k);
            }
        }
        preOrder(root);
    }
}
