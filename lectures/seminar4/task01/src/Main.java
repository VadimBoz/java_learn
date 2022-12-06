import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        int i = 0;
        ArrayList<String> arListName = new ArrayList<>();
        ArrayList<String> arListLastName = new ArrayList<>();
        ArrayList<Integer> arListAge = new ArrayList<>();
        ArrayList<Boolean> arListGender = new ArrayList<>();
        LinkedList<Integer> key = new LinkedList<>();
        String str = "", gender = "";
        int age = 0;
        boolean genderBoln = false;
        while (true) {
            System.out.println("Введите имя (или end для завершения): ");
            str = scanner.nextLine();
            if (str.equals("end")) break;
            arListName.add(str);
            System.out.println("Введите фамилию: ");
            str = scanner.nextLine();
            arListLastName.add(str);
            System.out.println("Введите возраст: ");
            str = scanner.nextLine();
            age = Integer.parseInt(str);
            arListAge.add(age);
            System.out.println("Введите пол (М или Ж - любой символ): ");
            str = scanner.nextLine();
            genderBoln = !str.equalsIgnoreCase("m") && !str.equalsIgnoreCase("м");
            arListGender.add(genderBoln);
            key.add(i);
            i++;
        }

//        sortArListStr(arListName, key);  // сортирока по имени
        System.out.println(arListName);
        System.out.println(arListLastName);
        System.out.println(arListAge);
        System.out.println(arListGender);

        // получение массива клюдей для сортировки списков по возрасту
        sortArListInt(arListAge, key);

        // сортируем списки по  возрасту в соответствии с ключем
        reSortAr1ListInt(arListName, arListLastName, arListGender,  arListAge,  key);
        System.out.println(" после сортировки");
        System.out.println(arListName);
        System.out.println(arListLastName);
        System.out.println(arListAge);
        System.out.println(arListGender);
        System.out.println(key);
    }


    private static void sortArListStr(ArrayList<String> arLst, LinkedList<Integer> key)
    {
        int lenList = arLst.size(), tmp;
        String str1 = "", str2 = "";
        for (int i = 0; i < lenList-1; i++) {
            str1 = arLst.get(key.get(i));
            for (int j = i+1; j < lenList; j++) {

                str2 = arLst.get(key.get(j));
                if (str2.toLowerCase().compareTo(str1.toLowerCase()) < 0) {
                    tmp = key.get(i);
                    key.set(i,key.get(j));
                    key.set(j,tmp);
                }
            }
        }
    }
    private static void sortArListInt(ArrayList<Integer> arLst, LinkedList<Integer> key)
    {
        int lenList = arLst.size(), tmp;
        int num1, num2;
        for (int i = 0; i < lenList-1; i++) {
            num1 = arLst.get(key.get(i));
            for (int j = i+1; j < lenList; j++) {

                num2 = arLst.get(key.get(j));
                if (num2 < num1) {
                    tmp = key.get(i);
                    key.set(i,key.get(j));
                    key.set(j,tmp);
                }
            }
        }
    }

    private static void reSortAr1ListInt( ArrayList<String> arListName,
                                          ArrayList<String> arListLastName,
                                          ArrayList<Boolean> arListGender,
                                          ArrayList<Integer> arListAge,
                                          LinkedList<Integer> key )
    {


        ArrayList<Integer> adKey = new ArrayList<>();
        int index;
        String name, lastName , tempName, tempLastName;
        int  age, tempAge;
        boolean gender, tempGender ;

        adKey.add(0);
        for (int i = 0; i < key.size(); i++)
            {
            if (adKey.indexOf(i) > 0)
                continue;
            index = key.get(i);
            name = arListName.get(index);
            lastName   =  arListName.get(index);
            gender = arListGender.get(index);
            age = arListAge.get(index);

            tempName = arListName.get(i);
            tempLastName   =  arListName.get(i);
            tempGender = arListGender.get(i);
            tempAge = arListAge.get(i);

            arListName.set(i, name);
            arListName.set(index, tempName);

            arListLastName.set(i, lastName );
            arListLastName.set(index ,tempLastName);

            arListGender.set(i, gender);
            arListGender.set(index,tempGender);

            arListAge.set(i, age);
            arListAge.set(index, tempAge);

            adKey.add(index);
        }
//        return arLst;
    }

}