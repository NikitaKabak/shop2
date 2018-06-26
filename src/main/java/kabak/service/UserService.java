package kabak.service;


import kabak.DAO.HbmDaoImp;
import kabak.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {
    private HbmDaoImp hbmDaoImp;

    @Autowired
    public UserService(HbmDaoImp userDAO){
        this.hbmDaoImp = userDAO;
    }

 //   @Transactional
    public User login(String nameUser, String passwordUser) throws Exception {
        User userLog;
        userLog = (User) hbmDaoImp.getWhereName("User", "nameUser", nameUser);

        if (userLog != null && passwordUser.equals(userLog.getPasswordUser())) {
            return userLog;

        } else {
            userLog = null;
            return userLog;

        }
    }

//    @Transactional
    public User getUser(Integer idUser)  throws Exception {
        User user;
        user = (User) hbmDaoImp.get(idUser);
        return user;
    }


}