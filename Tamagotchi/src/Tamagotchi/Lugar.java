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
        escenarios.add(new ImageIcon("src\\Tamagotchi\\Imagenes\\Escenarios\\Sala.png"));

        escenarios.add(new ImageIcon("src\\Tamagotchi\\Imagenes\\Escenarios\\Comedor.png"));
        escenarios.add(new ImageIcon("src\\Tamagotchi\\Imagenes\\Escenarios\\salaVideojuegos.png"));
        escenarios.add(new ImageIcon("src\\Tamagotchi\\Imagenes\\Escenarios\\Enfermeria.png"));
        escenarios.add(new ImageIcon("src\\Tamagotchi\\Imagenes\\Escenarios\\Dormitorio.png"));
        escenarios.add(new ImageIcon("src\\Tamagotchi\\Imagenes\\Escenarios\\Banio.png"));
    }

    public List<ImageIcon> getEscenarios() {
        return escenarios;
    }

}
