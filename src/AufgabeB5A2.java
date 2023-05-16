import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AufgabeB5A2 {

    public int[] data;

    public static int[] readInput() throws NumberFormatException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> dataList = new ArrayList<>();
        while (scanner.hasNextInt()) {
            dataList.add(scanner.nextInt());
        }
        if (dataList.size() == 0) {
            throw new NumberFormatException();
        }
        int[] data = new int[dataList.size()];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i);
        }
        return data;
    }

    public AufgabeB5A2(int[] data) {
        this.data = data;
    }

    public int[] countingSort() {
        AufgabeB5A1 temp = new AufgabeB5A1(data);
        int[] freq = temp.count();
        int min = temp.getMin();
        int count = 0;

        for (int i = freq.length - 1; i >= 0; i--) {
            for (int j = 0; j < freq[i]; j++) {
                data[count] = i + min;
                count++;
            }
        }
        return freq;
    }

    public static void main(String[] args) {
        int[] data = AufgabeB5A2.readInput();
        AufgabeB5A2 test = new AufgabeB5A2(data);

        System.out.println("Before sorting: " + Arrays.toString(data));
        System.out.println("Frequencies: " + Arrays.toString(test.countingSort()));
        System.out.println("After sorting" + Arrays.toString(test.data));
    }
}