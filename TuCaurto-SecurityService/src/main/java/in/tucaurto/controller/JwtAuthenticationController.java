package in.tucaurto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.tucaurto.config.JwtTokenUtil;
import in.tucaurto.entity.JwtRequest;
import in.tucaurto.entity.JwtResponse;
import in.tucaurto.entity.Role;
import in.tucaurto.entity.SupportDTO;
import in.tucaurto.entity.UserDTO;
import in.tucaurto.service.EmailSenderService;
import in.tucaurto.service.JwtUserDetailsService;

@RestController
@CrossOrigin("*")
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private EmailSenderService emailSenderService;
	
//	@Autowired
//	private JwtSupportDetailsService supportDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		
		
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);
		
		Role role= userDetailsService.findRole(authenticationRequest.getUsername());
		return ResponseEntity.ok().body(new JwtResponse(token, userDetails.getUsername(),role.getRole()));
	}
	
	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		return userDetailsService.saveUser(user);
	}
	
	@RequestMapping(value = "/support/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveSupport(@RequestBody SupportDTO support) throws Exception{
		return ResponseEntity.ok(userDetailsService.saveSupport(support));
	}
	
	@RequestMapping(value = "/generate-otp", method = RequestMethod.POST)
	public ResponseEntity<?> reqPass(@RequestParam String email)
	{
		emailSenderService.sendEmail(email);
		return ResponseEntity.ok("Please check your mail!!");
	}
	
	@RequestMapping(value="/submit-otp", method=RequestMethod.POST)
	public ResponseEntity<?> checkOtp(@RequestParam String email, @RequestParam String otp)
	{
		String status=emailSenderService.checkOtp(email, otp);
		return ResponseEntity.ok(status);
	}
	
	@RequestMapping(value="/change-pass", method=RequestMethod.POST)
	public ResponseEntity<?> changePass(@RequestParam String email,@RequestParam String newPass)
	{
		String status=userDetailsService.changePass(email, newPass);
		return ResponseEntity.ok(status);
	}
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
