import java.util.Scanner;
public class Question5{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the 2 numbers:");
        int in1 =in.nextInt();
        int in2 =in.nextInt();
		System.out.println("Signed integers: " + in1 + ", " + in2);
		int compare_Signed_num = Integer.compare(in1, in2);
		System.out.println("Result of comparing signed numbers: " + compare_Signed_num);
		int compare_Unsigned_num = Integer.compareUnsigned(in1, in2);
        System.out.println("Result of comparing unsigned numbers: " + compare_Unsigned_num);
    }
}
