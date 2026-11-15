package Tamagotchi;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Estado {

    protected ImageIcon demostracionDeEstado;
    protected Tamagotchi quienDemuestraelEstado;

    public Estado() {
        quienDemuestraelEstado = Tamagotchi.obtenerInstancia();
    }

    protected void mostrarEstado(JLabel ubicacion) {
        ubicacion.setIcon(demostracionDeEstado);
    }

    protected abstract void reaccionJugar();

    protected abstract void reaccionComer();

    protected abstract void reaccionDormir();

    protected abstract void reaccionCurar();

    protected abstract void reaccionAsear();

}
