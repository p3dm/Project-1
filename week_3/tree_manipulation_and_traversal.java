package week_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/***
 * Mỗi nút trên cây có trường id (identifier) là một số nguyên (id của các nút trên cây đôi một khác nhau)
 * Thực hiện 1 chuỗi các hành động sau đây bao gồm các thao tác liên quan đến xây dựng cây và duyệt cây
 * · MakeRoot u: Tạo ra nút gốc u của cây
 * · Insert u v: tạo mới 1 nút u và chèn vào cuối danh sách nút con của nút v (nếu nút có id bằng v không tồn tại hoặc nút có id bằng u đã tồn tại thì không chèn thêm mới)
 * · PreOrder: in ra thứ tự các nút trong phép duyệt cây theo thứ tự trước
 * · InOrder: in ra thứ tự các nút trong phép duyệt cây theo thứ tự giữa
 * · PostOrder: in ra thứ tự các nút trong phép duyệt cây theo thứ tự sau
 * Dữ liệu: bao gồm các dòng, mỗi dòng là 1 trong số các hành động được mô tả ở trên, dòng cuối dùng là * (đánh dấu sự kết thúc của dữ liệu).
 * Kết quả: ghi ra trên mỗi dòng, thứ tự các nút được thăm trong phép duyệt theo thứ tự trước, giữa, sau của các hành động PreOrder, InOrder, PostOrder tương ứng đọc được từ dữ liệu đầu vào
 * Ví dụ
 * Dữ liệu
 * MakeRoot 10
 * Insert 11 10
 * Insert 1 10
 * Insert 3 10
 * InOrder
 * Insert 5 11
 * Insert 4 11
 * Insert 8 3
 * PreOrder
 * Insert 2 3
 * Insert 7 3
 * Insert 6 4
 * Insert 9 4
 * InOrder
 * PostOrder
 * *
 * Kết quả
 * 11 10 1 3
 * 10 11 5 4 1 3 8
 * 5 11 6 4 9 10 1 8 3 2 7
 * 5 6 9 4 11 1 8 2 7 3 10
 */
class Node{
    int id;
    Node children;
    Node next;

    Node(int id) {
        this.id = id;
        this.children = null;
        this.next = null;
    }
}
public class tree_manipulation_and_traversal {
    public static Node makeRoot(int id){
        return new Node(id);
    }

    public static Node insert(Node node, int u, int v){
        if (node == null) {
            return new Node(u);
        }

        if (node.id == v) {
            Node child = node.children;
            if (child == null) {
                node.children = makeRoot(u);
            } else {
                while (child.next != null) {
                    child = child.next;
                }
                child.next = makeRoot(u);
            }
        } else {
            insert(node.children, u, v);
            insert(node.next, u, v);
        }
        return node;
    }
    public static void inOrder(Node node){
        if (node == null) {
            return;
        }

        if (node.children != null) {
            Node child = node.children;
            inOrder(child);

            System.out.print(node.id + " ");

            child = child.next;
            while (child != null) {
                inOrder(child);
                child = child.next;
            }
        } else {
            System.out.print(node.id + " ");
        }
    }
    public static void preOrder(Node node){
        if (node == null) {
            return;
        }
        System.out.print(node.id + " ");
        preOrder(node.children);
        preOrder(node.next);
    }
    public static void postOrder(Node node){
        if (node == null) {
            return;
        }
        postOrder(node.children);
        System.out.print(node.id + " ");
        postOrder(node.next);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node node = null;
        String line;

        while((line = br.readLine()) != null) {
            if (line.equals("*")) {
                break;
            }
            String[] arr = line.split(" ");
            if (arr[0].equals("MakeRoot")) {
                int id = Integer.parseInt(arr[1]);
                node = makeRoot(id);
            }
            if (arr[0].equals("Insert")) {
                int u = Integer.parseInt(arr[1]);
                int v = Integer.parseInt(arr[2]);
                node = insert(node, u, v);
            }
            if (arr[0].equals("InOrder")) {
                inOrder(node);

                System.out.println();
            }
            if (arr[0].equals("PreOrder")) {
                preOrder(node);

                System.out.println();
            }
            if (arr[0].equals("PostOrder")) {
                postOrder(node);

                System.out.println();
            }
        }

    }

}
