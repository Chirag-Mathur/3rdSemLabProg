package OOPs_CS261.Week1;

import java.util.Scanner;

//Chirag Mathur
//201951050
class Palindrome {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String l;

        System.out.println("Enter the number");
        l = sc.nextLine();
        int flag = 0;
        for (int i = 0; i <= l.length() / 2; i++) {
            if (l.charAt(i) == l.charAt(l.length() - 1 - i)) // Checking logic for palindrome
            {

                continue;
            } else {
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            System.out.println("Not a palindrome");
        } else {
            System.out.println("Palindrome");
        }

        sc.close();

    }
}
