package week8oops;

class RangeException extends Exception {
    private double number;

    RangeException(double a) {
        number = a;
    }

    public String toString() {
        return "[" + number + "] is out of range";
    }
}

public class Add {

    void ad(String arr[]) throws NumberFormatException, RangeException {

        double sum = 0.0;
        double n = 0.0;
        for (int i = 0; i < arr.length; i++) {
            n = Double.parseDouble(arr[i]);
            if (n < 0 || n > 1)
                throw new RangeException(n);
            else {
                sum += n;
            }

        }
        System.out.println(sum);

    }

    public static void main(String args[]) {

        String arr[] = { "0.5", "0.1", "0.3" };
        String arr4[] = { "0.5", "0.3", "0.3" };
        String arr2[] = { "0.5", "1.7", "0.3" };
        String arr3[] = { "0.5", "55.0.3", "0.3" };
        Add obj = new Add();
        try {
            obj.ad(arr);

            obj.ad(arr3);
        } catch (NumberFormatException e) {
            System.out.println("Recaught: " + e);
        } catch (RangeException e) {
            System.out.println("Recaught: " + e);
        } finally {
            System.out.println("Thanks for using block A");
        }

        try {
            obj.ad(arr4);
            obj.ad(arr2);

        } catch (NumberFormatException e) {
            System.out.println("Recaught: " + e);
        } catch (RangeException e) {
            System.out.println("Recaught: " + e);
        } finally {
            System.out.println("Thanks for using block B");
        }

    }

}
