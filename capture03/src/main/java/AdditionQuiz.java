import java.util.Scanner;

public class AdditionQuiz {
	public static void main(String[] args) {
		int num1 = (int)System.currentTimeMillis() % 10;
		int num2 = (int)System.currentTimeMillis() / 7 % 10;

		//输入
		Scanner input = new Scanner(System.in);

		System.out.println("数:" + num1 + " 数:" + num2 + "的和为多少?");

		int answer = input.nextInt();

		System.out.println( num1 + "+" + num2 + "=" + answer + "的答案为:" + (num1 + num2 == answer));

	}
}
