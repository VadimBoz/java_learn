import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class task {
    private static final Map<Integer, Object> mapTreeInt = new TreeMap<>();
    private static final Object SOMETHING = new Object();

    public void methodAdd(int x) {
        mapTreeInt.put(x, SOMETHING);
    }

    public int methodSize() {
        return mapTreeInt.size();
    }

    public String methodRead() {
        return mapTreeInt.keySet().toString();
    }

    public String getSortKeySet() {
        LinkedList<Integer> key = new LinkedList<>();
        mapTreeInt.forEach((k, v) -> key.add(k));
        key.sort(Comparator.reverseOrder());
        return key.toString();
    }


}
