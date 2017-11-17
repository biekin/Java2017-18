import java.util.Scanner;
import java.util.Stack;

public class WeWy {

    private static Stack<Operator> stos = new Stack<>();

    public WeWy(){}

    public static Stack<Operator> pobierzDzialanie() {

        String dzialanie;
        String[] elements;
        Scanner scan = new Scanner(System.in);
        dzialanie = scan.nextLine();
        elements = dzialanie.split(" ");

        for (int i=elements.length-1; i>=0; i--)
        {
            if (elements[i]=="+") stos.push(new Dodawanie());
            else if (elements[i]=="*") stos.push(new Mnozenie());
            else if (elements[i]=="/") stos.push(new Dzielenie());
            else if (elements[i]=="!") stos.push(new Silnia());
            else stos.push(new Stala(elements[i]));
        }

        return stos;
    }
    public static void zapiszWynik(){

       System.out.println( stos.pop().oblicz(stos));

    }
}
