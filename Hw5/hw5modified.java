import java.util.*;
public class hw5modified {
    // Eliminate magic numbers with named constants
    private static final int THRESHOLD_BIG = 10;
    private static final int THRESHOLD_MED = 5;
    private static final int DEFAULT_MULTIPLIER = 2;
    private static final int DEFAULT_ADDEND = 3;
    private static final String LABEL_BIG = "Big";
    private static final String LABEL_MED = "Medium";
    private static final String LABEL_SMALL = "Small";
    private static final String LABEL_EVEN = "Even";
    private static final String LABEL_ODD = "Odd";

    // Constants for strings used in length calculation
    private static final String A = "A";
    private static final String B = "B";
    private static final String X = "X";
    private static final String Y = "Y";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number:");
        int n = s.nextInt();
        // Variable x is now a local variable
        int x = 0;
        //Simplify parameter list
        int adjustmentAB = (A + B).length();

         if (n > THRESHOLD_BIG) {
             //Call specific method and uses named constant
             x = MultiplyHandler(LABEL_BIG, n, DEFAULT_MULTIPLIER, adjustmentAB);
         }
         else if (n > THRESHOLD_MED) {
             x = AddHandler(LABEL_MED, n, DEFAULT_ADDEND, adjustmentAB);
         }
         else {
             x = AddHandler(LABEL_SMALL, n, DEFAULT_ADDEND, adjustmentAB);
        }

        int adjustmentXY = (P1_XY + P2_XY).length();
         if (n % 2 == 0) {
             x = MultiplyHandler(LABEL_EVEN, n, DEFAULT_MULTIPLIER, adjustmentXY);
        } else {
             x = AddHandler(LABEL_ODD, n, DEFAULT_ADDEND, adjustmentXY);
        }

        System.out.println("Final result: " + x);
    }

    //Helper method specifically for mutliplication logic and returns value back to x
    public static int MultiplyHandler(String label, int num, int multiplier, int adjustment) {
        System.out.println(label + " number!");
        int result = (num * multiplier) + adjustment;
        System.out.println("Intermediate result: " + result);
        return result;
    }

    //Helper method specifically for addition logic and returns value back to x
    public static int AddHandler(String label, int num, int addend, int adjustment) {
        System.out.println(label + " number!");
        int result = (num + addend) + adjustment;
        System.out.println("Intermediate result: " + result);
        return result;
    }
}
