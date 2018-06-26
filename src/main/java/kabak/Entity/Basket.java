package kabak.Entity;

import javax.persistence.*;


@Entity
@Table(name = "backet")
public class Basket {
    public Basket(){
    }

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

   @Column(name = "idbacket",nullable = false)
    private Integer idbacket;

    @Column(name = "qantityby")
    private Integer qantityby;

    @ManyToOne
    @JoinColumn (name = "idord")
    private Order order;

    @ManyToOne
    @JoinColumn (name = "idproduct")
    private Product product;

    public Integer getIdbacket() {
        return idbacket;
    }

    public void setIdbacket(Integer idbacket) {
        this.idbacket = idbacket;
    }

    public Integer getQantityby() {
        return qantityby;
    }

    public void setQantityby(Integer qantityby) {
        this.qantityby = qantityby;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "idbacket=" + idbacket +
              //  ", idorder=" + idorders +
              //  ", idproduct=" + idproduct +
                ", qantityby=" + qantityby +
                '}';
    }
}
