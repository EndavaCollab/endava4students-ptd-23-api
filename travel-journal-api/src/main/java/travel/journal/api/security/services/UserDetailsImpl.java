package travel.journal.api.security.services;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import travel.journal.api.entity.User;

import java.io.Serial;
import java.util.Collection;
import java.util.Objects;


public class UserDetailsImpl implements UserDetails {
    @Serial
    private static final long serialVersionUID = 1L;

    private  Long id;
    @JsonIgnore
    private String username;
    @JsonIgnore
    private String first_name;
    @JsonIgnore
    private String last_name;
    @JsonIgnore
    private String password;



    public UserDetailsImpl(Long id, String username,String first_name,String last_name,String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.first_name=first_name;
        this.last_name=last_name;

    }

    public static UserDetailsImpl build(User user) {

        return new UserDetailsImpl(
                user.getUser_id(),
                user.getEmail(),
                user.getFirst_name(),
                user.getLast_name(),
                user.getPassword()
                );
    }


    public Long getId() {
        return id;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}
