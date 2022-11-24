import java.util.Scanner;
public class program 
    {
        public static void main(String[] args) 
            {
                Scanner iScan = new Scanner(System.in);
                System.out.println("int a:");
                boolean flag = iScan.hasNextInt();
                System.out.println(flag);
                int i = iScan.nextInt();
                System.out.println(i);
                System.out.println();
                iScan.close();
            }
    }

