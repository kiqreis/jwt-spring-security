package br.com.security_test.jwt_security.auth;

import br.com.security_test.jwt_security.config.JwtService;
import br.com.security_test.jwt_security.repository.UserRepository;
import br.com.security_test.jwt_security.user.Role;
import br.com.security_test.jwt_security.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {
    var user = User.builder()
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.USER)
        .build();

    userRepository.save(user);
    var token = jwtService.generateToken(user);

    return AuthenticationResponse.builder()
        .token(token)
        .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
    );

    var user = userRepository.findByEmail(request.getEmail())
        .orElseThrow();

    var token = jwtService.generateToken(user);

    return AuthenticationResponse.builder()
        .token(token)
        .build();
  }

}
