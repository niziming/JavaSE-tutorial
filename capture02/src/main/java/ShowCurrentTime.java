/*
 * 程序清单2-7计算时分秒System.currentTimeMillis()
 */
public class ShowCurrentTime {
	public static void main(String[] args) {
		//1970.1.1 00:00:00到当前为止的毫秒数
		long totalMilliseconds = System.currentTimeMillis();

		//总秒数
		long totalSeconds = totalMilliseconds / 1000;
		//当前秒
		long currentSecond = totalSeconds % 60;

		//总分数
		long totalMinutes = totalSeconds / 60;
		//当前分
		long currentMinute = totalMinutes % 60;

		//总时数
		long totalHours = totalMinutes / 60;
		//当前时 中国属于东八区所以加上8
		long currentHour = totalHours % 24 + 8;

		System.out.println("当前时间为 " + currentHour + ":" + currentMinute + ":" + currentSecond);

	}
}
