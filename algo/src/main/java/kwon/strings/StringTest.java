package kwon.strings;

import com.sun.org.apache.xml.internal.utils.StringComparable;

import java.util.*;

/**
 * Created by nhnent on 15/01/2017.
 */
public class StringTest {


    public void treeTest() {

    }

    public void test() {
        String s = "This is Kwon Kwan OHBUM a a is b";

        String[] result = s.split(" ");

        for(String elem : result) {
            //System.out.println(elem);
        }

        Collections.sort(Arrays.asList(result), new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println("______________");

        for(String elem : result) {
            //System.out.println(elem);
        }

        TreeMap<String, Integer> tm = new TreeMap<String, Integer>();

        for(String elem : result) {
            if(tm.containsKey(elem)) {
                int count = tm.get(elem);
                tm.put(elem, count + 1);
            } else {
                tm.put(elem, 1);
            }
        }

        Map<Integer, List<String>> sorted = new HashMap<Integer, List<String>>();

        for(Map.Entry<String, Integer> entry : tm.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            //System.out.println(String.format("%s : %d", entry.getKey(), entry.getValue()));

            List<String> list;

            if (sorted.containsKey(value) == false) {
                list = new LinkedList<String>();
                sorted.put(value, list);
            } else {
                list = sorted.get(value);
            }

            list.add(key);
        }

        for(Map.Entry<Integer, List<String>> entry : sorted.entrySet()) {
            Integer key = entry.getKey();
            List<String> values = entry.getValue();

            StringBuilder sb = new StringBuilder();
            for(String elem : values) {
                if (sb.length() == 0) {
                    sb.append(elem);
                } else {
                    sb.append(" " + elem);
                }
            }

            System.out.println(String.format("%d : %s", key, sb.toString()));
        }
    }

    public void test2() {
        String input = "ABCDEFGHIJKLMNOPQRSTUVXYZ";

        System.out.println(input.length());

        boolean[] list = new boolean[256];

        for(int i=0; i <input.length(); i++) {
            int index = input.charAt(i) - 'A';

            if (list[index] == true) {
                System.out.println("Duplicated character");
                return;
            }
            list[index] = true;
        }

        System.out.println("Unique character set");
    }

    public void convert() {
        String str = "This is a Kwon";

        int count = 0;
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ' ')
                count++;
        }

        char[] newBuffer = new char[str.length() + count * 2];

        for(int i=str.length() - 1, j=newBuffer.length - 1; i >= 0; i--) {
            char ch = str.charAt(i);

            if (ch != ' ') {
                newBuffer[j--] = ch;
            } else {
                newBuffer[j--] = '0';
                newBuffer[j--] = '2';
                newBuffer[j--] = '%';
            }
        }
        String newStr = String.copyValueOf(newBuffer);

        System.out.println(newStr);
    }

}
