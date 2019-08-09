package springbootcase.demo.pojo.dto;

import java.io.File;
import java.util.Date;

/**
 * @Author Wangzhiwen
 * @ClassName SystemMail
 * @Description
 * @Date 2019/8/8 11:27
 * @Version 1.0
 */
public class SystemMail {
    private String subject;
    private String text;
    private String to;
    private String from;
    private Date sentDate;
    private File file;
    /**
     *
     */
    private String exceptionMsg;

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String declaringTypeName,String methodName,String args,Class clazz,String msg) {
        this.exceptionMsg =
                 "<p>模块："+declaringTypeName+"."+methodName+"</p>"
                +"<p>参数：body"+args+""+"<p>"
                +"<p>异常："+clazz+":"+msg+"<p>";
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "SystemMail{" +
                "subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", sentDate=" + sentDate +
                ", file=" + file +
                ", exceptionMsg='" + exceptionMsg + '\'' +
                '}';
    }
}
