package br.com.imd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.imd.domain.Login;
import br.com.imd.domain.Usuario;
import br.com.imd.repositories.UsuarioRepository;
import services.TokenService;

@RestController
public class AuthController {
	
	UsuarioRepository userRepository = new UsuarioRepository();
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;


	/*@PostMapping("/login")
    public ResponseEntity<String> auth(String email, String password) {
        var user = userRepository.findByEmailAndPassword(email, password);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Username or password invalid");
        }
        return ResponseEntity.ok(Security.buildJwt(user.getEmail()));
    }*/
	@PostMapping("/login")
    public String auth(@RequestBody Login login) {
		
		UsernamePasswordAuthenticationToken userPassAuth = new UsernamePasswordAuthenticationToken(login.login(), login.password());
		
		Authentication auth = this.authenticationManager.authenticate(userPassAuth);
		Usuario usuario = (Usuario) auth.getPrincipal();
		return tokenService.buildJWT(usuario);
		
		
	}
}
