public class MinStack {
    
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        stack.push(number);
        if (minStack.isEmpty() || number <= Integer.parseInt(minStack.peek().toString())) {
            minStack.push(number);
        }
    }

    public int pop() {
        if (!minStack.isEmpty() && stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return stack.pop();
    }

    public int min() {
        return minStack.peek();
    }
}
