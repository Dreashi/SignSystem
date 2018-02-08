package com.xzy.service.email;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class MyEailUtil {
    public static void sendEmail(String toAddress,String toNickName,String subject,String content) throws MessagingException,UnsupportedEncodingException {
        Properties props = new Properties();
        //邮件使用的SMTP协议
        props.setProperty("mail.transport.protocol","smtp");
        //配置发件人的SMTP服务器地址
        props.setProperty("mail.smtp.host",SendEmailConfig.EMAIL_SMTP_URL);
        //请求认证邮件
        props.setProperty("mail.smtp.awth","true");
        Session session = Session.getDefaultInstance(props);
        //创建一个邮件
        MimeMessage message = new MimeMessage(session);
        //s设置发件人
        message.setFrom(new InternetAddress(SendEmailConfig.FROM_ADDRESS,SendEmailConfig.SEND_NICKNAME,"UTF-8"));
        //设置收件人
        message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(toAddress,toNickName));
        //设置标题
        message.setSubject(subject,"UTF-8");
        //设置内容
        message.setContent(content,"text/html;charset=UTF-8");
        //保存
        message.saveChanges();
        //发送邮件
        Transport transport = session.getTransport();
        transport.connect(SendEmailConfig.FROM_ADDRESS,SendEmailConfig.EMAIL_PWD);
        transport.sendMessage(message,message.getAllRecipients());
        //断开连接
        transport.close();
    }
}
