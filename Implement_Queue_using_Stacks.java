class MyQueue {
    Stack<Integer> mainStack = new Stack<Integer>();
    Stack<Integer> temp = new Stack<Integer>();

 
    // Push element x to the back of queue.
    public void push(int x) {
        while (!mainStack.isEmpty()) {
            temp.push(mainStack.pop());
        }
        mainStack.push(x);

        while(!temp.isEmpty()) {
            mainStack.push(temp.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        mainStack.pop();    
    }

    // Get the front element.
    public int peek() {
        return mainStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return mainStack.isEmpty();
    }
}