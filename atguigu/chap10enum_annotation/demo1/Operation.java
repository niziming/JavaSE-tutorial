package atguigu.chap10enum_annotation.demo1;

public enum Operation {
    PLUS{
        @Override
        double eval(double x, double y) {
            return x + y;
        }
    },
    MINUS{
        @Override
        double eval(double x, double y) {
            return x - y;
        }
    },
    TIMES {
        @Override
        double eval(double x, double y) {
            return x * y;
        }
    },
    DIVIDE {
        @Override
        double eval(double x, double y) {
            return x / y;
        }
    };
    abstract double eval (double x, double y);

    public static void main(String[] args) {
        Operation[] values = Operation.values();
        for (Operation value : values) {
            System.out.print(value.ordinal() + "." + value.toString() + " ");
            System.out.println(value.eval(10, 2));
        }
    }
}
