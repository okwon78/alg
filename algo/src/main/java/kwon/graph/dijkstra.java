package kwon.graph;

import java.util.*;

/**
 * Created by nhnent on 28/12/2016.
 */
public class dijkstra {

    private final Map<String, Map<String, Integer>> initGraph() {

        Map<String, Map<String, Integer>> graph = new HashMap<String, Map<String, Integer>>();

        graph.put("A", new HashMap<String, Integer>());
        graph.put("B", new HashMap<String, Integer>());
        graph.put("C", new HashMap<String, Integer>());
        graph.put("D", new HashMap<String, Integer>());
        graph.put("E", new HashMap<String, Integer>());
        graph.put("F", new HashMap<String, Integer>());
        graph.put("G", new HashMap<String, Integer>());
        graph.put("H", new HashMap<String, Integer>());

        {
            Map<String, Integer> node = graph.get("A");
            node.put("B", 8);
            node.put("C", 2);
            node.put("D", 5);
        }

        {
            Map<String, Integer> node = graph.get("B");
            node.put("A", 8);
            node.put("D", 2);
            node.put("F", 13);
        }

        {
            Map<String, Integer> node = graph.get("C");
            node.put("A", 2);
            node.put("D", 2);
            node.put("E", 5);
        }

        {
            Map<String, Integer> node = graph.get("D");
            node.put("A", 5);
            node.put("B", 2);
            node.put("C", 2);
            node.put("E", 1);
            node.put("F", 6);
        }

        {
            Map<String, Integer> node = graph.get("E");
            node.put("C", 5);
            node.put("D", 1);
            node.put("G", 1);
        }

        {
            Map<String, Integer> node = graph.get("F");
            node.put("B", 13);
            node.put("D", 6);
            node.put("G", 2);
            node.put("H", 3);
        }

        {
            Map<String, Integer> node = graph.get("G");
            node.put("E", 1);
            node.put("D", 3);
            node.put("F", 2);
            node.put("H", 6);
        }

        {
            Map<String, Integer> node = graph.get("H");
            node.put("F", 3);
            node.put("G", 6);
        }

        return graph;
    }

    private Map<String, Map<String, Integer>> graph = initGraph();

    private PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(graph.size(), new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.weight > o2.weight ? 1 : o1.weight > o2.weight ? -1 : 0;
        }
    });

    private static class Node {
        public String label;
        public int weight;
        public String precedingNode;

        public Node(String label, int weight, String precedingNode) {
            this.label = label;
            this.weight = weight;
            this.precedingNode = precedingNode;
        }
    }

    private static class Elem {
        public String label;
        public int weight = Integer.MAX_VALUE;
        public String precedingNode;
        public boolean visited = false;

        public Elem(String label) {
            this.label = label;
        }
    }

    private Map<String, Elem> board = new HashMap<String, Elem>();

    public void init() {
        Set<String> keys = graph.keySet();

        for(String key : keys) {
            board.put(key, new Elem(key));
        }
    }


    public void make() {

        priorityQueue.add(new Node("A", 0, ""));

        while(priorityQueue.size() > 0) {
            Node current = priorityQueue.poll();
            Elem boardElem = board.get(current.label);

            if (boardElem.visited == true ||
                    boardElem.weight < current.weight) {
                continue;
            }

            boardElem.visited = true;
            boardElem.weight = current.weight;

            Map<String, Integer> neighbors = graph.get(current.label);

            for (Map.Entry<String, Integer> neighbor : neighbors.entrySet()) {
                String label = neighbor.getKey();
                int weight = neighbor.getValue();
                int weightToUpdate = weight + current.weight;

                Elem n = board.get(label);

                if (n.weight > weightToUpdate) {

                    n.weight = weightToUpdate;
                    n.precedingNode = current.label;

                    priorityQueue.add(new Node(n.label, n.weight, current.label));
                }
            }
        }
    }

    public void print() {
        for (Map.Entry<String, Elem> node : board.entrySet()) {
            Elem elem = node.getValue();
            String fmt = String.format("%s : %d : %s", elem.label, elem.weight, elem.precedingNode);
            System.out.println(fmt);
        }
    }
}
