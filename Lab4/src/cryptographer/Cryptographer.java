package cryptographer;

import java.io.PrintWriter;
import java.util.Scanner;

public class Cryptographer {

    private static String crypted_;
    private static String[] crypted_words_;
    private static String decrypted_;
    private static String[] decrypted_words_;

    public static void cryptfile(Scanner read, PrintWriter write, Algorithm alg) {

        crypted_=read.toString();
        crypted_words_=crypted_.split(" ");
        for (String word : crypted_words_) {
            write.write(alg.crypt(word)+" ");
        }

    }

    public static void decryptfile(Scanner read, PrintWriter write, Algorithm alg) {

        decrypted_=read.toString();
        decrypted_words_=decrypted_.split(" ");
        for (String word : decrypted_words_) {
            write.write(alg.decrypt(word)+" ");
        }
    }
}
