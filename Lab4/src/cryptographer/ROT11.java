package cryptographer;

public class ROT11 implements Algorithm {

    String[] alphabet="ABCDEFGHIJKLMNOPRSTUWXYZ".split("");
    final int ROT = 11;

    @Override
    public String crypt(String word) {

        String crypted_="";

        for (int i=0; i<word.length(); i++) {
            crypted_+=word.charAt(i)+11;
        }

        return crypted_;
    }

    @Override
    public String decrypt(String word) {

        String decrypted_="";

        for (int i=0; i<word.length(); i++) {
            decrypted_+=word.charAt(i)-11;
        }

        return decrypted_;
    }
}
