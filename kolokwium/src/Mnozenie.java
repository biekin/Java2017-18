import java.util.Stack;

public class Mnozenie extends Operator2Arg {
    @Override
    public double oblicz(Stack<Operator> stack) {
        return stack.pop().oblicz(stack)*stack.pop().oblicz(stack);
    }

    public Mnozenie(){
        wartosc="*";
    }
}
