class FindConnectedComponentsInDiGraph {


    class Node {
        Node[] adjList;
        int color;
    }

    private HashMap<Integer, ArrayList<Node> hash;


    public static int findConnectedComponents(Node[] nodes) {

        int startColor =0;

        for(Node node: nodes) {
            if (node.color ==0) {
                colorNode(node, ++startColor);
            }
        }

        return this.hash.keySet().size();
    }


    public static void colorNode(Node node, int color) {

        if (node.color == color) {
            return;
        }

        if (node.color ==0 ) {
            node.color = color;
            this.addNode(node, color);
            for (Node node: node.adjList) {
                colorNode(node, color)
            }
        }

        if (node.color != color) {
            node.color = color;
            changeColor(color, node.color);
            for (Node node: node.adjList) {
                colorNode(node, color)
            }
        }
    }


    public static void addNode(Node node, int color) {

        if (this.hash.containsKey(color)) {
            this.hash.get(color).add(node);
        } else {
            this.hash.put(color, new ArrayList().add(node);
        }

    }


    public static void changeColor(int color1, int color2) {

        for (Node node: this.hash.get(color2)) {
            node.color = color1;
            this.hash.get(color1).add(node);
        }

        this.hash.remove(color2);


    }



}
