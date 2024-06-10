package com.cni.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cni.jwt.JwtUtils;
import com.cni.model.ERole;
import com.cni.model.JwtResponse;
import com.cni.model.LoginRequest;
import com.cni.model.MessageResponse;
import com.cni.model.Role;
import com.cni.model.SignupRequest;
import com.cni.model.User;
import com.cni.model.UserDetailsImpl;
import com.cni.repository.RoleRepository;
import com.cni.repository.UserRepository;
import com.cni.service.EmailService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class UserController {
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtUtils jwtUtils;

    @Autowired
    private EmailService emailService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
		Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());
		if (user.isPresent()) {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtUtils.generateJwtToken(authentication);

			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
			List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
					.collect(Collectors.toList());
			if (!user.get().isEtat() && user.get().getRole().getName().equals(ERole.ROLE_USER))
				return ResponseEntity.badRequest().body("En Attend l'acceptation de l'admin ");

			return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getFirstName(),
					userDetails.getEmail(), roles));

		} else {
			return ResponseEntity.badRequest().body(" Email est incorrecte ");
		}

	}

	@PostMapping("/register")
	public ResponseEntity<?> signup(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already taken!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getFirstName(), signUpRequest.getLastName(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));
		Role role = roleRepository.findByName(ERole.ROLE_USER).get();
		user.setRole(role);
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("Admin est bien notifié "));
	}
	
	@PostMapping("/forgotPassword")
    public ResponseEntity<?> forgotPassword(@RequestParam("email")String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (!user.isPresent()) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email not found!"));
        }

        String resetUrl = "http://localhost:4200/#/reset/email/" + email;
        String subject = "Password Reset Request";
        String body = "To reset your password, click the link below:\n" + resetUrl;

        emailService.sendMail(user.get().getEmail(), subject, body);
        emailService.sendMail(email, subject, body);
        return ResponseEntity.ok(new MessageResponse("Password reset email sent!"));
    }
	
	
	@PostMapping("/reset")
	public ResponseEntity<?> resetPassword(@RequestParam("password") String password,@RequestParam("email") String email ) {
		
		User user = userRepository.findByEmail(email).get();
		user.setPassword(encoder.encode(password));
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("mod de passe est bien modifié "));
	}
}