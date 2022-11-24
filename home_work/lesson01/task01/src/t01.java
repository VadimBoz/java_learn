import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class t01
    {
        public static void main(String[] arg)
        {
            // 1. Генерация числа от -1000 до 1000
            int d = 1000;
            int numRnd = rndInt(d);

            // 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
            int num = numRnd;
            int n = numberHighestBit(num);
            System.out.printf("\nномер старшего значащего бита числа %d - %d\n", numRnd, n);

            //3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
            int k = 1546;
            int start = -5000;
            int[] m1 = findDivisible(k, start);
            System.out.printf("\nчисла кратные %d:\n", k);
            for (int itVar : m1) System.out.printf("%d, ", itVar);

            //4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
            k = 2;
            int end = 5;
            int[] m2 = findNonDivisibleNegative(k, end);
            System.out.printf("\n числа  не кратные %d:\n", k);
            for (int itVar : m2) System.out.printf("%d, ", itVar);
            recFil(m2, 20);
        }

        private static int rndInt(int num)
        {
            int i = new Random().nextInt(num*2+1);
            int res =   i-num;
            System.out.printf("случайное число в диапазоне -%d до %d: %d \n", num , num,  res);
            return res;
        }

        private static int numberHighestBit(int num)
        {
            String  binStr;
            int numHighestBit;

            if (num>0)
            {
                binStr = Integer.toBinaryString(num);
                numHighestBit = binStr.length();
                System.out.printf("\nчисло %d в двоичной системе счисления %s", num, binStr);
                return numHighestBit;
            }
            else
            {
                num = -num;
                binStr = Integer.toBinaryString(num);
                numHighestBit = binStr.length();
                System.out.printf("\nчисло %s в двоичной системе счисления %s (%s)", -num,  Integer.toBinaryString(-num), binStr);
                return numHighestBit;
            }
        }
        private static int[]  findDivisible(int num, int start)
        {
            int count=0;
            for (int i = start; i <= Short.MAX_VALUE; i++)
            {
                if (i % num == 0)  count++;
            }
            int[] res = new int[count];
            for (int i = start, j=0; i <= Short.MAX_VALUE; i++)
            {
                if (i % num == 0)
                {
                    res[j] = i;
                    j++;
                }
            }
            return res;
        }

        private static int[]  findNonDivisibleNegative(int num, int end)
        {
            int count=0;
            for (int i = Short.MIN_VALUE; i <= end; i++)
            {
                if (i % num != 0) count++;
            }
            int[] res = new int[count];
            for (int i = Short.MIN_VALUE, j=0; i <= end; i++)
            {
                if (i % num != 0)
                {
                    res[j] = i;
                    j++;
                }
            }
            return res;
        }


        private static void recFil(int[] array, int lenStr)
        {
            try (FileWriter fileWr = new FileWriter("m2.txt", false))
            {
//              fileWr.write("");
                for (int i = 0; i < array.length; i = i + lenStr) {
                    String stroke = "";
                    for (int j = 0; j < lenStr && j + i < array.length; j++) {
                        stroke += String.format("%d;", array[i + j]);
                    }
                    fileWr.append(stroke);
                    fileWr.append("\n");
                }
                fileWr.flush();
            }
            catch (IOException exept)
            {
                System.out.println(exept.getMessage());
            }
        }

    } //end

