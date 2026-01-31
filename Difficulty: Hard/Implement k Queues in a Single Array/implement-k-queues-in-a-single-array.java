class kQueues {
    int[] arr;     // main array to store elements
    int[] next;    // next index (for queue links and free list)
    int[] front;   // front index of each queue
    int[] rear;    // rear index of each queue
    int free;      // beginning of free list
    int n, k;

    kQueues(int n, int k) {
        this.n = n;
        this.k = k;

        arr = new int[n];
        next = new int[n];
        front = new int[k];
        rear = new int[k];

        // initialize all queues as empty
        for (int i = 0; i < k; i++) {
            front[i] = -1;
            rear[i] = -1;
        }

        // initialize free list
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        free = 0;
    }

    void enqueue(int x, int i) {
        if (isFull()) return;

        int index = free;          // get free index
        free = next[index];        // update free list

        if (front[i] == -1) {
            front[i] = index;
        } else {
            next[rear[i]] = index;
        }

        next[index] = -1;
        rear[i] = index;
        arr[index] = x;
    }

    int dequeue(int i) {
        if (isEmpty(i)) return -1;

        int index = front[i];
        front[i] = next[index];

        // add index back to free list
        next[index] = free;
        free = index;

        if (front[i] == -1) {
            rear[i] = -1;
        }

        return arr[index];
    }

    boolean isEmpty(int i) {
        return front[i] == -1;
    }

    boolean isFull() {
        return free == -1;
    }
}
