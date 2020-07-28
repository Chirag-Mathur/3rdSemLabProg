package OOPs_CS261.Week1;

import java.util.Scanner;

//Chirag Mathur
//201951050
class Prime {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int l;

        System.out.println("Enter the number");
        l = sc.nextInt();//taking input
        
        int flag=0;
        for(int i=2; i<l; i++){
            if(l%i==0){
                flag=1;
                break;
            }

        }
        if(flag==1){
            System.out.println("Not a prime number");//printing output
        }else{
            System.out.println("Prime number");//printing output

        }
        

        sc.close();

    }
}
