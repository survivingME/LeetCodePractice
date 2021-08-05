package test;

public class IntegerTest {
    public static void main(String[] args) {
        Integer a=new Integer(10);
        Integer d=Integer.valueOf(10);
        Integer b=10;
        int c=10;
        System.out.println(a==b);
        System.out.println(b==c);
        System.out.println(a==c);
        System.out.println(a == d);
        System.out.println(b == d);
    }
}
