package kabak.service;

import kabak.DAO.HbmDaoImp;
import kabak.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
}
