package com.dbune.uam.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.dbune.uam.model.Role;
import com.dbune.uam.model.User;
import com.dbune.uam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(long id) {
        User dummyUser = new User();
        dummyUser.setUsername("user Down");
        dummyUser.setFirstName("Dow");
        dummyUser.setLastName("John ");
        return dummyUser;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user != null) {

            // get user roles
            Collection<Role> roles = user.getRoles();
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            for (Role role : roles) {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
                authorities.addAll(
                        role.getPrivileges().stream().map(privilege -> new SimpleGrantedAuthority(privilege.getName()))
                                .collect(Collectors.toList()));
            }

            // create a new user instance with just enough details as required for
            // authentication
            org.springframework.security.core.userdetails.User userForAuthentication = new org.springframework.security.core.userdetails.User(
                    user.getUsername(), user.getPassword(), user.isEnabled(), user.isAccountNonExpired(),
                    user.isCredentialsNonExpired(), user.isAccountNonLocked(), authorities);

            return userForAuthentication;
        }

        throw new UsernameNotFoundException("User '" + username + "' not found");
    }

}
