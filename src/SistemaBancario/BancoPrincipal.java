package SistemaBancario;

import Usuarios_excepcion.Usuario;

import javax.swing.*;


public class BancoPrincipal extends JFrame{
    private JButton depositoButton;
    private JButton salirButton;
    private JButton retiroButton;
    private JButton transferenciaButton;
    private JPanel Banca;
    private JLabel saldo;
    private JLabel usuario;

    public BancoPrincipal(AccionesBancarias usuarioIngresado){
        setContentPane(Banca);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        saldo.setText(String.valueOf(usuarioIngresado.getSaldo()));
        usuario.setText(usuarioIngresado.getNombre().toUpperCase());
        depositoButton.addActionListener(e -> {
            try {
                double monto = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el monto a depositar: $"));
                if (monto > 0) {
                    usuarioIngresado.deposito(monto);
                    saldo.setText(String.valueOf(usuarioIngresado.getSaldo()));
                    JOptionPane.showMessageDialog(null,"Transaccion exitosa");
                } else {
                    JOptionPane.showMessageDialog(null, "Monto invalido", "ERROR", JOptionPane.WARNING_MESSAGE);
                }
            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null,"Ingresaste una letra","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        });

        retiroButton.addActionListener(e -> {
            try{
                double monto=Double.parseDouble(JOptionPane.showInputDialog("Ingresa el monto: $"));
                if (monto>Double.parseDouble(saldo.getText())||monto<0){
                    JOptionPane.showMessageDialog(null, "Monto invalido", "ERROR", JOptionPane.WARNING_MESSAGE);
                }else{
                    usuarioIngresado.retiro(monto);
                    saldo.setText(String.valueOf(usuarioIngresado.getSaldo()));
                    JOptionPane.showMessageDialog(null,"Transaccion exitosa");
                }
            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null,"Monto invalido","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        });

        transferenciaButton.addActionListener(e -> {
            try{
                double monto=Double.parseDouble(JOptionPane.showInputDialog("Ingresa el monto: $"));
                String destinatario=JOptionPane.showInputDialog("Ingresa el destinatario: ");
                if (monto>Double.parseDouble(saldo.getText())||monto<0){
                    JOptionPane.showMessageDialog(null, "Monto invalido", "ERROR", JOptionPane.WARNING_MESSAGE);
                }else if(destinatario.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Usuario vacio", "ERROR", JOptionPane.WARNING_MESSAGE);
                }else{
                    usuarioIngresado.transferir(monto,destinatario);
                    saldo.setText(String.valueOf(usuarioIngresado.getSaldo()));
                }
            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null,"Monto invalido","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        });

        salirButton.addActionListener(e -> {
            dispose();
            new Login();
        });
    }
}
