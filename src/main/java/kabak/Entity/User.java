package kabak.Entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "users")
public class User implements Serializable {

    @Transient
    public static final Integer DEFAULT_ROLE = 0;
    @Transient
    public static final Integer DEFAULT_STATUS = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;
    @Column
    private String nameUser;
    @Column
    private String passwordUser;
    @Column
    private String emailUser;

    @ManyToOne
    @JoinColumn(name = "idrole")
    private UserRole userRole = new UserRole(DEFAULT_ROLE) ;

    @ManyToOne
    @JoinColumn(name = "idstatus")
    private Userstatus userStatus = new Userstatus(DEFAULT_STATUS) ;

    public User() {
    }

    public User(Integer idUser, String nameUser, String passwordUser, String emailUser, Integer idRole, Integer idStatus) {
        this.nameUser = nameUser;
        this.passwordUser = passwordUser;
        this.emailUser = emailUser;
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Userstatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Userstatus userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "nameUser='" + nameUser + '\'' +
                ", passwordUser='" + passwordUser + '\'' +
                ", emailUser='" + emailUser + '\'' +
                ", idUser=" + idUser +
                '}';
    }


}
