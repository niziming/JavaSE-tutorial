package capture02;

public class DataTypeConversion {
	public static void main(String[] args) {
		//通过显式转换，浮点数可以被转換为整数。


		//当double 型值被转换为int 型值时，小数部分被截去。强转
		System.out.println((int)1.7);

		//因为1首先被转换为1.0, 然后用2 除1.0 , 显示结果为0.S
		System.out.println((double)1 / 2);

		//显示结果为0, 因为1和2 都是整数，结果也应该是整数。
		System.out.println(1 / 2);
	}
}
