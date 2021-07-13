package test;

public class Singleton {
    public static volatile Singleton singleton = null;

    private Singleton() {}

    public Singleton getInstance() {
        if(singleton == null) {
            synchronized (Singleton.class) {
                if(singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
