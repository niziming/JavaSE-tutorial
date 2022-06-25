package chap14;
// 1.9 可变参数
public class VariableParams {
    public static void main(String[] args) {
        int i = varParam(10, 20, 30);
        int i1 = varParam(new int[]{10, 20, 30});
        System.out.println(i);
        System.out.println(i1);
    }
    // 可变写法
    public static int varParam(int... arr){
        int sum = 0;
        for (int a : arr){
            sum += a;
        }
        return sum;
    }
}
