package kwon.graph;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

/**
 * Created by nhnent on 22/12/2016.
 */
public class Graph {

    public static final Map<String, List<String>> initGraph() {

        Map<String, List<String>> graph = new HashMap<String, List<String>>();

        graph.put("s", new LinkedList<String>());
        graph.put("t", new LinkedList<String>());
        graph.put("y", new LinkedList<String>());
        graph.put("x", new LinkedList<String>());
        graph.put("z", new LinkedList<String>());
        graph.put("a", new LinkedList<String>());
        graph.put("b", new LinkedList<String>());

        {
            List<String> neighbors = graph.get("s");
            neighbors.add("b");
            neighbors.add("t");
            neighbors.add("z");
            neighbors.add("x");
        }

        {
            List<String> neighbors = graph.get("t");
            neighbors.add("s");
        }

        {
            List<String> neighbors = graph.get("y");
            neighbors.add("x");
            neighbors.add("a");
        }

        {
            List<String> neighbors = graph.get("x");
            neighbors.add("s");
            neighbors.add("a");
            neighbors.add("y");
        }

        {
            List<String> neighbors = graph.get("z");
            neighbors.add("a");
            neighbors.add("s");
        }

        {
            List<String> neighbors = graph.get("a");
            neighbors.add("z");
            neighbors.add("x");
            neighbors.add("y");
        }

        {
            List<String> neighbors = graph.get("b");
            neighbors.add("s");
        }


        return graph;
    }


    public static void bfs() {
        //initialization
        Map<String, List<String>> graph = initGraph();
        Queue<String> queue = new LinkedList<String>();

        Map<String, Boolean> visited = new HashMap<String, Boolean>();

        for(String key : graph.keySet()) {
            visited.put(key, false);
        }

        queue.add("s");

        while(queue.isEmpty() == false) {
            String current = queue.poll();

            if (visited.get(current) == true)
                continue;

            visited.put(current, true);
            System.out.println(current);

            List<String> neighbors = graph.get(current);

            for(String neighbor : neighbors) {
                if (visited.get(neighbor) == true)
                    continue;

                queue.add(neighbor);
            }
        }
    }

    public static void dfs() {
        Map<String, List<String>> graph = initGraph();
        Map<String, Boolean> visited = new HashMap<String, Boolean>();

        for(String key : graph.keySet()) {
            visited.put(key, false);
        }

        Stack<String> stack = new Stack<String>();

        stack.push("s");

        while(stack.isEmpty() == false) {
            String current = stack.pop();

            if (visited.get(current) == true)
                continue;

            System.out.println(current);

            visited.put(current, true);

            List<String> neighbors = graph.get(current);

            for(String neighbor : neighbors) {
                if (visited.get(neighbor) == true)
                    continue;

                stack.add(neighbor);
            }
        }

    }

    public static void main(String[] args) {
        bfs();
        System.out.println("-------------------------------");
        dfs();
    }


}
