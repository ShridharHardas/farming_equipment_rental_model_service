package org.dnynyog.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.dnynyog.dto.UserRequest;
import org.dnynyog.dto.UserResponce;
import org.dnynyog.entity.User;
import org.dnynyog.enums.ResponceCode;
import org.dnynyog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationImple {

	@Autowired
	UserRepo repo;
	@Autowired
	AuthService encrypt;
	
	
	public UserResponce addUser(UserRequest request) throws Exception {
		UserResponce responce=UserResponce.getInstance();
		
		if(request.getFirstName()==null || request.getEmail()==null ||
			request.getLastName()==null || request.getPassword()==null ){
			
			return responce.setCode(ResponceCode.INCOMPLETE_DATA.getCode())
			       .setStatus(ResponceCode.INCOMPLETE_DATA.getStatus())
			       .setMessage(ResponceCode.INCOMPLETE_DATA.getMessage())
				   .setTimestamp(LocalDateTime.now());
		}
		
		User user=User.getInstance()
				.setFirstName(request.getFirstName())
				.setLastName(request.getLastName())
				.setEmail(request.getEmail())
				.setPassword(encrypt.encrypt(request.getPassword()))
				.setPincode(request.getPincode())
				.setMobileno(request.getMobileno());
		 String subject="Thanks for registering on Farmer I-Connect";
		 String body="Dear Sir/Madam"+"\n\n"+"Welcome "+request.getFirstName()+"\n\n"+"\tAs a farmer , choose a better way of farming. More economical, more environmental and human friendly"+
				 "\nAs a farmer, share your equipment ride with the community for more savings.\n";
		 String footer="\n\t\t\tBest regards,"+"\n"+"Farmer I-Connect";	
		
		try
		{
			User userTable=repo.save(user);
			sendEmail(request.getEmail(), subject, body, footer);
			return responce.setCode(ResponceCode.REGISTER_SUCCESS.getCode())
					.setStatus(ResponceCode.REGISTER_SUCCESS.getStatus())
					.setMessage(ResponceCode.REGISTER_SUCCESS.getMessage())
					.setTimestamp(LocalDateTime.now());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return responce.setCode(ResponceCode.CATCH_BLOCK_ERROR.getCode())
					.setStatus(ResponceCode.CATCH_BLOCK_ERROR.getStatus())
					.setMessage(ResponceCode.CATCH_BLOCK_ERROR.getMessage())
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
