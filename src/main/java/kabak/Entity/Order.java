package kabak.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Transient
    public static final Orderstatus DEFAULT_ORDERSTATUS = new Orderstatus(1,"begin");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idorder;

    @Column
    private String data;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<Basket> listBasket = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idusers" )
    private User user;

    @ManyToOne
    @JoinColumn(name = "idstatusorder")
    private Orderstatus orderstatus;

    public Order() {
    }

    public Order(Integer idorder, User user, String data, Orderstatus orderstatus) {
        this.idorder = idorder;
        this.user = user;
        this.data = data;
        this.orderstatus = orderstatus;
    }

    public Integer getIdorder() {
        return idorder;
    }

    public void setIdorder(Integer idorder) {
        this.idorder = idorder;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Basket> getListBasket() {

        return listBasket;
    }

    public void setListBasket(List<Basket> listBasket) {
        this.listBasket = listBasket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Orderstatus getOrgerStatus() {
        return orderstatus;
    }

    public void setOrgerStatus(Orderstatus orgerStatus) {
        this.orderstatus = orgerStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idorder=" + idorder +
                ", data='" + data + '\'' +
                '}';
    }
}
