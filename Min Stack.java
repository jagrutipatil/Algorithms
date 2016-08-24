/*
Min Stack

Implement a stack with min() function, which will return the smallest number in the stack.

It should support push, pop and min operation all in O(1) cost.

push(1)
pop()   // return 1
push(2)
push(3)
min()   // return 2
push(1)
min()   // return 1


*/
public class MinStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;
    private Stack<Integer> temp;

    public MinStack() {
        mainStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
        temp = new Stack<Integer>();
    }

    public void push(int number) {
        mainStack.push(number);

        while (minStack.size() > 0 && minStack.peek() < number) {
            temp.push(minStack.pop());
        }
        minStack.push(number);
        while (temp.size() > 0) {
            minStack.push(temp.pop());
        }
    }

    public int pop() {
        int element = -1;
        if (mainStack.size() > 0) {
            element = mainStack.pop();
            while (minStack.size() > 0 && minStack.peek() != element) {
                temp.push(minStack.pop());
            }
            minStack.pop();
            while(temp.size() > 0) {
                minStack.push(temp.pop());
            }            
        }
        return element;
    }

    public int min() {
        return minStack.peek();
    }
}


________________________________________________________________________________________

//Worst Case: Memory allocation equivalent to two stacks
// push twice min value

public class MinStack {
    private Stack<Integer> stack;
    private int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack<Integer>();
    }

    public void push(int number) {
        if (number <= min) {
            stack.push(min);
            min = number;
        }
        stack.push(number);
    }

    public int pop() {
        int element = stack.pop();
        if (element == min) {
            min = stack.pop();
        }
        return element;
    }

    public int min() {
        return min;
    }
}

____________________________________________________________________________________

//Worst case space complexity equivalent to one stack
// logic: store the difference

public class MinStack {
    private Stack<Integer> stack;
    private int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack<Integer>();
    }

    public void push(int number) {
        if (stack.isEmpty()) {
            stack.push(0);
        } else {
            stack.push(number - min);
        }
        if (number < min) {
            min = number;
        }

    }

    public int pop() {
        int element = stack.pop();
        if (element > 0) {
            element += min;
        } else {
            int newMin = min - element;
            element = min;
            min = newMin;
            if (stack.isEmpty()) {
                min = Integer.MAX_VALUE;
            }
        }
        return element;
    }

    public int min() {
        return min;
    }
}
