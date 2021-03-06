package at.bartendr.backend.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.data.annotation.Version;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username", nullable = false, length = 35, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "admin")
    private boolean admin;

    @Column(name = "firstname", length = 35)
    private String firstname;

    @Column(name = "lastname", length = 35)
    private String lastname;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "active", nullable = false)
    private boolean active = true;

    @Version
    @JsonIgnore
    private long version;

    public User() {
    }

    public User(String username, String password, boolean admin, String firstname, String lastname, String email, boolean active, long version) {
        this.username = username;
        this.password = password;
        this.admin = admin;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.active = active;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                isAdmin() == user.isAdmin() &&
                isActive() == user.isActive() &&
                getVersion() == user.getVersion() &&
                getUsername().equals(user.getUsername()) &&
                getPassword().equals(user.getPassword()) &&
                Objects.equals(getFirstname(), user.getFirstname()) &&
                Objects.equals(getLastname(), user.getLastname()) &&
                Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getPassword(), isAdmin(), getFirstname(), getLastname(), getEmail(), isActive(), getVersion());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                ", version=" + version +
                '}';
    }
}
