package kwon.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by nhnent on 02/01/2017.
 */
public class bellmanFord {

    private static final Map<String, Map<String, Integer>> graph;

    static {
        graph = initGraph();
    }

    private static Map<String, Map<String, Integer>> initGraph() {

        Map<String, Map<String, Integer>> graph = new HashMap<String, Map<String, Integer>>();

        graph.put("s", new HashMap<String, Integer>());
        graph.put("t", new HashMap<String, Integer>());
        graph.put("y", new HashMap<String, Integer>());
        graph.put("x", new HashMap<String, Integer>());
        graph.put("z", new HashMap<String, Integer>());

        {
            Map<String, Integer> node = graph.get("s");
            node.put("t", 6);
            node.put("y", 7);
        }

        {
            Map<String, Integer> node = graph.get("t");
            node.put("x", 5);
            node.put("z", -4);
            node.put("y", 8);
        }

        {
            Map<String, Integer> node = graph.get("y");
            node.put("x", -3);
            node.put("z", 9);
        }

        {
            Map<String, Integer> node = graph.get("x");
            node.put("t", -2);
        }

        {
            Map<String, Integer> node = graph.get("z");
            node.put("x", 7);
            node.put("s", 2);
        }



        return graph;
    }

    private static class Node{
        public final String label;
        public int weight = Integer.MAX_VALUE;
        public String precedingNode = "";

        public Node(String label) {
            this.label = label;
        }
    }

    private final Map<String, Node> board = new HashMap<String, Node>();

    public bellmanFord() {
        Set<String> keys =  graph.keySet();

        for (String key : keys) {
            board.put(key, new Node(key));
        }

        Node first = board.get("s");

        first.weight = 0;
    }

    public void run() {

        boolean modified = false;

        for (int i=0; i<graph.size()-1; i++) {

            modified = false;

            for(Map.Entry<String, Map<String, Integer>> entry : graph.entrySet()) {
                String label = entry.getKey();
                Map<String, Integer> edges = entry.getValue();

                Node currentNode = board.get(label);

                if (currentNode.weight == Integer.MAX_VALUE)
                    continue;

                for (Map.Entry<String, Integer> edge : edges.entrySet()) {
                    Node neighbor = board.get(edge.getKey());
                    int weightToUpdate = currentNode.weight + edge.getValue();
                    if (neighbor.weight > weightToUpdate) {
                        neighbor.weight = weightToUpdate;
                        neighbor.precedingNode = currentNode.label;

                        modified = true;
                    }
                }
            }

            if (modified == false) {
                System.out.println("Complete " + i + " iterations");
                break;
            }


        }
    }

    public void print() {
        for (Node node : board.values()) {
            System.out.println(String.format("%s %d %s", node.label, node.weight, node.precedingNode));
        }
    }
}
