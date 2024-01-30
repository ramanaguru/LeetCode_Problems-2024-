class MyQueue {

    //2 stacks
    Stack<Integer>s1 = new Stack<>();
    Stack<Integer>s2 = new Stack<>();


    public MyQueue() {
        
    }

    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int dequeue = s2.pop();

        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }

        return dequeue;
    }
    
    public int peek() {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }

        int top = s2.peek();

        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }

        return top;
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

