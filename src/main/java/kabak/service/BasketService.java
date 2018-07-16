package kabak.service;

import kabak.DAO.HbmDaoImp;
import kabak.Entity.Basket;
import kabak.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.NamingException;
import java.util.HashMap;
import java.util.Map;


@Service
public class BasketService {
    private HbmDaoImp hbmDaoImp;
    private  Map<Integer,Integer> basket;
    private  Map<String, Integer> basketList = new HashMap<>();

    @Autowired
    public BasketService(HbmDaoImp productDAO){
        this.hbmDaoImp = productDAO;
    }

    public Map<Integer,Integer> getBasket(Map<Integer,Integer> map){
        this.basket = map;
         return basket;
    }



    public Map<Integer,Integer> putBasket(Map<Integer,Integer> map, Integer idProduct, Integer qantityByProduct){

        this.basket = map;
        if (basket == null){
            basket = new HashMap<>();
        }
        this.basket.put(idProduct,qantityByProduct);
        return basket;
    }

  //  @Transactional
    public Map<String, Integer> getBasketList(Map<Integer,Integer> basket)  throws Exception {
        this.basket = basket;
        //
        this.basketList = new HashMap<>();
        //
        for (Map.Entry entry : basket.entrySet()){
            Integer id = (Integer) entry.getKey();
            Integer qantity = (Integer) entry.getValue();

            Product product = (Product) hbmDaoImp.get(id);
            String nameProduct = product.getNameproduct();
            String basketListKey = "id#name: " + id + "#" + nameProduct + " Количество: " + qantity + " Стоимость : " + (product.getPrice() * qantity);
            basketList.put(basketListKey, qantity);
        }
       return basketList;
    }

}
