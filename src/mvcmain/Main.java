package mvcmain;

import controller.UserController;
import model.repositories.UserRepository;
import model.entities.User;
import view.frmUser;

/**
 *
 * @author hevfacma
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        User userModel = new User();
        UserRepository userRepository = new UserRepository();
        frmUser userFrame = new frmUser();

        new UserController(userModel, userRepository, userFrame);
        userFrame.setVisible(true);
    }
}
