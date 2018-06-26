package kabak.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "userrole")
public class UserRole {

    @Id
    private Integer idroles;

    @Column
    private String role;

    @OneToMany(mappedBy = "userRole", cascade = CascadeType.ALL)
    private List<User> listUser = new ArrayList<>();

    public UserRole(){
    }

    public UserRole(Integer idroles){
        this.idroles = idroles;
    }

    public UserRole(Integer idRole,String role){
        this.idroles = idRole;
        this.role = role;
    }

    public Integer getIdRole() {
        return idroles;
    }

    public void setIdRole(Integer idRole) {
        this.idroles = idRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getListUser() {
        return listUser;
    }

    public void setListUser(List<User> listUser) {
        this.listUser = listUser;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "idRole=" + idroles +
                ", role='" + role + '\'' +
                '}';
    }
}
