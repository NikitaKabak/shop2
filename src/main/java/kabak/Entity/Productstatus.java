package kabak.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "productstatus")
public class Productstatus {

    @Id
    private Integer idproductstatus;
    @Column(name = "productstatus")
    private String productstatusName;
    @OneToMany(mappedBy = "productstatus", fetch = FetchType.LAZY)
    private List<Product> listProduct = new ArrayList<>();

    public Productstatus(){
    }

    public Productstatus(Integer idproductstatus, String productstatus){
        this.idproductstatus = idproductstatus;
        this.productstatusName = productstatus;
    }

    public Integer getIdproductstatus() {
        return idproductstatus;
    }

    public void setIdproductstatus(Integer idproductstatus) {
        this.idproductstatus = idproductstatus;
    }

    public String getProductstatusName() {
        return productstatusName;
    }

    public void setProductstatusName(String productstatus) {
        this.productstatusName = productstatus;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    @Override
    public String toString() {
        return "Productstatus{" +
                "idproductstatus=" + idproductstatus +
                ", productstatus='" + productstatusName + '\'' +
                '}';
    }
}
