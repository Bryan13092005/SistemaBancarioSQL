package SistemaBancario;

import Usuarios_excepcion.Usuario;

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
                String nombre=txtUse.getText().trim(), pass=txtPass.getText().trim();
                double monto=0;
                boolean encontrado=false;
                for (Usuario u: listaUsuarios){
                    if (u.getUsuario().equals(nombre) && u.getClave().equals(pass)) {
                        encontrado=true;
                        monto=u.getMonto();
                    }
                }
                if(!encontrado){
                    txtPass.setText("");
                    txtUse.setText("");
                    JOptionPane.showMessageDialog(null,"USUARIO O CLAVE INCORRECTOS","DENEGADO",JOptionPane.WARNING_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"INGRESO EXISTOSO");
                    AccionesBancarias acciones=new AccionesBancarias(monto,nombre);
                    new BancoPrincipal(acciones);
                    Login.this.dispose();
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
