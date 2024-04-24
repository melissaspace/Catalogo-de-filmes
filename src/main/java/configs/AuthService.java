package configs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.mbf.trabalho_final.entities.Adm;
import com.mbf.trabalho_final.repositories.AdmRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuthService  implements UserDetailsService {
    
    @Autowired
    private AdmRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Adm adm = repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
    
        return new User(adm.getUsername(), adm.getPassword(),true, true, true, true, adm.getAuthorities());
    }
    
}
