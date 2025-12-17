import java.util.*;
public class hw5 {

        public static int x = 0;
	    public static void main(String[] args) {
	        Scanner s = new Scanner(System.in);
	        System.out.println("Enter number:");
	        int n = s.nextInt();


	         if (n > 10) {

	            handleNumber("Big", n, true, 2, "A", "B");

	         } else if (n > 5) {
	            handleNumber("Medium", n, false, 3, "A", "B");



	         } else {
	            handleNumber("Small", n, false, 3, "A", "B");

	       }


	        if (n % 2 == 0) {
	            handleNumber("Even", n, true, 2, "X", "Y");
	        } else {
	            handleNumber("Odd", n, false, 3, "X", "Y");
	        }

	        System.out.println("Final result: " + x);
	    }


	    public static void handleNumber(String label, int num, boolean flag, int mult, String p1, String p2) {
	        System.out.println(label + " number!");
	        if (flag) x = num * mult;
	        else x = num + mult;
	        x += (p1 + p2).length();
	        System.out.println("Intermediate result: " + x);
	    }
	}



