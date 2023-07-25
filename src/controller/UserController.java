package controller;

import model.repositories.UserRepository;
import model.entities.User;
import view.frmUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author hevfacma
 */
public class UserController implements ActionListener {

    private final User userModel;
    private final UserRepository userRepository;
    private final frmUser UserView;

    public UserController(User model, UserRepository modelRepository, frmUser view) {
        this.userModel = model;
        this.userRepository = modelRepository;
        this.UserView = view;
        this.UserView.btnGuardar.addActionListener(this);
        this.UserView.btnModificar.addActionListener(this);
        this.UserView.btnEliminar.addActionListener(this);
        this.UserView.btnBuscar.addActionListener(this);
        this.begin();
    }

    public void begin() {
        UserView.setTitle("Users");
        UserView.setLocationRelativeTo(null);
        UserView.txtId.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == UserView.btnGuardar) {
            userModel.setCode(UserView.txtId.getText());
            userModel.setName(UserView.txtNombre.getText());

            if (userRepository.create(userModel)) {
                JOptionPane.showMessageDialog(null, "Usuario Guardado");
                clean();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar Usuario");
                clean();
            }
        }

        if (e.getSource() == UserView.btnModificar) {
            userModel.setId(Integer.parseInt(UserView.txtId.getText()));
            userModel.setCode(UserView.txtId.getText());
            userModel.setName(UserView.txtNombre.getText());

            if (userRepository.update(userModel)) {
                JOptionPane.showMessageDialog(null, "Usuario Actualizado");
                clean();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Actualizar Ususario");
                clean();
            }
        }

        if (e.getSource() == UserView.btnEliminar) {
            userModel.setId(Integer.parseInt(UserView.txtId.getText()));

            if (userRepository.delete(userModel)) {
                JOptionPane.showMessageDialog(null, "Usuario Eliminado");
                clean();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar Usuario");
                clean();
            }
        }

        if (e.getSource() == UserView.btnBuscar) {
            userModel.setCode(UserView.txtId.getText());
            User foundUser = userRepository.findByCode(userModel.getCode());
            if (foundUser != null) {
                UserView.txtId.setText(String.valueOf(foundUser.getId()));
                UserView.txtId.setText(foundUser.getCode());
                UserView.txtNombre.setText(foundUser.getName());

            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                clean();
            }
        }
    }

    public void clean() {
        UserView.txtId.setText(null);
        UserView.txtCodigo.setText(null);
        UserView.txtNombre.setText(null);
    }
}
