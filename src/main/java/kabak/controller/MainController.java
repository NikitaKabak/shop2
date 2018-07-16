package kabak.controller;


import kabak.Entity.Order;
import kabak.Entity.Product;
import kabak.Entity.User;
import kabak.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;


@Controller
public class MainController {
    private Integer iduser;

    private CatalogService catalogService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @Autowired
    private BasketService basketService;


    @Autowired
    public MainController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    /*private void chekid(HttpSession session) {

        if (session.getAttribute("iduser") != null) {
            iduser = (Integer) session.getAttribute("iduser");
        } else {
            iduser = 0;
            session.setAttribute("iduser", iduser);
        }
    }*/

    //GET

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView gotoIndexPage(HttpSession session) {
        /*chekid(session);*/
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public ModelAndView gotoStartPage(HttpSession session) {
        /*chekid(session);*/
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("startpage");
        return modelAndView;
    }

    @RequestMapping(value = "/shop/registracion", method = RequestMethod.GET)
    public ModelAndView gotoRegistracion(HttpSession session) {
        /*chekid(session);*/
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/shop/catalog", method = RequestMethod.GET)
    public ModelAndView gotoCatalog(HttpSession session) {
        /*chekid(session);*/
        List<Product> catalog = null;
        ModelAndView modelAndView = new ModelAndView();

        try {
            catalog = catalogService.getCatalog();

            modelAndView.addObject("catalog", catalog);
            modelAndView.setViewName("catalog");
            return modelAndView;
        } catch (Exception error) {
            modelAndView.addObject("error", error);
            modelAndView.setViewName("errorPage");
            return modelAndView;
        }

    }

    @RequestMapping(value = "/shop/product", method = RequestMethod.GET)
    public ModelAndView goToProduct(@RequestParam("idproduct") Integer idproduct,
                                    HttpSession session) {

        /*chekid(session);*/
        Product product = null;
        ModelAndView modelAndView = new ModelAndView();

        try {
            product = productService.getProductID(idproduct);

            modelAndView.addObject("product", product);
            modelAndView.setViewName("product");
            return modelAndView;
        } catch (Exception error) {
            modelAndView.addObject("error", error);
            modelAndView.setViewName("errorPage");
            return modelAndView;
        }

    }

    @RequestMapping(value = "/shop/basket", method = RequestMethod.GET)
    public ModelAndView goToBasket(HttpSession session) {

        /*chekid(session);*/
        Map<String, Integer> basketList;
        basketList = (Map<String, Integer>) session.getAttribute("BasketList");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("BasketList", basketList);
        modelAndView.setViewName("basket");
        return modelAndView;
    }


    // POST

    @RequestMapping(value = "/shop/login", method = RequestMethod.POST)
    public ModelAndView goToLogin(@RequestParam("name") String nameUser,
                                  @RequestParam("password") String passwordUser,
                                  HttpSession session) {


        if (nameUser.equals("") || passwordUser.equals("")) {
            String error = "Заполните все поля";
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("Error", error);
            modelAndView.setViewName("loginError");
            return modelAndView;
        } else {
            try {
                User user;
                user = userService.login(nameUser, passwordUser);
                if (user != null) {
                    Integer iduserLog = user.getIdUser();


                    List<Order> orderList;
                    orderList = orderService.getOrderList(user);


                    session.setAttribute("iduser", iduserLog);
                    ModelAndView modelAndView = new ModelAndView();
                    modelAndView.addObject("iduser", iduserLog);
                    modelAndView.addObject("TestUser", user);
                    modelAndView.addObject("TestOrderList", orderList);
                    switch (user.getUserRole().getRole()) {
                        case "admin":
                            modelAndView.setViewName("adminHomePage");
                            return modelAndView;
                        case "guest":
                            modelAndView.setViewName("guestHomePage");
                            return modelAndView;
                        case "user":
                            modelAndView.setViewName("userHomePage");
                            return modelAndView;
                        default:
                            modelAndView.setViewName("userHomePage");
                            return modelAndView;
                    }


                } else {
                    String error = "Имя пользователя или пароль введены не верно";
                    ModelAndView modelAndView = new ModelAndView();
                    modelAndView.addObject("Error", error);
                    modelAndView.setViewName("loginError");
                    return modelAndView;
                }
            } catch (Exception ex) {

                return new ModelAndView("errorPage").addObject(ex.getMessage());
            }
        }

    }


    @RequestMapping(value = "/shop/product", method = RequestMethod.POST)
    public ModelAndView addToBasket(@RequestParam("idProduct") Integer idProduct,
                                    @RequestParam("byqantity") Integer qantityByProduct,
                                    HttpSession session) {

        /*chekid(session);*/
        Map<Integer, Integer> map = (Map<Integer, Integer>) session.getAttribute("Basket");
        Map<Integer, Integer> basket;
        Map<String, Integer> basketList;
        List<Product> catalog = null;
        ModelAndView modelAndView = new ModelAndView();

        basket = basketService.getBasket(map);
        basket = basketService.putBasket(basket, idProduct, qantityByProduct);
        try {
            basketList = basketService.getBasketList(basket);
            catalog = catalogService.getCatalog();
            session.setAttribute("Basket", basket);
            session.setAttribute("BasketList", basketList);

            modelAndView.addObject("Basket", basket);
            modelAndView.addObject("BasketList", basketList);
            modelAndView.addObject("catalog", catalog);
            modelAndView.setViewName("catalog");
            return modelAndView;
        } catch (Exception error) {
            modelAndView.addObject("error", error);
            modelAndView.setViewName("errorPage");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/shop/orderCreate", method = RequestMethod.POST)
    public ModelAndView createOrder(HttpSession session) {

        /*chekid(session);*/
        Integer idUser = (Integer) session.getAttribute("iduser");
        Map<Integer, Integer> map = (Map<Integer, Integer>) session.getAttribute("Basket");
        ModelAndView modelAndView = new ModelAndView();

        try {
            User user = userService.getUser(idUser);
            orderService.createOrder(user, map);
            List<Order> orderList;
            orderList = orderService.getOrderList(user);

            session.setAttribute("Basket", null);
            session.setAttribute("BasketList", null);

            modelAndView.addObject("iduser", idUser);
            modelAndView.addObject("TestUser", user);
            modelAndView.addObject("TestOrderList", orderList);
            modelAndView.setViewName("userHomePage");
            return modelAndView;
        } catch (Exception error) {
            modelAndView.addObject("error", error);
            modelAndView.setViewName("errorPage");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/shop/registracion", method = RequestMethod.POST)
    public ModelAndView goRegistracion(@RequestParam("name") String userName,
                                       @RequestParam("password") String userPassword,
                                       @RequestParam("email") String userEmail,
                                       HttpSession session
    ) {
        /*chekid(session);*/
        ModelAndView modelAndView = new ModelAndView();
        try {
            Integer idUser = userService.registration(userName, userPassword, userEmail);
            User user = userService.getUser(idUser);
            List<Order> orderList;
            orderList = orderService.getOrderList(user);
            modelAndView.addObject("iduser", idUser);
            modelAndView.addObject("TestUser", user);
            modelAndView.addObject("TestOrderList", orderList);
            modelAndView.setViewName("userHomePage");
            return modelAndView;
        } catch (Exception error) {
            error.printStackTrace();
            modelAndView.addObject("error", error);
            modelAndView.setViewName("errorPage");
            return modelAndView;
        }
    }
}


