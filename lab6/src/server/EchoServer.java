package server;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EchoServer {
    static String pass = "zaq";
    static int conn_token = 0;

    static String serverFiles = "/home/kb/Java/JavaLabs/lab6/src/server/ServerFiles";

    static String inputLine;
    static Pattern pat_login = Pattern.compile("LOGIN\\s*(.*);(.*)\\s*");
    static Pattern pat_logout = Pattern.compile("LOGOUT\\s(\\d{10})");
    static Pattern pat_ls = Pattern.compile("LS\\s*(\\d{10})\\s*");
    static Pattern pat_get = Pattern.compile("GET\\s*(\\d{10})\\s*(.*)");

    static Socket clientSocket = null;
    static ServerSocket serverSocket = null;


    public static String WhatUSayin(BufferedReader in, PrintWriter out) throws IOException {

//        System.out.println("JETEM");

        String userID;

        inputLine=in.readLine();

        Matcher mat_login = pat_login.matcher(inputLine);
        Matcher mat_logout = pat_logout.matcher(inputLine);
        Matcher mat_ls = pat_ls.matcher(inputLine);
        Matcher mat_get = pat_get.matcher(inputLine);

        if (mat_login.matches()) {
            String pass_guess = mat_login.group(2);
            // out.println(pass_guess);
            if (pass_guess.equals(pass)) {
                conn_token = conn_token + 1;
                return String.format("%010d", conn_token);

            }else return "wrong pass";

        } else if (mat_logout.matches()) {
            userID=mat_logout.group(1);
            return "logout";

        } else if (mat_ls.matches()) {
            userID=mat_ls.group(1);
            File folder = new File(serverFiles);
            File[] listOfFiles = folder.listFiles();
            String output="";
            for(int i=0; i<listOfFiles.length; i++)
            {
                output+=listOfFiles[i].getName()+";";
            }
            return output;

        } else if (mat_get.matches()) {
            userID=mat_get.group(1);
            return "get";

        } else if (inputLine.equals("exit")) return "exit";

        return "que";
    }

    public static void listen() {
        try {
            clientSocket = serverSocket.accept();
            System.out.println("slucham");
        } catch (IOException e) {
            System.out.println("Accept failed: 6666");
            System.exit(-1);
        }

    }

    public static void main(String[] args) throws IOException {

        try {
            serverSocket = new ServerSocket(6666);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 6666");
            System.exit(-1);
        }

        while (true) {
            listen();

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));


            String str = WhatUSayin(in,out);
            out.println(str);
            System.out.println(1);

            if(str.equals("exit")) {
                System.out.println(2);
                out.close();
                in.close();
                clientSocket.close();

                break;
            }
            System.out.println(20);
            out.close();
            System.out.println(21);
            in.close();
            System.out.println(22);
            clientSocket.close();
            System.out.println(23);

            System.out.println(3);
        }

        //clientSocket.close();
        serverSocket.close();


    }

    class SockReader implements Runnable {
        private Scanner in;
        private PrintStream out;
        private Socket s;

        public SockReader(Socket s) throws IOException {
            this(s.getInputStream(),s.getOutputStream());
            this.s = s;
        }

        public SockReader(InputStream input,OutputStream output) {
            in = new Scanner(input);
            out = new PrintStream(output);
        }

        private void msg(String msg) {
            System.out.print("SRV: ");
            System.out.println(msg);
        }
        public void run() {
            msg("serving new connection");
            while( (!Thread.currentThread().isInterrupted()) && in.hasNextLine() ) {
                String line = in.nextLine();
                msg(line);
                out.println(line);
            }
            try {
                out.close();
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            msg("connection closed");
        }
    }
}