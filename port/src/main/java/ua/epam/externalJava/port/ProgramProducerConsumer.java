package ua.epam.externalJava.port;

import ua.epam.externalJava.port.ports.Port;
import ua.epam.externalJava.port.ships.Ship;

public class ProgramProducerConsumer {
    public static void main(String[] args) {

        Port portOdessa = new Port("Odessa", 2);
        portOdessa.setContainersCapacity(1000);
        portOdessa.setContainersQuantity(50);
        Ship ship1 = new Ship("Kherson",300);
        ship1.load(300);
        ship1.setPort(portOdessa);
        Ship ship2 = new Ship("Zaporizhja",500);
        ship2.load(450);
        ship2.setPort(portOdessa);
        Ship ship3 = new Ship("Berdiansk",200);
        ship3.load(190);
        ship3.setPort(portOdessa);

        new Thread(ship1).start();
        new Thread(ship2).start();
        new Thread(ship3).start();
    }
}
