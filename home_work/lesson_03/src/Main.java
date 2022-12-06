import com.sun.source.tree.WhileLoopTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Main 
{
    public static void main(String[] args) throws Exception 
    {


//      1. Создать новый список, добавить несколько строк и вывести коллекцию на экран.
        ArrayList<Integer> ar= new ArrayList<>();
        Random rnd= new Random();
        for (int i = 0; i < 10; i++) {
            ar.add(rnd.nextInt(-10,10));

        }
        System.out.println("Task 1.");
        System.out.println(Arrays.toString(ar.toArray()));
        ar.forEach(integer -> System.out.printf("%d, ",integer));

//       2. Итерация всех элементов списка цветов и добавления к каждому символа '!'.
        ArrayList arList = readFile("colors.txt");
        System.out.println("\n\nTask 2.");
        arList.forEach(str -> System.out.printf("%s, ",str));
        System.out.println();
        arList.forEach(str2 -> System.out.printf("%s, ",str2+"!"));

//        3. Вставить элемент в список в первой позиции.
        System.out.println("\n\nTask 3.");
        arList.add(0, "insert first");
        arList.forEach(str -> System.out.printf("%s, ",str));


//        4. Извлечь элемент (по указанному индексу) из заданного списка.
        System.out.println("\n\nTask 4.");
        System.out.println(arList.get(1));

//        5. Обновить определенный элемент списка по заданному индексу.
        System.out.println("\n\nTask 5.");
        arList.set(3, "new color");
        arList.forEach(str -> System.out.printf("%s, ",str));

//        6. Удалить третий элемент из списка.
        System.out.println("\n\nTask 6.");
        arList.remove(3);
        arList.forEach(str -> System.out.printf("%s, ",str));


//       7. Поиска элемента в списке по строке.
        System.out.println("\n\nTask 7.");
        System.out.println(arList.indexOf("Кожа буйвола"));

//        8. Создать новый список и добавить в него несколько елементов первого списка.
        System.out.println("\n\nTask 8.");
        ArrayList<String> ar2 = new ArrayList<>();
        ar2.add("Белый");
        ar2.add("Черный");
        ar2.add("Серый");
        ar2.add(arList.get(3).toString());
        ar2.add(arList.get(6).toString());
        ar2.add(arList.get(arList.size()-1).toString());
        System.out.println(Arrays.toString(ar2.toArray()));


//        9. Удалить из первого списка все элементы отсутствующие во втором списке.
        System.out.println("\n\nTask 9.");
        arList.retainAll(ar2);
        System.out.println(Arrays.toString(arList.toArray()));

//        10. *Сортировка списка.

        Comparator<String>  Compr = new Comparator<String>() {
            @Override
            public int compare(String str, String t1) {
                return str.toLowerCase().compareTo(t1.toLowerCase());
            }
        };

        System.out.println("\n\nTask 10.");
        ArrayList arList2 = readFile("colors.txt");
        arList2.forEach(str -> System.out.printf("%s, ", str ));
        arList2.sort(Compr);
        System.out.println();
        arList2.forEach(str -> System.out.printf("%s, ", str ));


//        11. *Сравнить время работы тысячи повторений пункта 3 для ArrayList и LinkedList.
        System.out.println("\n\nTask 11.");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10001; i++)
        {
            ar2.add(0, "insert");
        }
        long end = System.currentTimeMillis();
        long t1= end-start;

        LinkedList<String> linkString = new LinkedList<>();
        linkString.add(0,"insert");

        start = System.currentTimeMillis();
        for (int i = 0; i < 10001; i++)
        {
            linkString.add(0, "insert");
        }
        end = System.currentTimeMillis();
        long t2= end-start;
        System.out.printf("время добавления в arraylist - %d, в связанный linkString - %d", t1,t2);


    }








    private static ArrayList readFile(String filename) throws Exception
    {
        ArrayList<String> ar= new ArrayList<>();

        FileReader data = new FileReader(filename);
        File file = new File(filename);
        BufferedReader br = new BufferedReader(data);
        String line = br.readLine();
        while (line != null)
        {
            ar.add(line);
            line = br.readLine();
        }
//        data.close();
        br.close();
        return ar;
    }


}