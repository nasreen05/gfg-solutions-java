class GenericClass<T> {

    // Private data variable
    private T data;

    // Constructor to initialize the data variable
    public GenericClass(T data) {
        this.data = data;
    }

    // Method to show the type and value
    public void showType() {
        if (data instanceof String) {
            System.out.println("String");
        } else if (data instanceof Integer) {
            System.out.println("Integer");
        }
        System.out.println(data);
    }
}
