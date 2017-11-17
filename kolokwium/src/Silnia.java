import java.util.Stack;

public class Silnia extends Operator1Arg {
    @Override
    public double oblicz(Stack<Operator> stack) {
        return 0;
    }

    private int fact(int a){
        int fact = 1;
        for(int i=1;i<=a;i++){
            fact=fact*i;
        }
        return fact;
    }
}
