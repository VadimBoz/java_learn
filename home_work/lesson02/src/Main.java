public class Main {
    public static void main(String[] args)
    {
        //1. Напишите программу на Java, чтобы найти наименьшее окно в строке, содержащей все символы другой строки.
//        String str1="12345345878787857";
        String str1="54588858";
        String str2="5";
        String fI = findIncorporation (str1, str2, 0);
        if (fI=="")  System.out.printf("1. вхождения строки \"%s\" в строку \"%s\" не найдены\n", str2, str1);
        else System.out.printf("1. индексы вхождения строки \"%s\" в строку \"%s\"  -   %s\n", str2, str1, fI);


//     2.   Напишите программу на Java, чтобы проверить, являются ли две данные строки вращением друг друга.
        String st1="12345";
        String st2="54321";
//        String st1="world";
//        String st2="world";
        String check = checkMirror(st1, st2);
        System.out.printf("2. %s\n", check);

//     3. *Напишите программу на Java, чтобы перевернуть строку с помощью рекурсии.
        String str = "1234567";
        String str4 =   reverseSting(str, str.length()-1);
        System.out.printf("3. отражение строки %s  - %s", str, str4);

//     4. Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168
        int num1 = 3;
        int num2= 56;
        String st = CalkNum(num1,num2);
        System.out.println("\n4. ");
        System.out.println(st);

//     5. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
        String st5 = replaceSymbol_1(st, "=", "равно", 0);
        System.out.println("\n5. замена символа '=' на слово 'равно' ");
        System.out.println(st5);

//     6. *Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
        String st6 = replaceSymbol_2(st5, "равно", "=",0);
        System.out.println("\n6. замена символа 'равно' на слово '=' ");
        System.out.println(st6);

//      7. **Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.

        String str7 = GenStr("=","u", 10);
        System.out.println("\n7. ");
        System.out.println(str7);
        String str8= replaceSymbol_2(str7, "=", "+",0);
        System.out.println(str8);

        String str9 = CompareMethods( 50, 2000);
        System.out.println(str9);

    }




    static private String checkMirror(String str1, String str2)
    {
        StringBuilder stringBuilder1 = new StringBuilder(str1);
        StringBuilder stringBuilder2 = new StringBuilder(str2);
        stringBuilder1.reverse();
        int res = stringBuilder1.compareTo(stringBuilder2);
//        System.out.println(res);
        if (res==0) return String.format("строки %s  и %s являются отражением друг друга", str1, str2);
        else return String.format("строки %s  и %s не являются отражением друг друга", str1, str2);
    }


    static private String findIncorporation (String str1, String str2, int startIndex)
    {
            int res;
            StringBuilder stringBuilder1 = new StringBuilder(str1);
            StringBuilder stringBuilder2 = new StringBuilder();
            res = stringBuilder1.indexOf(str2, startIndex);
            if (res > -1)
            {
                stringBuilder2.append(res);
                stringBuilder2.append(", ");
                stringBuilder2.append(findIncorporation(str1, str2, res + 1));
                return stringBuilder2.toString();
            }
            else return "";
    }

    static private String reverseSting(String str, int highIndex)
    {
        StringBuilder sb = new StringBuilder();
        if(highIndex == 0){
            return Character.toString(str.charAt(0));
        }
        sb.append(str.charAt(highIndex));
        return sb.append(reverseSting(str, highIndex-1)).toString();
    }


    static private String CalkNum(int num1, int num2)
    {
        int res1 = num1 + num2;
        int res2 = num1 - num2;
        int res3 = num1 * num2;
        StringBuilder sB = new StringBuilder();
        sB.append("Результат работы метода  CalkNum\n");
        sB.append(String.format("%d + %d = %d\n",num1,num2,res1));
        sB.append(String.format("%d - %d = %d\n",num1,num2,res2));
        sB.append(String.format("%d * %d = %d\n",num1,num2,res3));
        return sB.toString();
    }

    static private String replaceSymbol_1(String str_data, String strToReplace, String strReplaced, int startIndex)
    {
        int len = strToReplace.length();
        StringBuilder sb = new StringBuilder(str_data);
        int res = sb.indexOf(strToReplace, startIndex);
        if (res < 0) return str_data;
        else
        {
            sb.deleteCharAt(res);
            sb.insert(res, strReplaced);
            str_data = sb.toString();
            return replaceSymbol_1(str_data, strToReplace, strReplaced, startIndex + len);
        }
    }

    static private String replaceSymbol_2(String str_data, String strToReplace, String strReplaced, int startIndex)
    {
        int len = strToReplace.length();
        StringBuilder sb = new StringBuilder(str_data);
        int res = sb.indexOf(strToReplace, startIndex);
        if (res < 0) return str_data;
        else
        {
            sb.replace(res,res + len, strReplaced);
            str_data = sb.toString();
            return replaceSymbol_2(str_data, strToReplace, strReplaced, startIndex + len);
        }
    }


    static private String GenStr(String str1, String str2, int count)
    {
       StringBuilder sB= new StringBuilder();
        for (int i = 0; i < count; i++)
        {
            sB.append(str1);
            sB.append(str2);
        }
    return sB.toString();



    }
    static private String replaceSymbol_3(String str_data, String strToReplace, String strReplaced, int startIndex)
    {
        String str_res = "";
        String  temp;
        for (int i = startIndex; i < str_data.length(); i++)
        {
            temp = Character.toString(str_data.charAt(i));
            if (temp.equals(strToReplace)) str_res  += strReplaced;
            else  str_res  += temp;
        }
            return str_res ;
    }

    static private String replaceSymbol_4(String str_data, String strToReplace, String strReplaced, int startIndex)
    {
        return str_data.replace(strToReplace, strReplaced);
    }


    static private String CompareMethods(int iterations, int countSymbols)
    {
        String str1;
        String str2;
        long start = System.currentTimeMillis();
                for (int i = 0; i < iterations+1; i++)
                {
                    str1 = GenStr("=", "u", countSymbols);
                    str2 = replaceSymbol_3(str1, "=", "+", 0);

                }
        long end = System.currentTimeMillis();
        long middleTimeStr = (end-start)/1;

        start = System.currentTimeMillis();
                for (int i = 0; i < iterations+1; i++)
                {
                    str1 = GenStr("=", "u", countSymbols);
                    str2 = replaceSymbol_4(str1, "=", "+", 0);

                }
        end = System.currentTimeMillis();
        long middleTimeStrBilder = (end-start)/1;

        String res = String.format("время выполнения с использованием методов строк - %d\n" +
                                      "время выполнения с использованием StringBuilder - %d\n",
                                                         middleTimeStr,  middleTimeStrBilder);
        return res;


    }




}
