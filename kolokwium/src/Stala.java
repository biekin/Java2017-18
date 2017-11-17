
import java.util.Stack;

public class Stala extends Operator0Arg {
    @Override
    public double oblicz(Stack<Operator> stack) {
        System.out.println(" dsdfsd"); //debugger nie dziala
        return Double.parseDouble(getWartosc());

    }

    public Stala(String val) {
        wartosc = val;
    }
}