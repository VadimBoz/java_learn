import java.util.Random;

public class Main {
    public static void main(String[] args) {
        task mySet = new task();


        for (int i = 0; i < 20; i++) {
            int a = new Random().nextInt(50);
            mySet.methodAdd(a);
        }
        
        System.out.println(mySet.methodRead());
        System.out.println(mySet.getSortKeySet());

    }
}