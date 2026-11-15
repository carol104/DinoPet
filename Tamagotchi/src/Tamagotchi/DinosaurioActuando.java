package Tamagotchi;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class DinosaurioActuando {

   
    private List<ImageIcon> dinosaurios;

    public DinosaurioActuando() {
        dinosaurios = new ArrayList<>();
        // Cargar automáticamente las imágenes al instanciar la clase
        cargarImagenes();
    }

 
    private void cargarImagenes() {
        //dinosaurio bebe
        //0
        dinosaurios.add(new ImageIcon("src\\Tamagotchi\\Imagenes\\DinosauriosSala\\DinosaurioBebe.png"));
        //1
        dinosaurios.add(new ImageIcon("src\\Tamagotchi\\Imagenes\\DinosaurioHaciendoAlgo\\DinosaurioComiendo.png"));
        //2
        dinosaurios.add(new ImageIcon("src\\Tamagotchi\\Imagenes\\DinosaurioHaciendoAlgo\\DinosaurioJugando.png"));
        //3
        dinosaurios.add(new ImageIcon("src\\Tamagotchi\\Imagenes\\DinosaurioHaciendoAlgo\\DinosaurioRecuperandose.png"));
        //4
        dinosaurios.add(new ImageIcon("src\\Tamagotchi\\Imagenes\\DinosaurioHaciendoAlgo\\DinosaurioDormido.png"));
        //5
        dinosaurios.add(new ImageIcon("src\\Tamagotchi\\Imagenes\\DinosaurioHaciendoAlgo\\DinosaurioBaniandose.png"));
       
      
    }

    public List<ImageIcon> getDinosaurios() {
        return dinosaurios;
    }
}
