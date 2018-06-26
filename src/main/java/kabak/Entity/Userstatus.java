package kabak.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "userstatus")
public class Userstatus {
    @Id
    private Integer iduserstatus;
    @Column
    private String userstatus;
    @OneToMany(mappedBy = "userStatus",cascade = CascadeType.ALL)
    private List<User> listUser = new ArrayList<>();

    public Userstatus(Integer iduserstatus){
        this.iduserstatus = iduserstatus;
    }

    public Userstatus(){
    }
    public Userstatus(Integer iduserstatus,String userstatus){
        this.iduserstatus = iduserstatus;
        this.userstatus = userstatus;
    }

    public Integer getIduserstatus() {
        return iduserstatus;
    }

    public void setIduserstatus(Integer iduserstatus) {
        this.iduserstatus = iduserstatus;
    }

    public String getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(String userstatus) {
        this.userstatus = userstatus;
    }

    public List<User> getListUser() {
        return listUser;
    }

    public void setListUser(List<User> listUser) {
        this.listUser = listUser;
    }
}
