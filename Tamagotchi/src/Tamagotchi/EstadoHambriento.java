package Tamagotchi;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EstadoHambriento extends Estado {

    private final Mensaje mensaje;

    public EstadoHambriento() {
        mensaje = Mensaje.obtenerInstancia();
    }

    @Override
    protected void mostrarEstado(JLabel ubicacion) {
        demostracionDeEstado = Tamagotchi.obtenerImagen("/Tamagotchi/Imagenes/DinosaurioMalEstado/DinosaurioHambriento.png");
        ubicacion.setIcon(demostracionDeEstado);
    }

    @Override
    protected void reaccionJugar() {
        mensaje.noQuieroJugar();
    }

    @Override
    protected void reaccionComer() {
        quienDemuestraelEstado.alimentar();
    }

    @Override
    protected void reaccionDormir() {
        mensaje.noQuieroDormir();
    }

    @Override
    protected void reaccionCurar() {
        mensaje.noQuieroQueMeCures();
    }

    @Override
    protected void reaccionAsear() {
        mensaje.noQuieroBaniarme();
    }

}
