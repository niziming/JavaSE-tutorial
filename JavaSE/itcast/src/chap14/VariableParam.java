package chap14;

public class VariableParam {
    public static void main(String[] args) {
        variableTest(1,1,2,5,4,4,2);
        variableTest1(new int[]{1,3,5,4,8});
    }
    public static void variableTest(int... s){
        int sun = 0;
        for (int s1 : s) {
            sun += s1;
        }
        System.out.println(sun);
    }
    public static void variableTest1(int[] s){
        int sun = 0;
        for (int s1 : s) {
            sun += s1;
        }
        System.out.println(sun);
    }
}
