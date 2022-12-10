import java.util.*;

public class Main {
    public static void main(String[] args) {

//       1. Создать словарь HashMap. Обобщение <Integer, String>.
//       2. Заполнить тремя ключами (индекс, цвет), добавить ключь, если не было!)
//       3. Изменить значения дописав восклицательные знаки. *Создать TreeMap, заполнить аналогично.
//       4. *Увеличить количество элементов таблиц до 1000 случайными ключами и общей строкой.
//       5. **Сравнить время прямого и случайного перебора тысячи элементов словарей.


//        1. & 2.
        System.out.println("\n\n -----------------Task 1. & 2.---------------------");
        Map<Integer, String>  hashMap = new HashMap<>();
        Map<Integer, String> treeMap = new TreeMap<>();
        
        treeMap.put(1,"-red");
        hashMap.put(2, "green");
        treeMap.put(2, "-green");
        hashMap.put(3, "blue");
        treeMap.put(3, "-blue");
        hashMap.replace(3, "magenta");
        treeMap.replace(3, "-magenta");
        System.out.println(hashMap);
        System.out.println(treeMap);
        hashMap.replace(4, "magenta");
        treeMap.replace(4, "magenta");
        System.out.println(hashMap);
        System.out.println(treeMap);

//        3.
        System.out.println("\n\n -----------------Task 3.---------------------");
        hashMap.compute(3, (k, v) ->  v + "!");
        treeMap.compute(3, (k, v) ->  v + "$");
        System.out.println(hashMap);
        System.out.println(treeMap);
        hashMap.forEach((k, v) -> hashMap.compute(k, (k1, v1) ->  v1 + "*"));
        treeMap.forEach((k, v) -> treeMap.compute(k, (k1, v1) ->  k1 + "++"));
        System.out.println(hashMap);
        System.out.println(treeMap);

//    4. *Увеличить количество элементов таблиц до 1000 случайными ключами и общей строкой.
        System.out.println("\n\n -----------------Task 4.---------------------");
        int count = 40000;
        int start = hashMap.size()+1;
        LinkedList<Integer> lList = rndList(start, count);
//        System.out.println(lList);

        for (int i = 0; i < count-start+1 ; i++) {
            treeMap.put(lList.get(i), " "+i+"+treeMap");
            hashMap.put(lList.get(i), " "+i+"+hashMap");
        }
//        System.out.println(hashMap);
//        System.out.println(treeMap);


//        5.  **Сравнить время прямого и случайного перебора тысячи элементов словарей.
        System.out.println("\n\n -----------------Task 5.---------------------");

        long startTimer, endTimer;

        startTimer = System.currentTimeMillis();
        Random rnd = new Random();
        for (int i = 0; i < count; i++)
        {
            int n = rnd.nextInt(count+1);
            hashMap.put(n, "rnd");
        }
        endTimer = System.currentTimeMillis();
        System.out.println("случайный доступ к hashMap : " +  (endTimer-startTimer));

        startTimer = System.currentTimeMillis();
        for (int i = 0; i < count; i++)
        {
            int n = rnd.nextInt(count+1);
            treeMap.put(n, "rnd");
        }
        endTimer = System.currentTimeMillis();
        System.out.println("случайный доступ к treeMap : " +  (endTimer-startTimer));

//        System.out.println(hashMap);
//        System.out.println(treeMap);

        startTimer = System.currentTimeMillis();
        hashMap.forEach((k,v) -> hashMap.replace(k, "---"));
        endTimer = System.currentTimeMillis();
        System.out.println("последовательный  доступ к hashMap : " +  (endTimer-startTimer));

        startTimer = System.currentTimeMillis();
        treeMap.forEach((k,v) -> treeMap.replace(k, "---"));
        endTimer = System.currentTimeMillis();
        System.out.println("последовательный  доступ к treeMap : " +  (endTimer-startTimer));
//        System.out.println(hashMap);
//        System.out.println(treeMap);

    }


    static private LinkedList<Integer> rndList(int start , int end) {
        Random rnd = new Random();
        LinkedList<Integer> lList = new LinkedList<>();
        for (int j = start; j <= end; j++) lList.add(j);
        for (int i = 0; i < end-start; i++)
        {
            int n = rnd.nextInt(0, end-start+1);
            int temp = lList.get(i);
            lList.set(i,  lList.get(n));
            lList.set(n, temp);
        }
        return lList;
    }


}