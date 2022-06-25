package c.尚硅谷_宋红康_第3章_数组.sort.b对象数组版_考虑稳定性;

public class DataWrap implements Comparable<DataWrap>{
	int data;
	String flag;
	public DataWrap(int data,String flag){
		this.data = data;
		this.flag = flag;
	}
	@Override
	public String toString(){
		return data + flag;
	}
	//根据data实例变量来决定两个dataWrap的大小
	@Override
	public int compareTo(DataWrap dw) {
		return this.data > dw.data? 1 : (this.data == dw.data? 0 : -1);
	}
	
}
