package week_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;


/***
 * Viết chương trình thực hiện công việc sau:
 * Xây dựng danh sách liên kết với các khóa được cung cấp ban đầu là dãy a
 * 1
 * , a
 * 2
 * , …, a
 * n
 * , sau đó thực hiện các thao tác trên danh sách bao gồm: thêm 1 phần tử vào đầu, vào cuối danh sách, hoặc vào trước, vào sau 1 phần tử nào đó trong danh sách, hoặc loại bỏ 1 phần tử nào đó trong danh sách
 *
 * Input
 * Dòng 1: ghi số nguyên dương n (1 <= n <= 1000)
 * Dòng 2: ghi các số nguyên dương a
 * 1
 * , a
 * 2
 * , …, a
 * n
 * .
 * Các dòng tiếp theo lần lượt là các lệnh để thao tác (kết thúc bởi ký hiệu #) với các loại sau:
 * addlast  k: thêm phần tử có key bằng k vào cuối danh sách (nếu k chưa tồn tại)
 * addfirst  k: thêm phần tử có key bằng k vào đầu danh sách (nếu k chưa tồn tại)
 * addafter  u  v: thêm phần tử có key bằng u vào sau phần tử có key bằng v trên danh sách (nếu v đã tồn tại trên danh sách và u chưa tồn tại)
 * addbefore  u  v: thêm phần tử có key bằng  u vào trước phần tử có key bằng v trên danh sách (nếu v đã tồn tại trên danh sách và u chưa tồn tại)
 * remove  k: loại bỏ phần tử có key bằng k khỏi danh sách
 * reverse: đảo ngược thứ tự các phần tử của danh sách (không được cấp phát mới các phần tử, chỉ được thay đổi mối nối liên kết)
 * Output
 * Ghi ra dãy khóa của danh sách thu được sau 1 chuỗi các lệnh thao tác đã cho
 *
 * Example
 * Input
 * 5
 * 5 4 3 2 1
 * addlast 3
 * addlast 10
 * addfirst 1
 * addafter 10 4
 * remove 1
 * #
 *
 * Output
 * 5 4 3 2 10
 */

public class linked_list_manipulation {
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> list = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        for(String s : arr){
            list.add(Integer.parseInt(s));
        }
        String line;
        while((line = br.readLine()) != null){
            if(line.equals("#")){
                break;
            }
            String[] input = line.split(" ");
            if(input[0].equals("addlast")){
                int k = Integer.parseInt(input[1]);
                if(!list.contains(k)){
                    list.add(k);
                }
            }
            else if (input[0].equals("addfirst")){
                int k = Integer.parseInt(input[1]);
                if(!list.contains(k)){
                    list.addFirst(k);
                }
            }
            else if(input[0].equals("addafter")){
                int u = Integer.parseInt(input[1]);
                int v = Integer.parseInt(input[2]);
                if(list.contains(v) && !list.contains(u)){
                    list.add(list.indexOf(v) + 1, u);
                }
            }
            else if(input[0].equals("addbefore")){
                int u = Integer.parseInt(input[1]);
                int v = Integer.parseInt(input[2]);
                if(list.contains(v) && !list.contains(u)){
                    list.add(list.indexOf(v), u);
                }
            }
            else if(input[0].equals("remove")){
                int k = Integer.parseInt(input[1]);
                list.remove((Integer) k);
            }
            else if(input[0].equals("reverse")){
                LinkedList<Integer> reversed = new LinkedList<>();
                for(int i = list.size() - 1; i >= 0; i--){
                    reversed.add(list.get(i));
                }
                list = reversed;
            }
        }
        for(Integer s : list){
            System.out.print(s + " ");
        }
    }
}
