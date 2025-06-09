import Ejercicio_01_sign.SingValidator;
import Ejercicio_02_sorting.StackSorter;
import materia.StackG;

public class App {
    public static void main(String[] args) throws Exception {
        String array = "({[(]})";
        System.out.println("Cadena ingresada: " + array);
        System.out.println(SingValidator.isValid(array) ? "La cadena es válida." : "La cadena no es válida.");

        StackG<Integer> stack = new StackG<>();
        stack.push(5);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("\nEntrada desordenado |");
        stack.printStack();

        StackSorter sorter = new StackSorter();  
        sorter.sortStack(stack);                 

        System.out.println("Salida ordenado |");
        stack.printStack();                      
    }
}
