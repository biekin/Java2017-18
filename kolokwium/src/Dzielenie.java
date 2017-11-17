import java.util.Stack;

public class Dzielenie extends Operator2Arg {
    @Override
    public double oblicz(Stack<Operator> stack) {
        return stack.pop().oblicz(stack)/stack.pop().oblicz(stack);
    }
}
