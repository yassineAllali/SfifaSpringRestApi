package ma.sfifa.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ma.sfifa.model.User;
import ma.sfifa.repository.UserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByEmail(username);
		
		if(user.isPresent()) 
			return new JpaUserDetails(user.get());
		throw new UsernameNotFoundException("email not found : " + username );
	}

}
