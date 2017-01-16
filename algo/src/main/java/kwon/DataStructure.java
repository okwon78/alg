package kwon;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by nhnent on 01/11/2016.
 */
public class DataStructure {

    static String def = "1, 2, 3, 4";

    public static void main(String[] args) {
        String[] tokens = def.split(",");

        for(String str : tokens){
            System.out.println(Integer.parseInt(str.trim()));
        }

        System.out.println("---------------------");

        testStack();
        testQueue();
        //testConcurrentMap();
        //testHashMap();
    }

    public static void testStack() {
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0; i<10; i++) {
            stack.push(i);
        }

        for(int i=0; i<10; i++) {
            System.out.println(stack.pop());
        }
    }

    private static String[] names = { "Romi", "Kwon", "Joon", "Jo", "Chan"};

    private static void testConcurrentMap(){
        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<Integer, String>();

        concurrentHashMap.put(1, "AA");
        System.out.println(concurrentHashMap.get(1));
    }

    public static void testHashMap() {
        System.out.println("testHashMap");

        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

        for(int i=0; i<names.length; i++) {
            hashMap.put(i, names[i]);
        }

        for (int i=0; i<hashMap.size(); i++){
            hashMap.put(i, names[i]);
        }

        Set<Integer> keys = hashMap.keySet();

        for(int key: keys){
            System.out.println(key);
        }
    }

    public static void testQueue(){
        System.out.println("testQueue");

        Queue<Integer> queue = new LinkedList<Integer>();

        for(int i=0; i<10; i++) {
            queue.add(i);
        }

        while(queue.size() > 0) {
            System.out.println(queue.poll());
        }
    }
}
