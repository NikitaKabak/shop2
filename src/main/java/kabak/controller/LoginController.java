package kabak.controller;

import kabak.Entity.Order;
import kabak.Entity.User;
import kabak.service.OrderService;
import kabak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    private AuthenticationManager authManager;
    private final static GrantedAuthority GRANTED_AUTHORITY_MANAGER = new SimpleGrantedAuthority("ROLE_USER");
    private final static GrantedAuthority GRANTED_AUTHORITY_ADMIN = new SimpleGrantedAuthority("ROLE_ADMIN");
    /*private final static GrantedAuthority GRANTED_AUTHORITY_MANAGER = new SimpleGrantedAuthority("ROLE_USER");*/

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    public LoginController(AuthenticationManager authManager) {
        this.authManager = authManager;
    }


 @RequestMapping(value = "/", method = RequestMethod.GET)
 public ModelAndView login() {
     ModelAndView modelAndView = new ModelAndView();
     /*modelAndView.setViewName("login");*/
     modelAndView.setViewName("startpage");
     return modelAndView;
 }
   /* @RequestMapping(value = "/gotologin", method = RequestMethod.GET)
    public ModelAndView goTologin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }*/
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ModelAndView userLogout() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/authorization", method = RequestMethod.POST)
    public ModelAndView userAuthorizationN(
            @RequestParam(value = "userLastName") String userLastName,
            @RequestParam(value = "userPassword") String userPassword,
            HttpSession session)    {
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(userLastName, userPassword);
        Authentication authentication = authManager.authenticate(authenticationToken);
        List<GrantedAuthority> grantedAuthorities = (List<GrantedAuthority>) authentication.getAuthorities();
        User user = (User) authentication.getDetails();

        SecurityContextHolder.getContext().setAuthentication(authentication);
        Integer iduserLog = user.getIdUser();


        // TEST REpository

        /*String userName = user.getNameUser();*/

        List<Order> orderList;
        try {
         //   User user2 = userService.findByLastName(userName);
            orderList = orderService.getOrderList(user);
            session.setAttribute("iduser", iduserLog);
            ModelAndView modelAndView = new ModelAndView();
         //   modelAndView.addObject("TestUser2", user2);
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
                    modelAndView.setViewName("guestHomePage");
                    return modelAndView;
            }
        } catch (Exception ex) {
            return new ModelAndView("errorPage").addObject(ex.getMessage());
        }

    }
}
