public class BinarySolution {
    public static int getAnswer(int num) {
        String binary = Integer.toBinaryString(num);
        String newBinary = binary.substring(1) + binary.charAt(0);
        return Integer.parseInt(newBinary, 2);
    }
}
