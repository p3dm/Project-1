//package week_3;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//
///***
// * There are two jugs, a-litres jug and b-litres jug (a, b are positive integers). There is a pump with unlimited water. Given a positive integer c, how to get exactly c litres.
// * Input
// *    Line 1: contains positive integers a,   b,  c  (1 <= a, b, c <= 900)
// * Output
// *   write the number of steps or write -1 (if no solution found)
// * Example
// *
// * Input
// * 6  8  4
// * Output
// * 4
// */
//
//public class water_jugs {
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] arr = br.readLine().split(" ");
//        int a = Integer.parseInt(arr[0]);
//        int b = Integer.parseInt(arr[1]);
//        int c = Integer.parseInt(arr[2]);
//        int steps = 0;
//        steps = bfs(a, b, c);
//        System.out.println(steps);
//
//    }
//    public static int bfs(int a, int b, int c){
//        if (c > Math.max(a, b)) {
//            return -1;
//        }
//        Queue<int[]> q = new LinkedList<>();
//
//        boolean visited[][] = new boolean[a + 1][b + 1];
//        q.add(new int[]{0, 0, 0});
//        visited[0][0] = true;
//
//        while(!q.isEmpty()){
//            int[] hien_tai = q.poll();
//            int binh_1 = hien_tai[0];
//            int binh_2 = hien_tai[1];
//            int buoc = hien_tai[2];
//            if(binh_1 == c || binh_2 == c ){
//                return buoc;
//            }
//            // do vao binh 1 a lit
//            if(!visited[a][binh_2]){ // check xem da tham chua
//                visited[a][binh_2] = true;
//                q.add(new int[]{a, binh_2, buoc + 1});
//            }
//
//            // do day vao binh 2 b lit
//            if(!visited[binh_1][b]){
//                visited[binh_1][b] = true;
//                q.add(new int[]{binh_1, b, buoc + 1});
//            }
//
//            // do het nuoc binh 1 di
//            if(!visited[0][binh_2]){
//                visited[0][binh_2] = true;
//                q.add(new int[]{0, binh_2, buoc + 1});
//            }
//
//            // do het nuoc binh 2 di
//            if(!visited[binh_1][0]){
//                visited[binh_1][0] = true;
//                q.add(new int[]{binh_1, 0, buoc + 1});
//            }
//
//            //do nuoc tu binh 2 sang binh 1
//            int do_2_sang_1 = Math.min(binh_2, a - binh_1);
//            if(!visited[binh_1 + do_2_sang_1][binh_2 - do_2_sang_1]){
//                visited[binh_1 + do_2_sang_1][binh_2 - do_2_sang_1] = true;
//                q.add(new int[]{binh_1 + do_2_sang_1, binh_2 - do_2_sang_1, buoc + 1});
//            }
//
//            //do nuoc tu binh 1 sang binh 2
//            int do_1_sang_2 = Math.min(binh_1, b - binh_2);
//            if(!visited[binh_1 - do_1_sang_2][binh_2 + do_1_sang_2]){
//                visited[binh_1 - do_1_sang_2][binh_2 + do_1_sang_2] = true;
//                q.add(new int[]{binh_1 - do_1_sang_2, binh_2 + do_1_sang_2, buoc + 1});
//            }
//
//        }
//        return -1;
//    }
//}
package week_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/***
 * There are two jugs, a-litres jug and b-litres jug (a, b are positive integers). There is a pump with unlimited water. Given a positive integer c, how to get exactly c litres.
 * Input
 *    Line 1: contains positive integers a,   b,  c  (1 <= a, b, c <= 900)
 * Output
 *   write the number of steps or write -1 (if no solution found)
 * Example
 *
 * Input
 * 6  8  4
 * Output
 * 4
 */

public class water_jugs {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        int c = Integer.parseInt(arr[2]);
        int steps = 0;
        steps = bfs(a, b, c);
        System.out.println("Total steps: " + steps);
    }

    public static int bfs(int a, int b, int c) {
        if (c > Math.max(a, b)) {
            return -1;
        }
        Queue<int[]> q = new LinkedList<>();
        boolean visited[][] = new boolean[a + 1][b + 1];
        q.add(new int[]{0, 0, 0});
        visited[0][0] = true;

        int order = 0;
        while (!q.isEmpty()) {
            int[] hien_tai = q.poll();
            int binh_1 = hien_tai[0];
            int binh_2 = hien_tai[1];
            int buoc = hien_tai[2];
            System.out.println("Order " + order++ + ": binh_1 = " + binh_1 + ", binh_2 = " + binh_2 + ", steps = " + buoc);

            if (binh_1 == c || binh_2 == c) {
                return buoc;
            }

            // do vao binh 1 a lit
            if (!visited[a][binh_2]) {
                visited[a][binh_2] = true;
                q.add(new int[]{a, binh_2, buoc + 1});
            }

            // do day vao binh 2 b lit
            if (!visited[binh_1][b]) {
                visited[binh_1][b] = true;
                q.add(new int[]{binh_1, b, buoc + 1});
            }

            // do het nuoc binh 1 di
            if (!visited[0][binh_2]) {
                visited[0][binh_2] = true;
                q.add(new int[]{0, binh_2, buoc + 1});
            }

            // do het nuoc binh 2 di
            if (!visited[binh_1][0]) {
                visited[binh_1][0] = true;
                q.add(new int[]{binh_1, 0, buoc + 1});
            }

            // do nuoc tu binh 2 sang binh 1
            int do_2_sang_1 = Math.min(binh_2, a - binh_1);
            if (!visited[binh_1 + do_2_sang_1][binh_2 - do_2_sang_1]) {
                visited[binh_1 + do_2_sang_1][binh_2 - do_2_sang_1] = true;
                q.add(new int[]{binh_1 + do_2_sang_1, binh_2 - do_2_sang_1, buoc + 1});
            }

            // do nuoc tu binh 1 sang binh 2
            int do_1_sang_2 = Math.min(binh_1, b - binh_2);
            if (!visited[binh_1 - do_1_sang_2][binh_2 + do_1_sang_2]) {
                visited[binh_1 - do_1_sang_2][binh_2 + do_1_sang_2] = true;
                q.add(new int[]{binh_1 - do_1_sang_2, binh_2 + do_1_sang_2, buoc + 1});
            }
        }
        return -1;
    }
}