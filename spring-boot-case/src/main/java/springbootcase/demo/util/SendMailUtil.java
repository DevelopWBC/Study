package springbootcase.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import springbootcase.demo.pojo.dto.SystemMail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @Author Wangzhiwen
 * @ClassName SendMailUtil
 * @Description
 * @Date 2019/8/7 17:28
 * @Version 1.0
 */
@Component
public class SendMailUtil {


    private JavaMailSender mailSender;
    private Logger logger = LoggerFactory.getLogger(SendMailUtil.class);

    @Autowired
    public SendMailUtil(JavaMailSender mailSender){
        this.mailSender = mailSender;
    }

    /**
     * 普通邮件
     */
    public String sendSurfaceMail(){
        SimpleMailMessage message = new SimpleMailMessage();
        // 主题
        message.setSubject("普通邮件");
        // 内容
        message.setText("普通邮件大发送测试");
        // 邮件地址，可以是数组
        message.setTo("wangzhiwenem@163.com");
        // 发送地址
        message.setFrom("1015241415@qq.com");
        try {
            // 发送，可以是数组
            mailSender.send(message);
            logger.info("邮件发送成功");
            return "success";
        }catch (MailException e){
            logger.error("邮件发送失败",e);
            return "defeated";
        }
    }

    @Async
    public void sendSurfaceMail(SystemMail mail){
        SimpleMailMessage message = new SimpleMailMessage();
        // 主题
        message.setSubject(mail.getSubject());
        // 内容
        if (mail.getText() != null){
            message.setText(mail.getText());
        }else if (mail.getExceptionMsg() != null){
            message.setText(mail.getExceptionMsg());
        }else {
            logger.error("邮件内容为空");
            return;
        }
        // 邮件地址，可以是数组
        message.setTo(mail.getTo());
        // 发送地址
        message.setFrom(mail.getFrom());
        try {
            // 发送，可以是数组
            mailSender.send(message);
            logger.info("邮件发送成功："+mail);
        }catch (MailException e){
            logger.error("邮件发送失败："+mail,e);
        }
    }

    /**
     * html格式邮件
     */
    public String sendHtmlMail(){
        try {
            MimeMessage mimeMailMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMailMessage,true);
            // 标题
            messageHelper.setSubject("HTML格式邮件");
            // 设置HTML
            messageHelper.setText("<b style='color:red'>粗体文本</b>",true);
            // 收件人地址
            messageHelper.setTo("wangzhiwenem@163.com");
            // 发送人地址
            messageHelper.setFrom("1015241415@qq.com");
            mailSender.send(mimeMailMessage);
            return "success";
        } catch (MessagingException e) {
            logger.error("",e);
            return "defeated";
        }
    }

    @Async
    public void sendHtmlMail(SystemMail mail){
        try {
            MimeMessage mimeMailMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMailMessage,true);
            // 标题
            messageHelper.setSubject(mail.getSubject());
            // 设置HTML
            messageHelper.setText(mail.getExceptionMsg(),true);
            // 收件人地址
            messageHelper.setTo(mail.getTo());
            // 发送人地址
            messageHelper.setFrom(mail.getFrom());
            mailSender.send(mimeMailMessage);
            logger.info("邮件发送成功："+mail);
        } catch (MessagingException e) {
            logger.error("邮件发送失败："+mail,e);
        }
    }

    /**
     * 资源邮件
     */
    public String snedFileMail(){
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
            // 标题
            messageHelper.setSubject("HTML格式邮件");
            // 设置HTML
            messageHelper.setText("<b style='color:red'>附件邮件</b>",true);
            //附件
            messageHelper.addAttachment("1.jpg",new File("C:\\Users\\wangzhiwen\\Downloads\\1.jpg"));
            // 收件人地址
            messageHelper.setTo("wangzhiwenem@163.com");
            // 发送人地址
            messageHelper.setFrom("1015241415@qq.com");
            mailSender.send(mimeMessage);
            return "success";
        }catch (MessagingException e){
            logger.error("",e);
            return "defeated";
        }
    }
}
