package Tamagotchi;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EstadoNormal extends Estado {

    @Override
    protected void mostrarEstado(JLabel ubicacion) {
        demostracionDeEstado = new ImageIcon("src\\Tamagotchi\\Imagenes\\DinosauriosSala\\DinosaurioNormal.png");
        ubicacion.setIcon(demostracionDeEstado);
    }

    @Override
    protected void reaccionJugar() {
        quienDemuestraelEstado.jugar();
    }

    @Override
    protected void reaccionComer() {
        quienDemuestraelEstado.alimentar();
    }

    @Override
    protected void reaccionDormir() {
        quienDemuestraelEstado.dormir();
    }

    @Override
    protected void reaccionCurar() {
        quienDemuestraelEstado.curar();
    }

    @Override
    protected void reaccionAsear() {
        quienDemuestraelEstado.asear();
    }
}
