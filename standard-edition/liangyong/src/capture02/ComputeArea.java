package capture02;

public class ComputeArea {
	public static void main(String[] args) {
		double PI = 3.1415926;
		//1 读取半径
		double radius = 3;
		//2 计算面积
		double area = radius * radius * PI;
		//3 显示面积
		System.out.println("半径为 " + radius + " 的圆的面积为: " + area);
	}
}
