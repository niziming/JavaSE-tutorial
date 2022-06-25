package capture03;

import java.util.Scanner;

public class SubtractionQuiz {
	public static void main(String[] args) {
		int num1 = (int)(Math.random()*10);
		int num2 = (int)(Math.random()*10);

		if (num1 < num2){
			num1 = num1 + num2;
			num2 = num1 - num2;
			num1 = num1 - num2;
		}

		System.out.println(num1 + "-" + num2 + "=?");
		Scanner input = new Scanner(System.in);

		System.out.println("请输入答案:");
		int answer = input.nextInt();

		if (answer == (num1 - num2))
			System.out.println("答案正确");
		else
			System.out.println("答案不正确,正确答案为: " + (num1-num2));
	}
}
