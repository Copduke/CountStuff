import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AufgabeB5A3 {

    public int[] data;

    public AufgabeB5A3(int[] data) {
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

    public int exactSelect(int k) {
        AufgabeB5A1 temp = new AufgabeB5A1(data);
        int min = temp.getMin();
        int max = temp.getMax();

        boolean[] presence = new boolean[max - min + 1];

        for (int number : this.data) {
            presence[number - min] = true;
        }

        int count = 0;
        int kSmallest = min;

        for (int i = 0; i < presence.length; i++) {
            if (presence[i]) {
                count++;
                if (count == k) {
                    kSmallest = min + i;
                    break;
                }
            }
        }

        return kSmallest;
    }

    public static void main(String[] args) {
        try {
            if (args.length > 1) {
                System.out.println("k muss größer 0 sein!");
            } else {
                AufgabeB5A3 test = new AufgabeB5A3(readInput());
                System.out.println(test.exactSelect(Integer.parseInt(args[0])));
            }
        } catch (NumberFormatException e) {
            System.out.println("Die Eingabe darf nur Ganzzahlen enthalten!");
        }
    }
}
