package Tamagotchi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class BarrasEstado extends JPanel {

    private JProgressBar barraHambre;
    private JProgressBar barraFelicidad;
    private JProgressBar barraSuenio;
    private JProgressBar barraLimpieza;
    private JProgressBar barraSalud;

    public BarrasEstado() {
        inicializarComponentes();
        organizarComponentesDeBarra();
    }

    private void inicializarComponentes() {
        setLayout(new GridBagLayout());

        barraHambre = crearBarra();
        barraFelicidad = crearBarra();
        barraSuenio = crearBarra();
        barraLimpieza = crearBarra();
        barraSalud = crearBarra();
    }

    private void organizarComponentesDeBarra() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        aniadirBarradeProgreso("Hambre: ", barraHambre, gbc);
        aniadirBarradeProgreso("Felicidad: ", barraFelicidad, gbc);
        aniadirBarradeProgreso("Sueño: ", barraSuenio, gbc);
        aniadirBarradeProgreso("Limpieza: ", barraLimpieza, gbc);
        aniadirBarradeProgreso("Salud: ", barraSalud, gbc);
    }

    private void aniadirBarradeProgreso(String texto, JProgressBar barra, GridBagConstraints gbc) {
        gbc.gridy++; 
        gbc.gridx = 0; 
        add(new JLabel(texto), gbc);
        gbc.gridx = 1; 
        add(barra, gbc);
    }

    private JProgressBar crearBarra() {
        JProgressBar barraProgreso = new JProgressBar();
        barraProgreso.setPreferredSize(new Dimension(200, 30));
        barraProgreso.setStringPainted(true);
        barraProgreso.setForeground(Color.BLACK);
        return barraProgreso;
    }

    public void actualizarBarras(int nivelHambre, int nivelSuenio, int nivelFelicidad, int nivelSalud, int nivelLimpieza) {
        barraHambre.setValue(nivelHambre);
        barraFelicidad.setValue(nivelFelicidad);
        barraSuenio.setValue(nivelSuenio);
        barraLimpieza.setValue(nivelLimpieza);
        barraSalud.setValue(nivelSalud);
    }
}
