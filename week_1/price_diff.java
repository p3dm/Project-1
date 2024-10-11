package week_1;

import java.io.BufferedReader;

/**
 * Hiện tại giá điện đang được tính theo bậc thang gồm 6 mức (mức điều chỉnh từ 04/05/2023), với giá thấp nhất (bậc 1) là 1.728VND và giá bậc cao nhất là 3.015 VND. Tuy nhiên EVN đang đề xuất một cách tính giá điện bậc thang mới chỉ gồm 5 mức như hinh dưới, giá thấp nhất (bậc 1) khoảng 1.728 đồng một kWh và cao nhất (bậc 5) là 3.457 đồng một kWh.
 *
 * Bậc	Biểu giá hiện hành	Phương án 5 bậc
 *   	Mức sử dụng	Giá (*)	Mức sử dụng	Giá
 * 1	0-50 kWh	1.728	0-100 kWh	1.728
 * 2	51-100 kWh	1.786	101-200 kWh	2.074
 * 3	101-200 kWh	2.074	201-400 kWh	2.612
 * 4	201-300 kWh	2.612	401-700 kWh	3.111
 * 5	301-400 kWh	2.919	701 kWh trở lên	3.457
 * 6  	401 kWh trở lên	3.015
 * (*) Giá chưa bao gồm thuế VAT
 *
 * Hãy xây dựng chương trình nhập vào số kwh điện của một hộ tiêu thụ và so sánh xem theo bảng giá mới đang lấy ý kiến thì tiền điện tiêu thụ của hộ đó sẽ tăng thêm hay giảm đi bao nhiêu.
 *
 * INPUT: là số kwh điện tiêu thụ của hộ (là số nguyên)
 * OUTPUT: là chênh lệch giữa giá theo đề xuất và giá theo mô hình bậc thang 6 mức đang được áp dụng.
 *
 * VAT sẽ được lấy là 10%, và kết quả in ra sẽ lấy tới 2 chữ số thập phân
 *
 * EXAMPLE
 * INPUT
 * 540
 * OUTPUT
 * -22176.00
 *
 *
 * INPUT
 * 70
 * OUTPUT
 * -1276.00
 */

public class price_diff {
    public static double VAT = 0.1;
    public static double currentPrice(int kWh){
        double price = 0;
        if(kWh <= 50){
            price = kWh * 1.728;
        }
        if(kWh > 50 && kWh <= 100){
            price = 50 * 1728 + (kWh - 50)*1.786;
        }
        if(kWh > 100 && kWh <= 200){
            price = 50 * 1728 + 50 * 1786 + (kWh - 100)*2074;
        }
        if (kWh > 200 && kWh <= 300){
            price = 50 * 1728 + 50 * 1786 + 100 * 2074 + (kWh - 200)*2612;
        }
        if (kWh > 300 && kWh <= 400){
            price = 50 * 1728 + 50 * 1786 + 100 * 2074 + 100 * 2612 + (kWh - 300)*2919;
        }
        if (kWh > 400){
            price = 50 * 1728 + 50 * 1786 + 100 * 2074 + 100 * 2612 + 100 * 2919 + (kWh - 400)*3015;
        }
        return price;
    }

    public static double newPrice(int kWh){
        double price = 0;
        if(kWh <= 100){
            price = kWh * 1728;
        }
        if(kWh > 100 && kWh <= 200){
            price = 100 * 1728 + (kWh - 100)*2074;
        }
        if (kWh > 200 && kWh <= 400){
            price = 100 * 1728 + 100 * 2074 + (kWh - 200)*2612;
        }
        if (kWh > 400 && kWh <= 700){
            price = 100 * 1728 + 100 * 2074 + 200 * 2612 + (kWh - 400)*3111;
        }
        if (kWh > 700){
            price = 100 * 1728 + 100 * 2074 + 200 * 2612 + 300 * 3111 + (kWh - 700)*3457;
        }
        return price;
    }
    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int kWh = Integer.parseInt(br.readLine());
        double current = currentPrice(kWh)+currentPrice(kWh)*VAT;
        double newPrice = newPrice(kWh)+newPrice(kWh)*VAT;
        double diff = newPrice - current;
        System.out.printf("%.2f", diff);

    }
}
