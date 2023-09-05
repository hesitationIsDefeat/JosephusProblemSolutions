import java.util.ArrayList;
import java.util.List;

public class JosephusGame {
    private final List<Node> nodes;
    public JosephusGame(int number) {
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
