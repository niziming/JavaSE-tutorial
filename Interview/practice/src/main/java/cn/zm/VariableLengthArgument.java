package cn.zm;

public class VariableLengthArgument {
  public static void main(String[] args) {
    // printVariableArgument("a", "a", "a", "a", "a" );
    // printVariableArgument("a", "a" );
    basisDataType();
  }

  private static void basisDataType() {
    int a = '你';
    char a1 = '你';

    System.out.println(a);
    System.out.println(a1);

  }
  private static void printVariableArgument(String ...strings) {
    for (String string : strings) {
      System.out.println(string);
    }
  }
  private static void printVariableArgument(String a, String b) {
    System.out.println(a + b);
  }

}
