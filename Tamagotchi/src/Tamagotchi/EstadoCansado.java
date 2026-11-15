package Tamagotchi;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EstadoCansado extends Estado {

    private final Mensaje mensaje;

    public EstadoCansado() {
        mensaje = Mensaje.obtenerInstancia();
    }

    @Override
    protected void mostrarEstado(JLabel ubicacion) {
        demostracionDeEstado = new ImageIcon("src\\Tamagotchi\\Imagenes\\DinosaurioMalEstado\\DinosaurioCansado.png");
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
    protected void reaccionCurar() {
        mensaje.noQuieroQueMeCures();
    }

    @Override
    protected void reaccionAsear() {
        mensaje.noQuieroBaniarme();
    }

    @Override
    protected void reaccionDormir() {
        quienDemuestraelEstado.dormir();
    }

}
