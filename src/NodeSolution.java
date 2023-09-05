import java.util.ArrayList;
import java.util.List;

public class NodeSolution {
    private final List<Node> nodes;
    public NodeSolution(int number) {
        if (number < 1) throw new IllegalArgumentException("Player number must be greater than 0");
        else {
            nodes = new ArrayList<>(number);
            for (int i = 0; i < number; i++) {
                nodes.add(new Node());
            }
            linkNodes();
        }
    }
    private void linkNodes() {
        int nodesSize = nodes.size();
        for (int i = 0; i < nodesSize; i++) {
            nodes.get(i).linkToFront(nodes.get((i + 1) % nodesSize));
        }
    }
    public int start() {
        return nodes.get(0).fire();
    }
}
class Node {
    private static int ORDER_COUNTER = 1;
    private final int order;
    private Node back;
    private Node front;
    public Node() {
        order = ORDER_COUNTER++;
    }
    public void linkToFront(Node node) {
        setFront(node);
        node.setBack(this);
    }
    public void die() {
        front.setBack(back);
        back.setFront(front);
    }
    public int fire() {
        if (front == back) {
            return order;
        }
        else {
            front.die();
            return front.fire();
        }
    }
    public void setBack(Node back) {
        this.back = back;
    }
    public void setFront(Node front) {
        this.front = front;
    }
}
