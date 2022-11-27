import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Main {
    public static void main(String[] args) {


        int[] ar = new int[20];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = new Random().nextInt(100);
        }

        System.out.println(Arrays.toString(ar));

        int[] ar2 = new int[ar.length];
        for (int i = 0; i < ar.length; i++) {
            ar2[i] = ar[ar.length - i-1];
        }
        System.out.println(Arrays.toString(ar2));

        reverse(ar2, 0, ar2.length-1);
        System.out.println(Arrays.toString(ar2));

        String str = "wefweff hhtheher ergergrg";
        StringBuilder strBilder = new StringBuilder(str);
        strBilder.reverse();
        System.out.println(strBilder);
        System.out.println(str.charAt(str.length()-1));


    }
    public static void reverse(int[] nums, int low, int high)
    {
        int temp;
        if (low < high)
        {
            temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;

            reverse(nums, low + 1, high - 1);
        }
    }



}
