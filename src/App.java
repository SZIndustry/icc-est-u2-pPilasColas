import Ejercicio_01_sign.SingValidator;
import materia.StackG;

public class App {
    public static void main(String[] args) throws Exception {
        StackG<Character> pilaG = new StackG<>();

        String array = "({[(]})";

        System.out.println("Cadena ingresada: " + array);

        System.out.println(SingValidator.isValid(array) == true ? "La cadena es válida." : "La cadena no es válida.");
    }
}

