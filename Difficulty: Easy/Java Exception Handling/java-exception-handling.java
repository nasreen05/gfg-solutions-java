class TestClass {

    private int a;
    private int b;

    // Constructor
    TestClass(int a, int b) {
        this.a = a;
        this.b = b;
    }

    // Method to find and print minimum value
    public void findMin() {
        int min;

        try {
            int add = a + b;
            int sub = a - b;
            int mul = a * b;
            int div = a / b;   // May throw ArithmeticException

            min = Math.min(Math.min(add, sub), Math.min(mul, div));
        } 
        catch (ArithmeticException e) {
            // If division by zero happens, ignore division
            int add = a + b;
            int sub = a - b;
            int mul = a * b;

            min = Math.min(Math.min(add, sub), mul);
        }

        System.out.println(min);
    }
}
