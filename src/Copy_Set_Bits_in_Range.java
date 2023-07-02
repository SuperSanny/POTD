import java.util.*;
public class Copy_Set_Bits_in_Range {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter X, Y, l & r :");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(setSetBit(x, y, l, r));
    }

    private static int setSetBit(int x, int y, int l, int r) {
        int mask = (int)((-1L << (l-1)) ^ (-1L << r));
        return x | (y & mask);
    }
}
