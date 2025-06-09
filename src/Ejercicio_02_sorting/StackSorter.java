package Ejercicio_02_sorting;
import materia.StackG;

public class StackSorter {

    public void sortStack(StackG<Integer> stack) {
        StackG<Integer> sortedStack = new StackG<>();
        StackG<Integer> auxStack = new StackG<>();

        while (!stack.isEmpty()) {
            int current = stack.pop();

            while (!sortedStack.isEmpty() && sortedStack.peek() > current) {
                auxStack.push(sortedStack.pop());
            }

            sortedStack.push(current);

            while (!auxStack.isEmpty()) {
                sortedStack.push(auxStack.pop());
            }
        }

        while (!sortedStack.isEmpty()) {
            stack.push(sortedStack.pop());
        }
    }
}
