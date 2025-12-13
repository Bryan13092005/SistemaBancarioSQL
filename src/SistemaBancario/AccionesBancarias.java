package SistemaBancario;

import Usuarios_excepcion.Usuario;
import static app.Main.listaUsuarios;

public class AccionesBancarias {
    private double saldo;
    private String nombre;
    public AccionesBancarias(double saldo,String nombre){
        this.nombre=nombre;
        this.saldo=saldo;
    }

    public void deposito(double monto){
        saldo+=monto;
    }

    public void retiro(double monto){
        saldo-=monto;
    }

    public void transferir(double monto,String usuarioTranferencia){
        for(Usuario u:listaUsuarios){
            if (u.getUsuario().equals(usuarioTranferencia)){
                saldo-=monto;
                u.setMonto(u.getMonto()+monto);
                break;
            }
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNombre() {
        return nombre;
    }
}
