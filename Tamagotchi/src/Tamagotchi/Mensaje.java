package Tamagotchi;

import javax.swing.JOptionPane;

public class Mensaje {

    private static Mensaje instancia;

    private Mensaje() {

    }

    public static Mensaje obtenerInstancia() {
        if (instancia == null) {
            instancia = new Mensaje();
        }
        return instancia;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void noQuieroJugar() {
        mostrarMensaje("No quiero jugar");
    }

    public void noQuieroDormir() {
        mostrarMensaje("No quiero dormir");
    }

    public void noQuieroComer() {
        mostrarMensaje("No quiero comer");
    }

    public void noQuieroQueMeCures() {
        mostrarMensaje("No necesito que me cures");
    }

    public void noQuieroBaniarme() {
        mostrarMensaje("No quiero bañarme");
    }

}
