package Tamagotchi;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EstadoAburrido extends Estado {

    private final Mensaje mensaje;
    
      public EstadoAburrido() {
        mensaje = Mensaje.obtenerInstancia();
    }


    @Override
    protected void mostrarEstado(JLabel ubicacion) {
        demostracionDeEstado = new ImageIcon("src\\Tamagotchi\\Imagenes\\DinosaurioMalEstado\\DinosaurioAburrido.png");
        ubicacion.setIcon(demostracionDeEstado);

    }

    @Override
    protected void reaccionJugar() {
        quienDemuestraelEstado.jugar();
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
        mensaje.noQuieroQueMeCures();
    }

    @Override
    protected void reaccionAsear() {
        mensaje.noQuieroBaniarme();
    }

}
