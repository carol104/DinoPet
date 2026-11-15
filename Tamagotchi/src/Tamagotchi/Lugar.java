package Tamagotchi;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Lugar {

    private List<ImageIcon> escenarios;

    public Lugar() {
        escenarios = new ArrayList<>();
        cargarImagenes();
    }

  
    private void cargarImagenes() {
        escenarios.add(Tamagotchi.obtenerImagen("/Tamagotchi/Imagenes/Escenarios/Sala.png"));
        escenarios.add(Tamagotchi.obtenerImagen("/Tamagotchi/Imagenes/Escenarios/Comedor.png"));
        escenarios.add(Tamagotchi.obtenerImagen("/Tamagotchi/Imagenes/Escenarios/salaVideojuegos.png"));
        escenarios.add(Tamagotchi.obtenerImagen("/Tamagotchi/Imagenes/Escenarios/enfermeria.png"));
        escenarios.add(Tamagotchi.obtenerImagen("/Tamagotchi/Imagenes/Escenarios/Dormitorio.png"));
        escenarios.add(Tamagotchi.obtenerImagen("/Tamagotchi/Imagenes/Escenarios/Banio.png"));
    }

    public List<ImageIcon> getEscenarios() {
        return escenarios;
    }

}
