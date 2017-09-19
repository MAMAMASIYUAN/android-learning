import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CollectionDemo {
    public static void main(String[] args) {
        ListTest();
    }
    // ============= List =========================
    private static void ListTest() {
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王二");

        for (String s : list) {
            System.out.println(s);
        }
    }

    private static void PrintList(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static void PrintListByIterator(List<String> list) {
        Iterator<String> ite=list.iterator();
        //判断下一个元素之后有值
        while(ite.hasNext()) {
            System.out.println(ite.next());
        }
    }

    public static void sortList() {
        List<String> list1 = createList();
        PrintList(list1);
        Collections.sort(list1);

        PrintList(list1);

    }

    private static List<String>  createList() {
        // 另外一种方式
        return Arrays.asList("iPhone", "Ubuntu", "Android", "Mac OS X");
    }
    // ============= List =========================

    // ============= Set =========================
    
    private static void SetTest () {
        Set<String> set = new HashSet<>();
        fillSetData(set);
        PrintSet(set);

        set.add("iPhone");
        set.remove("Android");

        PrintSet(set);
    }
    private static void fillSetData(Set<String> set) {
        set.add("Android");
        set.add("Eclipse IDE");
        set.add("Eclipse RCP");
        boolean b1 = set.add("Git");
        boolean b2 = set.add("Git");
    }

    private static void PrintSet(Set<String> set) {
        for (String s : set) {
            System.out.println(s);
        }
    }
    // ============= Set =========================

    // ============= Queue =========================
    private static void QueueTest () {
        Queue<String> queue = new LinkedList<>();
        offerQueueData(queue);
        pollQueueData(queue);

        queue.offer("iPhone");
        System.out.println(queue.poll());
    }
    private static void offerQueueData(Queue<String> queue) {
        queue.offer("1.Android");
        queue.offer("2.Eclipse IDE");
        queue.offer("3.Eclipse RCP");
        queue.offer("4.Git");
    }

    private static void pollQueueData(Queue<String> queue) {
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
    // ============= Queue =========================

    // ============= Map =========================
    private static void MapTest () {
        Map<String, String> map = new HashMap<>();

        fillMapData(map);

        System.out.println(map.get("Android"));

        PrintMap(map);

        map.put("iPhone", "Created by Apple");
        map.remove("Android");

        PrintMap(map);
    }
    private static void fillMapData(Map<String, String> map) {
        map.put("Android", "Mobile");
        map.put("Eclipse IDE", "Java");
        map.put("Eclipse RCP", "Java");
        map.put("Git", "Version control system");
    }

    private static void PrintMap(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
    // ============= Map =========================

}