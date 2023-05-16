import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AufgabeB5A1 {
    public int[] data;

    public AufgabeB5A1(int[] data) {
        this.data = data;
    }

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

    public int getMin() {
        int min = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        return min;
    }

    public int getMax() {
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }

    public int[] count() {
        int min = getMin();
        int max = getMax();
        int[] count = new int[max - min + 1];
        for (int i = 0; i < data.length; i++) {
            count[data[i] - min]++;
        }
        return count;
    }

    public static void main(String[] args) {
        try {
            AufgabeB5A1 instance = new AufgabeB5A1(readInput());
            System.out.println(Arrays.toString(instance.count()));
        } catch (NumberFormatException e) {
            System.out.println("Eingabe muss nur Ganzzahlen enthalten.");
        }
    }
}
