class testClass implements in1 {
    
    public void display(int k) {
        int count = 0;
        
        for (int i = 2; i <= k; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        
        System.out.println(count);
    }
    
    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return n > 1;
    }
}
