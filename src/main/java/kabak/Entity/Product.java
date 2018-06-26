package kabak.Entity;

import javax.persistence.*;

@Entity
@Table(name = "product" )
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idproduct;
    @Column
    private String nameproduct;
    @Column
    private Integer idcategory;
    @Column
    private Integer quantity;
    @Column
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "idstatusproduct")
    private Productstatus productstatus;

    public Product(){}

    public Product(Integer idproduct, String nameproduct, Integer idcategory, Integer idstatusproduct, Integer quantity, Integer price){
        this.idproduct = idproduct;
        this.nameproduct = nameproduct;
        this.idcategory = idcategory;
       // this.idstatusproduct = idstatusproduct;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(Integer idproduct) {
        this.idproduct = idproduct;
    }

    public String getNameproduct() {
        return nameproduct;
    }

    public void setNameproduct(String nameproduct) {
        this.nameproduct = nameproduct;
    }

    public Integer getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(Integer idcategory) {
        this.idcategory = idcategory;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Productstatus getProductstatus() {


        return productstatus;
    }

    public void setProductstatus(Productstatus productstatus) {
        this.productstatus = productstatus;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idproduct=" + idproduct +
                ", nameproduct='" + nameproduct + '\'' +
                ", idcategory=" + idcategory +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
