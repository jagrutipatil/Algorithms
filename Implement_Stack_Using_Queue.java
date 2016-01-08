class MyStack {
    Queue<Integer> value = new LinkedList<Integer>();
 

    // Push element x onto stack.
    public void push(int x) {
        value.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        for (int i = 1; i < value.size(); i++) {
            value.add(value.remove());
        }

        value.remove();
    }

    // Get the top element.
    public int top() {
        for (int i = 1; i < value.size(); i++) {
            value.add(value.remove());
        }

        int x = value.remove();
        value.add(x);
        return x;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return value.isEmpty();
    }
}