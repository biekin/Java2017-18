package Lab1Ex4;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
/**
 *
 * @author Szymon
 */
public class LoginProgram {
    public static void main(String[] argv){
      Login log = new Login ("ala", "makota");
	  try{
		InputStreamReader rd = new InputStreamReader(System.in);
		BufferedReader bfr = new BufferedReader(rd);

        // TODO: prosba o wpisanie hasła i loginu
		String login = bfr.readLine();
        	String haslo = bfr.readLine();

        /*TODO: sprawdzenie czy podane hasło i login zgadzaja sie z tymi
         przechowywanymi w obiekcie log Jeśli tak, to ma zostać
         wyswietlone "OK", jesli nie - prosze wyswietlić informacje o błedzie
         */

		boolean correct;
		correct = log.check(login, haslo);
		if (correct == true){
		System.out.println("OK");
		}
		else{
		System.out.println("blad");
		}
	//	System.out.println(correct);

	  }catch(IOException e){e.printStackTrace();}
	

    }
}
