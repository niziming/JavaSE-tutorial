package itcast.chap13;

public class VisualAccumulator {
    public static void main(String[] args) {
        int gcd = gcd(21, 22);
        System.out.println(gcd);
    }
    public static int gcd (int p, int q) {
        if (q == 0) return p;
        int i = p % q;
        return gcd(q, i);
    }
}
