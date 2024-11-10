package org.dnynyog.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.dnynyog.dto.OtpRequest;
import org.dnynyog.dto.UserResponce;
import org.dnynyog.entity.User;
import org.dnynyog.enums.ResponceCode;
import org.dnynyog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;

@Service
public class OtpNotificationImpl {

	@Autowired
	UserRepo repo;
	
	public UserResponce otpValidate(OtpRequest request) throws IOException
	{
		UserResponce responce=UserResponce.getInstance();
		Optional<User> user=Optional.ofNullable(repo.findByEmail(request.getEmail()));
		if(user.isPresent())
		{
			int otp=new Random().nextInt(900000)+100000;
			String subject=otp+" OTP for login";
			String body="Dear customer, use this One Time Password "+otp+" to log in to your Farmer I-Connect account. "
					+ "This OTP will be valid for the next 5 mins.";
			String footer="Best regards,\n Farmer I-Connect";
			sendEmail(request.getEmail(), subject, body, footer);
			return responce.setCode(ResponceCode.OTP_SENT_SUCCESS.getCode())
					.setStatus(ResponceCode.OTP_SENT_SUCCESS.getStatus())
					.setMessage(ResponceCode.OTP_SENT_SUCCESS.getMessage())
					.setTimestamp(LocalDateTime.now());
			
		}
		else
		{
			return responce.setCode(ResponceCode.OTP_SENT_FAILED.getCode())
					.setStatus(ResponceCode.OTP_SENT_FAILED.getStatus())
					.setMessage(ResponceCode.OTP_SENT_FAILED.getMessage())
					.setTimestamp(LocalDateTime.now());
		}
	}
	private void sendEmail(String recipientEmail, String subject, String body, String footer) throws IOException {
        try {
            Properties properties = PropertiesLoaderUtils.loadProperties(new ClassPathResource("application.config"));

            Session session = Session.getInstance(properties, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(properties.getProperty("email.sender.address"),
                            properties.getProperty("email.sender.password"));
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(properties.getProperty("email.sender.address")));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            message.setSubject(subject);

            // Clean body and footer
            body = cleanString(body);
            footer = cleanString(footer);

            // Set email content
            message.setText(body + "\n" + footer);
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private String cleanString(String inputStr) {
        // Remove leading and trailing whitespace
        inputStr = inputStr.trim();
        // Remove control characters
        inputStr = inputStr.replaceAll("[\\p{Cntrl}&&[^\r\n\t]]", "");
        return inputStr;
    }
}
