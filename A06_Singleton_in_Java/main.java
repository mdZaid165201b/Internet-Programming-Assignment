public class Singleton {
    private static Singleton instance;
    private Singleton() {
    }
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void performTask() {
        System.out.println("Singleton instance performing a task.");
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.performTask();
    }
}