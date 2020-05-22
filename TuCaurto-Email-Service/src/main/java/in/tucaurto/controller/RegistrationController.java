package in.tucaurto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.tucaurto.model.SellerBuyer;
import in.tucaurto.model.User;
import in.tucaurto.service.MailService;



@RestController
@CrossOrigin("http://localhost:4200")
public class RegistrationController
{
	@Autowired
	private MailService notificationService;
	
	@PostMapping("/send-mail")
	public String send(@RequestBody User user)
	{
		System.out.println(user.getUsername());
		
		try
		{
			notificationService.sendEmail(user);
			
		} catch (MailException mailException)
		{
			System.out.println(mailException);
		}
		
		return "Sent Successfully";
	}

	@PostMapping("/sharedetails")
	public String shareDetails(@RequestBody SellerBuyer sellerBuyer)
	{
		System.out.println(sellerBuyer.getEmail());
		
		try
		{
			notificationService.shareDetailEmail(sellerBuyer);
			
		} catch (MailException mailException)
		{
			System.out.println(mailException);
		}
		
		return "Sent Successfully";
	}
	
}
