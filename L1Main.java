import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 将已知数据装进数组
        double Z[] = {36, 36.5, 37, 37.5, 38, 38.5, 39,39.5, 40, 40.5};
        int V[] = {4330, 4800, 5310, 5860, 6450, 7080, 7760, 8540, 9420, 10250};
        double Q[] = {0, 22.5, 55, 105, 173.9, 267.2, 378.3, 501.9, 638.9, 786.1};
        Scanner in = new Scanner(System.in);
        // do-while循环：检查输入的值是否满足插值的区间
        double z;
        do {
            System.out.print("请输入Z值(36.5≤z≤40.5):");
            z = in.nextDouble();
        } while ( 40.5 < z || z < 36);

        // for循环：找到目标区间
        for (int i = 0; i < Z.length; i++) {
            // 对于已有数据无需插值
            if (Z[i] == z) {
                System.out.println("无需插值 V = " + V[i] + " " + "q = " + Q[i]);
            }
            // 根据区间两端确定值，代入公式进行插值
            if (Z[i] < z && Z[i + 1] > z) {
                double V0 = V[i] + (z - Z[i]) / (Z[i + 1] - Z[i]) * (V[i + 1] - V[i]);
                double q0 = Q[i] + (z - Z[i]) / (Z[i + 1] - Z[i]) * (Q[i + 1] - Q[i]);
                // 输出
                System.out.println("一维插值 V = " + V0);
                System.out.println("一维插值 q = " + q0);
            }
        }
        
    }
}
