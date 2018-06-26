package kabak.service;


import kabak.DAO.HbmDaoImp;
import kabak.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CatalogService {

    private HbmDaoImp hbmDaoImp;

    @Autowired
    public CatalogService(HbmDaoImp productDAO) {
        this.hbmDaoImp = productDAO;
    }

//    @Transactional
    public List<Product> getCatalog() throws Exception {
        List<Product> catalog = null;
        catalog = hbmDaoImp.getAll();
        return catalog;
    }
}
