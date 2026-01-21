class MinStack {
    Stack<Long> s = new Stack<>();
    long min; 

    public MinStack() {
        
    }
    
    public void push(int val) {
        long valLong = (long) val;
        if (s.isEmpty()) {
            min = valLong;
            s.push(valLong);
        } else {
            if (valLong < min) {
                s.push(2 * valLong - min);
                min = valLong;
            } else {
                s.push(valLong);
            }
        }
    }
    
    public void pop() {
        if (s.isEmpty()) return;
        
        long x = s.pop();
    
        if (x < min) {
            min = 2 * min - x; 
        }
    }
    
    public int top() {
        if (s.isEmpty()) return -1; 
        
        long x = s.peek();
        
        if (x < min) {
            return (int) min;
        }
        return (int) x;
    }
    
    public int getMin() {
        return (int) min;
    }
}