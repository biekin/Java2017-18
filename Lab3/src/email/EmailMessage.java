package email;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailMessage {
    private String from_;
    private String to_;
    private String subject_;
    private String content_;

    public EmailMessage(Builder builder){
        from_=builder.from_;
        to_=builder.to_;
        subject_=builder.subject_;
        content_=builder.content_;
    }

    public void Send() {

    }

    public static class Builder {
        private String from_;
        private String to_;
        private String subject_;
        private String content_;

        public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

        public static boolean validate(String emailStr) {
            Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
            return matcher.find();
        }


        public Builder AddFrom(String from) {

            if (validate(from)==true) {
                this.from_=from;
            }
            return this;
        }

        public Builder AddTo(String to) {

            if (validate(to)==true) {
                this.to_=to;
            }
            return this;
        }

        public Builder AddSUbject(String subject) {

            this.subject_=subject;
            return this;
        }

        public Builder AddContent(String content) {

            this.content_=content;
            return this;
        }

        public EmailMessage build() {
            return new EmailMessage(this);

        }

    }

    public static Builder bulider() {
        return new EmailMessage.Builder();
    }
}
