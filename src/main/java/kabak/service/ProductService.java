package kabak.service;

import kabak.DAO.HbmDaoImp;
import kabak.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ProductService {
    HbmDaoImp hbmDaoImp;

    @Autowired
    public ProductService(HbmDaoImp productDAO){
        this.hbmDaoImp = productDAO;
    }

  //  @Transactional
    public Product getProductID(Integer idproduct)  throws Exception {
        Product product;
        product = (Product) hbmDaoImp.get(idproduct);
        return product;
    }
    public List<Product> getAllProducts()  throws Exception {
        List<Product> productList;
        productList = (List<Product>) hbmDaoImp.getAll();
        return productList;
    }
}
