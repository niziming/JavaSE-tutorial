import java.util.Scanner;

public class ComputeAverage {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("请输入第1个数的值:");
		double num1 = input.nextDouble();
		System.out.println("请输入第2个数的值:");
		double num2 = input.nextDouble();
		System.out.println("请输入第3个数的值:");
		double num3 = input.nextDouble();
		System.out.println("----------------------------------------------");

		System.out.println("第1个数的值为: " + num1);
		System.out.println("第2个数的值为: " + num2);
		System.out.println("第3个数的值为: " + num3);

		System.out.println("----------------------------------------------");
		System.out.println("这三个数的平均值为: " + (num1 + num2 + num3) / 3);
	}
}
