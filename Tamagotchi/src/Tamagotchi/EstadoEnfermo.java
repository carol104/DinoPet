package Tamagotchi;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EstadoEnfermo extends Estado {

    private final Mensaje mensaje;

    public EstadoEnfermo() {
        mensaje = Mensaje.obtenerInstancia();
    }

    @Override
    protected void mostrarEstado(JLabel ubicacion) {
        demostracionDeEstado = Tamagotchi.obtenerImagen("/Tamagotchi/Imagenes/DinosaurioMalEstado/DinosaurioEnfermo.png");
        ubicacion.setIcon(demostracionDeEstado);
    }

    @Override
    protected void reaccionJugar() {
        mensaje.noQuieroJugar();
    }

    @Override
    protected void reaccionComer() {
        mensaje.noQuieroComer();
    }

    @Override
    protected void reaccionDormir() {
        mensaje.noQuieroDormir();
    }

    @Override
    protected void reaccionCurar() {
        quienDemuestraelEstado.curar();
    }

    @Override
    protected void reaccionAsear() {
        mensaje.noQuieroBaniarme();
    }

}
