import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * ClosestPair finds the Closest Pairs of an given array
 *
 * @author Lakindu Oshadha (lakinduoshadha98@gmail.com)
 */
public class ClosestPair {

    /**
     * Gives a brief introduction to user
     * Takes the array and the size of the array which is to be sorted from the user.
     *
     * @return inputArray
     * @throws IOException
     */
    static double[] getInputArray() throws IOException{
        // Giving a brief Introduction to the user
        System.out.print("This program closest pair(s) in given Array.\n" + "n - " +
                "No. of integers in input Array.\n" + "\nEnter input arr size(n): ");

        // Getting input size from user
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        // Getting the unsorted arr from the user
        double[] arr = new double[n];
        int inputSize = 0;
        String input;
        do {
            System.out.print("Enter " + n + " integers, separated using space (n1 n2 n3 ...): ");
            input = reader.readLine();
            inputSize = input.split(" ").length;
        } while (inputSize != n);

        String[] numbers = input.split(" ");
        for (int j = 0; j < n; j++) {
            arr[j] = Double.parseDouble(numbers[j]);
        }

        return arr;
    }

    /**
     * Finds & Prints Closest pairs in a given arr.
     *
     * @param arr Input Arr
     */
    static void printClosestPairs(double[] arr) {

        int n = arr.length;
        Arrays.sort(arr);
        double minGap = Math.abs(arr[0] - arr[1]);
        ArrayList<Double> tempArr = new ArrayList<>();

        // Finding the closest pairs and adding them to tempArr
        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(arr[i + 1] - arr[i]) <= minGap) {
                if (Math.abs(arr[i + 1] - arr[i]) < minGap) {
                    tempArr.clear();
                    minGap = Math.abs(arr[i + 1] - arr[i]);
                }
                tempArr.add(arr[i]);
                tempArr.add(arr[i + 1]);

            }
        }

        // Printing tempArr
        System.out.print("Closest Pairs : ");
        for (int i = 0; i < tempArr.size() - 1; i = i + 2) {
            System.out.print("( " + tempArr.get(i)+ "," + tempArr.get(i + 1) + ") , ");
        }

    }

    /**
     * main
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        double[] arr = getInputArray();     //Getting the array from the user
        printClosestPairs(arr);         //Calling the printClosestPairs method

    }

}
