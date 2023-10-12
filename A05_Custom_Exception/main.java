class MySpecialNumberException extends Exception {
    public MySpecialNumberException(String message) {
        super(message);
    }
}

public class MyFunctionExample {
    public static void myfunc(int x) throws MySpecialNumberException {
        if (x == 10) {
            throw new MySpecialNumberException("x should not be 10.");
        } else if (x == 20) {
            throw new MySpecialNumberException("x should not be 20.");
        } else if (x == 30) {
            throw new MySpecialNumberException("x should not be 30.");
        } else {
            System.out.println("x is: " + x);
        }
    }

    public static void main(String[] args) {
        try {
            myfunc(15);
            myfunc(10);
            myfunc(25);
            myfunc(30);
        } catch (MySpecialNumberException e) {
            System.out.println("Caught MySpecialNumberException: " + e.getMessage());
        } finally {
            System.out.println("Finally block: Cleanup and final statements.");
        }
    }
}