package kabak.service;

import kabak.DAO.HbmDaoImp;
import kabak.Entity.Basket;
import kabak.Entity.Order;
import kabak.Entity.Product;
import kabak.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class OrderService {
    private HbmDaoImp hbmDaoImp;

    @Autowired(required = true)
    private HbmDaoImp productDAO;

    @Autowired
    public OrderService(HbmDaoImp orderDAO) {
        this.hbmDaoImp = orderDAO;
    }

    //@Transactional
    public List<Order> getOrderList(User user)  throws Exception {
        List<Order> orderList = new ArrayList<>();
        List<Order> testOrderList;
        testOrderList = hbmDaoImp.getListWhereName("Order", "user", user);

        for (Order order : testOrderList) {
            orderList.add((Order) hbmDaoImp.getListWhereNameJoin("Order", "Basket", "Order", "order", order));
        }
        return orderList;
    }

    //@Transactional
    public void createOrder(User user, Map<Integer, Integer> map)  throws Exception {

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data = dateFormat.format(date);

        Order order = new Order();
        order.setData(data);
        order.setUser(user);
        order.setOrgerStatus(order.DEFAULT_ORDERSTATUS);

        List<Basket> basketList = new ArrayList<>();

        Map<Integer, Integer> basketMap = map;

        for (Map.Entry entry : basketMap.entrySet()) {
            Basket basket = new Basket();

            Integer idProduckt = (Integer) entry.getKey();
            Integer qantityby = (Integer) entry.getValue();

            basket.setOrder(order);
            basket.setProduct((Product) productDAO.get(idProduckt));
            basket.setQantityby(qantityby);
            basketList.add(basket);

        }
        order.setListBasket(basketList);
        hbmDaoImp.save(order);
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) {
    }

   /* public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (request.getParameter("nameButton")) {
            case "Create":
                HttpSession session = request.getSession();
                HbmDaoImp daoImpl = new HbmDaoImp();
              //  HbmDaoImp daoImpl = context.getBean("HbmDaoImp",HbmDaoImp.class);
                Integer iduser = (Integer) session.getAttribute("iduser");
                User user = (User) daoImpl.get(User.class, iduser);

                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String data = dateFormat.format(date);

                Order order = new Order();

                order.setData(data);
                order.setUser(user);
                order.setOrgerStatus(order.DEFAULT_ORDERSTATUS);

////////////// ХЗ КАК ЭТО БУДЕТ РАБОТАТЬ

                Map<Integer, Integer> map = (Map<Integer, Integer>) session.getAttribute("Basket");
                List<Basket> backetList = new ArrayList<>();

                if (map != null) {
                    Map<Integer, Integer> backetMap = new HashMap<>();
                    backetMap.putAll(map);
                    System.out.println("Map из requesta");
                    System.out.println(backetMap);

                    for (Map.Entry entry : backetMap.entrySet()) {
                        Basket backet = new Basket();

                        Integer idProduckt = (Integer) entry.getKey();
                        Integer qantityby = (Integer) entry.getValue();
                        System.out.println("Key: " + idProduckt + " Value: " + qantityby);

                        backet.setOrder(order);
                        backet.setProduct((Product) daoImpl.get(Product.class, idProduckt));
                        backet.setQantityby(qantityby);
                        backetList.add(backet);
                    }
                }

                order.setListBasket(backetList);
                daoImpl.save(order);



                session.setAttribute("backet", null);
                HomePageService gotoPage = new HomePageService(request, response);
                gotoPage.gotoHomePage(user);


            default:
                request.getRequestDispatcher("/WEB-INF/pages/notFound.jsp").forward(request, response);
                break;
        }

    }*/


}
