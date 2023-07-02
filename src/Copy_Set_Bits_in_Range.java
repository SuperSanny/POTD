import java.util.*;
public class Copy_Set_Bits_in_Range {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter X, Y, l & r :");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(setSetBit1(x, y, l, r));
    }

    private static int setSetBit(int x, int y, int l, int r) {
        int mask = (int)((-1L << (l-1)) ^ (-1L << r));
        return x | (y & mask);
    }
    // Another approach
    private static int setSetBit1(int x, int y, int l, int r) {
        int i= l - 1;
        while(i < r){
            int rightShift = (y >> i) & 1;
            x = x | (rightShift << i);
            i++;
        }
        return x;
    }
}
