public class Node {
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
