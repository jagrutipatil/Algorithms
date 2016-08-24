/*
As the title described, you should only use two stacks to implement a queue's actions.

The queue should support push(element), pop() and top() where pop is pop the first(a.k.a front) element in the queue.

Both pop and top methods should return the value of first element.

push(1)
pop()     // return 1
push(2)
push(3)
top()     // return 2
pop()     // return 2
*/

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


_______________________________________________________________


public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
      stack1 = new Stack<Integer>();
      stack2 = new Stack<Integer>();
    }
    
    public void push(int element) {
        stack1.push(element);
    }

    public int pop() {
        int t = -1;
        while (stack1.size() > 0) {
            stack2.push(stack1.pop());
        }
        if (stack2.size() > 0) {
            t = stack2.pop();
        }
        while (stack2.size() > 0) {
            stack1.push(stack2.pop());
        }
        return t;
    }
    

    public int top() {
        int t = -1;
        while (stack1.size() > 0) {
            stack2.push(stack1.pop());
        }
        if (stack2.size() > 0) {
            t = stack2.pop();
            stack2.push(t);
        }
        while (stack2.size() > 0) {
            stack1.push(stack2.pop());
        }
        return t;
    }
}