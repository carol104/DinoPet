package Tamagotchi;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Tamagotchi {

    private static Tamagotchi instancia;
    protected Estado estadoActual;
    protected boolean estadoPuedeCambiar;

    private int nivel_hambre;
    private int nivel_felicidad;
    private int nivel_suenio;
    private int nivel_limpieza;
    private int nivel_salud;

    private Tamagotchi() {
        // Inicialización de los atributos
        nivel_hambre = 0;
        nivel_felicidad = 100;
        nivel_suenio = 0;
        nivel_limpieza = 100;
        nivel_salud = 100;
        estadoPuedeCambiar = false;
    }

    public static Tamagotchi obtenerInstancia() {
        // Si la instancia no ha sido creada aún, se crea
        if (instancia == null) {
            instancia = new Tamagotchi();
        }
        // Se devuelve la instancia existente
        return instancia;
    }

    public int getNivel_hambre() {
        return nivel_hambre;
    }

    public int getNivel_felicidad() {
        return nivel_felicidad;
    }

    public int getNivel_suenio() {
        return nivel_suenio;
    }

    public int getNivel_limpieza() {
        return nivel_limpieza;
    }

    public int getNivel_salud() {
        return nivel_salud;
    }

    public void alimentar() {
        nivel_hambre -= 5;
        if (nivel_hambre < 0) {
            nivel_hambre = 0;
        }
        nivel_felicidad += 2; // Alimentar aumenta la salud
        if (nivel_felicidad > 100) {
            nivel_felicidad = 100;
        }
        nivel_limpieza -= 2; // Alimentar puede aumentar la limpieza
        if (nivel_limpieza < 0) {
            nivel_limpieza = 0;
        }
    }

    public void jugar() {

        nivel_felicidad += 5;
        if (nivel_felicidad > 100) {
            nivel_felicidad = 100;
        }
        nivel_limpieza -= 1; // Jugar puede disminuir la limpieza
        if (nivel_limpieza < 0) {
            nivel_limpieza = 0;
        }

        nivel_hambre += 1; // Jugar puede dar más hambre
        if (nivel_hambre > 100) {
            nivel_hambre = 100;
        }
    }

    public void dormir() {
        nivel_suenio -= 5;
        if (nivel_suenio < 0) {
            nivel_suenio = 0;
        }
        nivel_salud += 3;
        if (nivel_salud > 100) {
            nivel_salud = 100;
        }
    }

    public void asear() {
        nivel_limpieza += 3;
        if (nivel_limpieza < 0) {
            nivel_limpieza = 0;
        }
        nivel_salud += 2;
        if (nivel_salud > 100) {
            nivel_salud = 100;
        }
    }

    public void curar() {
        nivel_salud += 3;
        if (nivel_salud > 100) {
            nivel_salud = 100;
        }

        nivel_felicidad += 3;
        if (nivel_felicidad > 100) {
            nivel_felicidad = 100;
        }
    }

    public Estado getEstadoActual() {
        return this.estadoActual;
    }

    public void setEstadoActual(Estado estadoActual) {
        this.estadoActual = estadoActual;
    }

    public boolean debeCambiarEstado() {
        return estadoPuedeCambiar;
    }

    public void setEstadoPuedeCambiar(boolean estadoPuedeCambiar) {
        this.estadoPuedeCambiar = estadoPuedeCambiar;
    }

    public void desgasteNatural() {
        nivel_hambre += 2;
        if (nivel_hambre > 100) {
            nivel_hambre = 100;
        }
        nivel_suenio += 2;
        if (nivel_suenio > 100) {
            nivel_suenio = 100;
        }
        nivel_salud -= 2;
        if (nivel_salud < 0) {
            nivel_salud = 0;
        }
        nivel_felicidad -= 2;
        if (nivel_felicidad < 0) {
            nivel_felicidad = 0;
        }
        nivel_limpieza -= 2;
        if (nivel_limpieza < 0) {
            nivel_limpieza = 0;
        }

    }

    public int nivelPrioritarioMinimo() {
        // Obtener el nivel más bajo entre salud, limpieza y felicidad
        int nivelMasBajo = Math.min(Math.min(getNivel_salud(), getNivel_limpieza()), getNivel_felicidad());
        return nivelMasBajo;

        // Verificar si el nivel más bajo está más alejado de 100 que el nivel más alto
    }

    public int nivelPriotitarioMaximo() {
        int nivelMasAlto = Math.max(getNivel_hambre(), getNivel_suenio());
        return nivelMasAlto;
    }

    public int distanciadelMaximo() {
        return 100 - nivelPriotitarioMaximo();
    }

    public int nivelPrioritario() {
        if (nivelPrioritarioMinimo() < distanciadelMaximo()) {
            return nivelPrioritarioMinimo();
        } else {
            return nivelPriotitarioMaximo();
        }
    }

    public void cambiarDeEstado(JLabel ubicacion) {
        // Obtener el nivel prioritario
        int nivelPrioritario = nivelPrioritario();

        // Verificar si el estado actual del Tamagotchi debe cambiar
        // Si es así, obtener el estado actual del verificador
        VerificadorEstados verificador = new VerificadorEstados();
        this.setEstadoActual(verificador.identificarEstado(nivelPrioritario));

        // Mostrar el estado actual del Tamagotchi en la ubicación especificada
        estadoActual.mostrarEstado(ubicacion);

        // Si no es necesario cambiar el estado, simplemente mostrar el estado actual
        estadoActual.mostrarEstado(ubicacion);
    }

    public void muerte(Timer tiempo, JFrame frame) {
        if (nivel_limpieza == 0 && nivel_felicidad == 0 && nivel_salud == 0 && nivel_hambre == 100 && nivel_suenio == 100) {
            frame.setVisible(false);
            tiempo.stop();
            Muerte.mostrarMuerte();
        }
    }

    public static javax.swing.ImageIcon obtenerImagen(String ruta) {
        java.net.URL url = Tamagotchi.class.getResource(ruta);
        if (url != null) {
            return new javax.swing.ImageIcon(url);
        }
        String cleanPath = ruta.startsWith("/") ? ruta.substring(1) : ruta;
        java.io.File f = new java.io.File(cleanPath);
        if (f.exists()) return new javax.swing.ImageIcon(f.getAbsolutePath());
        f = new java.io.File("src/" + cleanPath);
        if (f.exists()) return new javax.swing.ImageIcon(f.getAbsolutePath());
        f = new java.io.File("Tamagotchi/src/" + cleanPath);
        if (f.exists()) return new javax.swing.ImageIcon(f.getAbsolutePath());
        f = new java.io.File("Tamagotchi/" + cleanPath);
        if (f.exists()) return new javax.swing.ImageIcon(f.getAbsolutePath());
        return new javax.swing.ImageIcon();
    }

    public static void main(String[] args) {
        Nacimiento.main(args);
    }
}
