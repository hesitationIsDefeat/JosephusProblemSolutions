import java.util.Arrays;

public class ArraySolution {
    public static int getAnswer(int size) {
        int[] circle = new int[size];
        Arrays.fill(circle, 1);
        return rec(circle, 0) + 1;
    }
    private static int rec(int[] circle, int index) {
        if (Arrays.stream(circle).sum() == 1) return index;
        circle[findNextOne(circle, index)] = 0;
        return rec(circle, findNextOne(circle, index));
    }
    private static int findNextOne(int[] circle, int index) {
        int length = circle.length;
        int searchIndex = (index + 1) % length;
        while (circle[searchIndex] != 1) {
            searchIndex = (searchIndex + 1) % length;
        }
        return searchIndex;
    }
}
