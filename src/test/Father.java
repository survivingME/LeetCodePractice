package test;

public class Father {
    private String a = "father";
    public Father() {
        say();
    }
    public void say() {
        System.out.println("father" + a);
    }

    public static void main(String[] args) {
        Father f = new Father();
        Son s = new Son();
        Father fs = new Son();
    }
}

class Son extends Father {
    private String a = "son";
    public void say() {
        System.out.println("son" + a);
    }
}
