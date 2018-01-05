package server;

import java.io.*;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EchoClient {
    static String ID = null;
    static Socket echoSocket = null;
    static PrintWriter out = null;
    static BufferedReader in = null;

    public static String ToServer(String userInput, BufferedReader in, PrintWriter out) throws IOException {
       // System.out.println("Type a message: ");
        //String userInput = stdIn.readLine();
        out.println(userInput);
        String serverOutput = in.readLine();
        System.out.println("echo: " + serverOutput);
        return serverOutput;

    }

    static void connect () {
        try {
            echoSocket = new Socket("localhost", 6666);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: localhost.");
            System.exit(1);
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));

        String serverOutput="";
        Pattern pat_ID = Pattern.compile("\\s*\\d{10}\\s*");
        Matcher mat_ID = pat_ID.matcher(serverOutput);

        try {

            File f = new File("/home/kb/Java/JavaLabs/lab6/src/server/pass.txt");

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            System.out.println("Reading file using Buffered Reader");

            while ((readLine = b.readLine()) != null) {
                //System.out.println(readLine);
                connect();
                serverOutput = ToServer("LOGIN aaa;"+readLine, in, out);
                if(mat_ID.matches()){
                    ID=serverOutput;
                    System.out.println(ID);
                    System.out.println("SUKCESS");
                    break;
                }


            }

            out.close();
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


//        while (!mat_ID.matches()) {
//            connect();
//            serverOutput = ToServer("", in, out);
//
//        }

        //TODO reconnect

        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}