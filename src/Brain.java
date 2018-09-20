import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Brain {

    private static final int AMOUNT_OF_NUMS = 13;

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("src/num.txt"));
        int i;
        StringBuilder nums = new StringBuilder();
        long largestProduct = 0l;
        String maxNums = "";
        while ((i = in.read()) != -1) {
            i = Character.getNumericValue(i);
            if (i == -1)
                continue;
            if (nums.length() < AMOUNT_OF_NUMS) {
                if (i == 0) {
                    nums = new StringBuilder();
                    continue;
                } else {
                    nums.append(i);
                }
            }
            if (nums.length() == AMOUNT_OF_NUMS) {
                long product = 1;
                for (int j = 0; j < nums.length(); j++) {
                    product *= (long) Character.getNumericValue(nums.charAt(j));
                }
                if (largestProduct < product) {
                    largestProduct = product;
                    maxNums = nums.toString();
                }
                nums.deleteCharAt(0);
            }
        }
        System.out.println(largestProduct);
    }

}
