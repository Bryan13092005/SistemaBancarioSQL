package app;

import SistemaBancario.Login;
import Usuarios_excepcion.Usuario;

import java.util.ArrayList;

public class Main {

    public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public static void main(String[] args) {
        new Login();
    }
}
