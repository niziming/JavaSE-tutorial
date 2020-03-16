import java.util.Scanner;

public class SimpleIfDemo {
	private static final double PI = 3.1415926;

	static double cycleArea() {
		Scanner input = new Scanner(System.in);

		System.out.println("请输入圆的半径:");
		double radius = input.nextDouble();
		if (radius <= 0){
			System.out.println("圆的半径不能小于或等于0,请重新输入!");
			cycleArea();
		}
		return PI * radius * radius;
	}

	public static void main(String[] args) {
		double area = cycleArea();
		if (area > 100){
			System.out.println("圆的面积为大于100");
		}else {
			System.out.println("圆的面积不大于100");
		}
		System.out.println("圆的面积为: " + area);
	}
}
