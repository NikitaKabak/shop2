package kabak.controller;

import kabak.Entity.Order;
import kabak.Entity.Product;
import kabak.Entity.User;
import kabak.service.BasketService;
import kabak.service.OrderService;
import kabak.service.ProductService;
import kabak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping(value = "/admin/*")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @Autowired
    private BasketService basketService;

    public AdminController() {
    }


    @RequestMapping(value = "/showAllUsers", method = RequestMethod.GET)
    public ModelAndView showAllUsers() {
        List<User> userList;
        try {
            userList = userService.getAllUsers();
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("UserList", userList);
            modelAndView.setViewName("users");
            return modelAndView;
        } catch (Exception ex) {
            return new ModelAndView("errorPage").addObject(ex.getMessage());
        }
    }
    @RequestMapping(value = "/showAllProducts", method = RequestMethod.GET)
    public ModelAndView showAllProduct() {
        List<Product> productList;
        try {
            productList = productService.getAllProducts();
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("ProductList", productList);
            modelAndView.setViewName("products");
            return modelAndView;
        } catch (Exception ex) {
            return new ModelAndView("errorPage").addObject(ex.getMessage());
        }
    }
    @RequestMapping(value = "/showAllOrders", method = RequestMethod.GET)
    public ModelAndView showAllOrders() {
        List<Order> orderList;
        try {
            orderList = orderService.getAllOrders();
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("OrderList", orderList);
            modelAndView.setViewName("orders");
            return modelAndView;
        } catch (Exception ex) {
            return new ModelAndView("errorPage").addObject(ex.getMessage());
        }
    }
}
