package in.tucaurto.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import in.tucaurto.dao.UserLoginRepository;
import in.tucaurto.dao.UserRepository;
import in.tucaurto.entity.UserLogin;

@Service
public class EmailSenderService
{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserLoginRepository userLoginDao;

	private JavaMailSender javaMailSender;
	@Autowired
	public EmailSenderService(JavaMailSender javaMailSender)
	{
		this.javaMailSender = javaMailSender;
	}

	public String sendEmail(String email) throws MailException
	{
		if(userRepository.existsById(email))
		{
			UserLogin userLogin= new UserLogin();
			userLogin=userLoginDao.findByUsername(email);
			SimpleMailMessage mail = new SimpleMailMessage();
			String otp=UUID.randomUUID().toString();
			userLogin.setOtp(otp);
			userLoginDao.save(userLogin);
			mail.setTo(userLogin.getUsername());
			mail.setSubject("One time password to change password");
			mail.setText("Your one time password is:"+otp);

			
			javaMailSender.send(mail);
			return "Mail Sent";
		}
		else
			return "Email not registered!!";
			
		
	}


	
	public String checkOtp(String email, String otp)
	{
		UserLogin user=userLoginDao.findByUsername(email);
		String passcode=user.getOtp();
		if(otp.equals(passcode) == true)
			return "OTP verified!!";
		return "Wrong OTP!!";
	}
	
}
