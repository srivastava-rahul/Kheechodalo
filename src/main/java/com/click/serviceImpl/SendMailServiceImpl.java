/**
 * 
 */
package com.click.serviceImpl;

import java.util.Map;

import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.click.service.SendMailService;

import freemarker.template.Configuration;

/**
 * @author parveen
 */
@Component
@Transactional(readOnly = true)
public class SendMailServiceImpl implements SendMailService {

	@Autowired
	Configuration freemarkerConfiguration;

	@Value("${mail.from}")
	String MAIL_FROM;

	@Autowired
	JavaMailSender javaMailSender;

	// @Override
	// public void sendEmail(String mailTo, String subject, Map<String, Object> map, String template) {
	// if (StringUtils.checkString(mailTo).length() > 0) {
	// try {
	// LOG.info("Sending request email to : " + mailTo);
	// String message = FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerConfiguration.getTemplate(template),
	// map);
	// sendEmail(mailTo, subject, message);
	// } catch (Exception e) {
	// LOG.info("ERROR while Sending mail :" + e.getMessage(), e);
	// }
	// } else {
	// LOG.warn("No communication email configured for user... Not going to send email notification");
	// }
	// }

	/**
	 * @param mailTo
	 * @param subject
	 * @param map
	 * @param template
	 */
	@Override
	public void sendEmailTemplate(String[] mailTo, String subject, Map<String, Object> map, String template) {
		try {
			String message = FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerConfiguration.getTemplate(template), map);
			sendEmail(mailTo, subject, message);

		} catch (Exception e) {
			System.out.println("Error while sending template mail  to '" + mailTo + "' cause :" + e.getMessage());
		}
	}

	private void sendEmail(String[] mailTo, String subject, String message) {
		try {
			
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			Multipart multipart = new MimeMultipart( "alternative" );

		    MimeBodyPart htmlPart = new MimeBodyPart();
		    htmlPart.setContent( message, "text/html; charset=utf-8" );

		    multipart.addBodyPart( htmlPart );
		    mimeMessage.setContent( multipart );

			
			MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage);
			mailMsg.setFrom(MAIL_FROM);
			mailMsg.setTo(mailTo);
			mailMsg.setSubject(subject);
			//mailMsg.setText(message);
			javaMailSender.send(mimeMessage);
		} catch (Exception e) {
			System.out.println("Error While sending mail :" + e.getMessage());
			e.printStackTrace();
		}
	}
}
