package pl.dawidkaszuba.glasscalc.entity;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    private String email;

    private String password;

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    private int active;

    @NotEmpty
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<Glass2Tiles> glass2TilesList;

    @OneToMany(mappedBy = "user")
    private List<Glass3Tiles> glass3TilesList;

    public User() {
    }

    public User(User user) {
        this.active=user.getActive();
        this.email=user.getEmail();
        this.roles=user.getRoles();
        this.name=user.getName();
        this.lastName=user.getLastName();
        this.id = user.getId();
        this.password = user.getPassword();

    }


    public User(String email, String password, String name, String lastname, int active, Set<Role> roles) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastname;
        this.active=active;
        this.roles = roles;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Glass2Tiles> getGlass2TilesList() {
        return glass2TilesList;
    }

    public void setGlass2TilesList(List<Glass2Tiles> glass2TilesList) {
        this.glass2TilesList = glass2TilesList;
    }

    public List<Glass3Tiles> getGlass3TilesList() {
        return glass3TilesList;
    }

    public void setGlass3TilesList(List<Glass3Tiles> glass3TilesList) {
        this.glass3TilesList = glass3TilesList;
    }
}
