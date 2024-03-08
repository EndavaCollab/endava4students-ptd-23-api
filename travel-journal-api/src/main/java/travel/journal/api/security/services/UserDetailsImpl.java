package travel.journal.api.security.services;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import travel.journal.api.entity.User;

import java.util.Collection;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    @Getter
    private int id;
    @JsonIgnore
    private String username;


    @JsonIgnore
    private String password;



    public UserDetailsImpl(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public static UserDetailsImpl build(User user) {


        return new UserDetailsImpl(
                user.getUser_id(),
                user.getEmail(),
                user.getPassword()
                );
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
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
