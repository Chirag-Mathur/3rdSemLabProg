package week8oops;

public class Average {

    void averag(String arr[]) throws NumberFormatException, NullPointerException {
        try {
            double sum = 0.0;
            for (int i = 0; i < arr.length; i++) {
                sum += Double.parseDouble(arr[i]);

            }
            System.out.println(sum / arr.length);

        } catch (NumberFormatException e) {
            System.out.println("Recaught: " + e);
        } catch (NullPointerException e) {
            System.out.println("Recaught: " + e);
        }

    }

    public static void main(String args[]) {

        String arr[] = { "23.5", "55.0", "17.3" };
        String arr2[] = { "23.5", null, "17.3" };
        String arr3[] = { "23.5", "55.0.3", "17.3" };
        Average obj = new Average();
        obj.averag(arr);
        obj.averag(arr2);
        obj.averag(arr3);

    }

}
