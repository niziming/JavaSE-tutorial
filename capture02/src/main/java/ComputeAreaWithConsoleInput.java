import java.util.Scanner;

public class ComputeAreaWithConsoleInput {
	public static void main(String[] args) {
		//PI的值
		final double PI = 3.1415926;
		//创建Scanner类
		Scanner input = new Scanner(System.in);

		//读取键盘输入
		System.out.println("请输入圆的半径");
		double radius = input.nextDouble();

		//计算面积
		System.out.println("圆的半径为: " + radius + " | 圆的面积为: " + radius * radius * PI);
	}
}
