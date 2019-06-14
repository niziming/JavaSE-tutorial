/*
 * 程序清单2-7计算时分秒System.currentTimeMillis()
 */
public class ShowCurrentTime {
	public static void main(String[] args) {
		//1970.1.1 00:00:00到当前为止的毫秒数
		long totalMilliseconds = System.currentTimeMillis();
		System.out.println("总共毫秒:" + totalMilliseconds);
		//总共秒数
		long totalSeconds= totalMilliseconds / 1000;
		System.out.println("总共秒数:" + totalSeconds);
		//总共分数
		long totalMinutes = totalSeconds / 60;
		System.out.println("总共分数:" + totalMinutes);
		//总共时数
		long totalHours = totalMinutes / 60;
		System.out.println("总共时数:" + totalHours);

		//----------------------------------------------

		//当前秒
		long currentSecond = totalSeconds % 60;
		System.out.println(currentSecond);
		//当前分
		long currentMinute = totalMinutes % 60;
		System.out.println(currentMinute);
		//当前时
		long currentHour= totalMinutes % 24;
		System.out.println(currentHour);

	}
}
