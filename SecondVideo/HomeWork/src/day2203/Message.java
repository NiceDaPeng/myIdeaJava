package day2203;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message implements Serializable{
    private static final long SeriaVersionUID = 1L;
    private String sender;
    private String reporter;
    private String message;
    private Date time;

    public Message() {
    }

    public Message(String sender, String reporter, String message, Date time) {
        this.sender = sender;
        this.reporter = reporter;
        this.message = message;
        this.time = time;
    }

    public static long getSeriaVersionUID() {
        return SeriaVersionUID;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", reporter='" + reporter + '\'' +
                ", message='" + message + '\'' +
                ", time=" + time +
                '}';
    }
}
