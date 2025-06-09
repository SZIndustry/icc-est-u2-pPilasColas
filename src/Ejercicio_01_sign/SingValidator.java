package Ejercicio_01_sign;
import materia.StackG;

public class SingValidator {
    public static boolean isValid(String array) {
        StackG<Character> pila = new StackG<>();
        
        for (int i = 0; i < array.length(); i++) {
            char c = array.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                pila.push(c); 

            } else {
                if (pila.isEmpty()) {
                    return false;
                }

                char top = pila.pop();
                
                if ((c == ')' && top != '(') || 
                    (c == '}' && top != '{') || 
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return pila.isEmpty();
    }
}