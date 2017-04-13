package com.quancai.utils;

import org.springframework.beans.factory.annotation.Value;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/**
 * Created by kenzh on 2016/8/17.
 */
public class SendMail {
    //,"yi.liu@qicai360.cn"
    @Value("${bi.cc.mail}")
    private static String ccMail;
    @Value("${bi.bcc.mail}")
    private static String bccMail;

    public static void send(String content, String file)  throws MessagingException {

        // 配置发送邮件的环境属性
        final Properties props = new Properties();

        // 表示SMTP发送邮件，需要进行身份验证
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.ym.163.com");
        // 发件人的账号
        props.put("mail.user", "kenzhao@qicai360.cn");
        // 访问SMTP服务时需要提供的密码
        props.put("mail.password", "a123456");

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        InternetAddress form = new InternetAddress(
                props.getProperty("mail.user"));
        message.setFrom(form);
        // 设置抄送
        message.setRecipients(RecipientType.CC, ccMail);

        // 设置密送，其他的收件人不能看到密送的邮件地址
//        InternetAddress bcc = new InternetAddress("kenzhao@qicai360.cn");
        message.setRecipients(RecipientType.BCC, bccMail);

        // 设置邮件标题
        message.setSubject("APP数据统计");

        // 设置邮件的内容体
//        message.setContent("<a href='http://www.baidu.com'></a>", "text/html;charset=UTF-8");
        message.setContent(content, "text/html;charset=UTF-8");
        //设置内容--begin
        Multipart mp = new MimeMultipart();
        //添加文本
        BodyPart bp1 = new MimeBodyPart();
        bp1.setContent(content, "text/html;charset = utf-8");
        mp.addBodyPart(bp1);

        if(file != null && file.trim().length() > 0) {
            //添加附件
            BodyPart bp2 = new MimeBodyPart();
            FileDataSource fields = new FileDataSource(file);
            bp2.setDataHandler(new DataHandler(fields));
            bp2.setFileName(fields.getName());
            mp.addBodyPart(bp2);
        }
        message.setContent(mp);
        //设置内容--end
        // 发送邮件
        Transport.send(message);
    }

    /**
     *
     * @param content
     * @param file
     * @param recipient 收件人
     * @param subject 主题
     * @throws MessagingException
     */
    public static void send(String content, String file, String recipient,String subject,String ccMail,String bccMail)  throws MessagingException {

        // 配置发送邮件的环境属性
        final Properties props = new Properties();

        // 表示SMTP发送邮件，需要进行身份验证
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.ym.163.com");
        // 发件人的账号
        props.put("mail.user", "kenzhao@qicai360.cn");
        // 访问SMTP服务时需要提供的密码
        props.put("mail.password", "a123456");

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        InternetAddress form = new InternetAddress(
                props.getProperty("mail.user"));
        message.setFrom(form);

        // 设置收件人dl-tech@qicai360.cn
//        InternetAddress to = new InternetAddress(recipient);
//        message.setRecipient(RecipientType.TO, to);
        message.setRecipients(RecipientType.TO,recipient);

        System.out.println(ccMail + "....." + bccMail);
        // 设置抄送
        message.setRecipients(RecipientType.CC, ccMail);


        // 设置密送，其他的收件人不能看到密送的邮件地址
        message.setRecipients(RecipientType.BCC, bccMail);

        // 设置邮件标题
        message.setSubject(subject);

        // 设置邮件的内容体
//        message.setContent("<a href='http://www.baidu.com'></a>", "text/html;charset=UTF-8");
        message.setContent(content, "text/html;charset=UTF-8");
        //设置内容--begin
        Multipart mp = new MimeMultipart();
        //添加文本
        BodyPart bp1 = new MimeBodyPart();
        bp1.setContent(content, "text/html;charset = utf-8");
        mp.addBodyPart(bp1);
        if(file != null && file.trim().length() > 0) {
            //添加附件
            BodyPart bp2 = new MimeBodyPart();
            FileDataSource fields = new FileDataSource(file);
            bp2.setDataHandler(new DataHandler(fields));
            bp2.setFileName(fields.getName());
            mp.addBodyPart(bp2);
        }
        message.setContent(mp);
        //设置内容--end
        // 发送邮件
        Transport.send(message);
    }

    /**
     * 发送邮件的测试程序
     *
     * @author lwq
     */
//    public static void main(String[] args) throws MessagingException {
//        // 配置发送邮件的环境属性
//        final Properties props = new Properties();
//
//        // 表示SMTP发送邮件，需要进行身份验证
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.host", "smtp.ym.163.com");
//        // 发件人的账号
//        props.put("mail.user", "shixian.zhou@qicai360.cn");
//        // 访问SMTP服务时需要提供的密码
//        props.put("mail.password", "Qicai2016");
//
//        // 构建授权信息，用于进行SMTP进行身份验证
//        Authenticator authenticator = new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                // 用户名、密码
//                String userName = props.getProperty("mail.user");
//                String password = props.getProperty("mail.password");
//                return new PasswordAuthentication(userName, password);
//            }
//        };
//        // 使用环境属性和授权信息，创建邮件会话
//        Session mailSession = Session.getInstance(props, authenticator);
//        // 创建邮件消息
//        MimeMessage message = new MimeMessage(mailSession);
//        // 设置发件人
//        InternetAddress form = new InternetAddress(
//                props.getProperty("mail.user"));
//        message.setFrom(form);
//
//        // 设置收件人
//        InternetAddress to = new InternetAddress("1334599897@qq.com");
//        message.setRecipient(RecipientType.TO, to);
//
//        InternetAddress[] addressList = new InternetAddress[emailUsers.length];
//        InternetAddress cc = null;
//        for(int i = 0; i < emailUsers.length; i++){
//            cc = new InternetAddress(emailUsers[i]);
//            addressList[i] = cc;
//        }
//
//        // 设置抄送
//        message.setRecipients(RecipientType.CC, addressList);
//
//        // 设置密送，其他的收件人不能看到密送的邮件地址
//        InternetAddress bcc = new InternetAddress("kenzhao@qicai360.cn");
//        message.setRecipient(RecipientType.BCC, bcc);
//
//        // 设置邮件标题
//        message.setSubject("测试邮件");
//
//        // 设置邮件的内容体
//        message.setContent("<a href='http://www.baidu.com'>HTML邮件</a>", "text/html;charset=UTF-8");
//
//
//
//        //设置内容--begin
//        Multipart mp = new MimeMultipart();
//        //添加文本
//        BodyPart bp1 = new MimeBodyPart();
//        bp1.setContent("你好<a href='http://www.baidu.com'>HTML邮件</a>", "text/html;charset = utf-8");
//        mp.addBodyPart(bp1);
//        //添加附件
//        BodyPart bp2 = new MimeBodyPart();
//        FileDataSource fields = new FileDataSource("C:\\Users\\K\\Pictures\\2.jpg");
//        bp2.setDataHandler(new DataHandler(fields));
//        bp2.setFileName(fields.getName());
//        mp.addBodyPart(bp2);
//        message.setContent(mp);
//        //设置内容--end
//
//
//        // 发送邮件
//        Transport.send(message);
//    }
}
