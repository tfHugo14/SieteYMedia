package sieteymedia;

import recursos.Baraja;
import recursos.Carta;

public class SieteYMedia {
    Baraja baraja;
    Carta[] cartasJugador;
    Carta[] cartasBanca;

    void jugar() {
        baraja = new Baraja();
        baraja.barajar();
        cartasJugador = new Carta[15];
        cartasBanca = new Carta[15];
    }

    void turnoJugador() {
        Carta c = baraja.darCartas(1)[0];
        // insertamos c en las cartas del jugador
        insertarCartaEnArray(cartasJugador, c);
    }

    void turnoBanca() {
        // lo primero es consultar el valor que alcanzó el jugador en su turno
        double valorCartasJugador = valorCartas(cartasJugador);
        // juega hasta empatar o superar
        while (valorCartas(cartasBanca) < valorCartasJugador) {
            Carta c = baraja.darCartas(1)[0];
            insertarCartaEnArray(cartasBanca, c);
        }
    }

    double valorCartas(Carta[] cartas) {
        double total = 0.0;
        int val;
        int i = 0;
        while (cartas[i] != null) {
            val = cartas[i].getNumero();
            total += (val > 7) ? 0.5 : val;
            i++;
        }
        return total;
    }

    void insertarCartaEnArray(Carta[] cartas, Carta c) {
        // inserta al final detectando el primer null
        int i = 0;
        while (cartas[i] != null) {
            i++;
        }
        cartas[i] = c;
    }
}
