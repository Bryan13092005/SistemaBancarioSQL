package SistemaBancario;

import Usuarios_excepcion.Usuario;
import Usuarios_excepcion.UsuariosDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static app.Main.listaUsuarios;


public class Login extends JFrame{
    private JTextField txtUse;
    private JTextField txtPass;
    private JButton ingresarButton;
    private JButton registrarButton;
    private JPanel login_panel;

    public Login () {
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombre = txtUse.getText().trim();
                String pass = txtPass.getText().trim();

                Usuario u = UsuariosDAO.validarLogin(nombre, pass);

                if (u == null) {
                    txtPass.setText("");
                    txtUse.setText("");
                    JOptionPane.showMessageDialog(null, "USUARIO O CLAVE INCORRECTOS", "DENEGADO", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "INGRESO EXITOSO");

                    AccionesBancarias acciones = new AccionesBancarias(u.getMonto(), u.getUsuario());
                    new BancoPrincipal(acciones);
                    dispose();
                }
            }
        });

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.this.dispose();
                new Registro();
            }
        });
        setContentPane(login_panel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,300);
        setTitle("Banco Togma-Bryan S.A");
        setLocationRelativeTo(null);
    }

    public static void main() {
        new Login();
    }
}
