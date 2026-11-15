package Tamagotchi;

public class VerificadorEstados {

    private static Tamagotchi tamagotchi;
    protected Estado estado;

    public VerificadorEstados() {
        tamagotchi = Tamagotchi.obtenerInstancia();
        estado = new EstadoNormal();
    }

    public Estado identificarEstado(int nivelPrioritario) {

        if (estaHambriento() && nivelPrioritario == tamagotchi.getNivel_hambre()) {
            estado = new EstadoHambriento();
            return estado;
        } else if (estaCansado() && nivelPrioritario == tamagotchi.getNivel_suenio()) {
            estado = new EstadoCansado();
            return estado;
        } else if (estaEnfermo() && nivelPrioritario == tamagotchi.getNivel_salud()) {
            estado = new EstadoEnfermo();
            return estado;
        } else if (estaAburrido() && nivelPrioritario == tamagotchi.getNivel_felicidad()) {
            estado = new EstadoAburrido();
            return estado;
        } else if (estaSucio() && nivelPrioritario == tamagotchi.getNivel_limpieza()) {
            estado = new EstadoSucio();
            return estado;
        } else {
            return estado;

        }
    }


    public boolean estaAburrido() {
        return tamagotchi.getNivel_felicidad() < 30;

    }

    public boolean estaHambriento() {

        return tamagotchi.getNivel_hambre() > 70;

    }

    public boolean estaEnfermo() {
        return tamagotchi.getNivel_salud() < 30;

    }

    public boolean estaSucio() {
        return tamagotchi.getNivel_limpieza() < 30;
    }

    public boolean estaCansado() {
        return tamagotchi.getNivel_suenio() > 70;
    }


}
