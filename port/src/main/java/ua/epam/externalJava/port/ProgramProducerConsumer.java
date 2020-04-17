package ua.epam.externalJava.port;

import ua.epam.externalJava.port.ports.Mooring;
import ua.epam.externalJava.port.ports.Port;
import ua.epam.externalJava.port.ships.Ship;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProgramProducerConsumer {
    public static void main(String[] args) {
        System.out.println("Available number of cores: " +
                Runtime.getRuntime().availableProcessors());

        Port portOdesa = new Port("Odesa");
        portOdesa.setContainersCapacity(1000);
        portOdesa.setContainersQuantity(50);
        Mooring mooring1 = new Mooring(portOdesa);
        Mooring mooring2 = new Mooring(portOdesa);
        Mooring mooring3 = new Mooring(portOdesa);
        Ship ship1 = new Ship("Kherson",300);
        ship1.load(300);
        ship1.setPort(portOdesa);
        Ship ship2 = new Ship("Zaporizhja",500);
        ship2.load(450);
        ship2.setPort(portOdesa);
        Ship ship3 = new Ship("Berdiansk",200);
        ship3.load(190);
        ship3.setPort(portOdesa);
        Ship ship11 = new Ship("Kherson2",600);
        ship11.load(600);
        ship11.setPort(portOdesa);
        Ship ship12 = new Ship("Zaporizhja2",1200);
        ship12.load(1200);
        ship12.setPort(portOdesa);
        Ship ship13 = new Ship("Berdiansk2",200);
        ship13.load(190);
        ship13.setPort(portOdesa);

//        new Thread(mooring1).start();
//        new Thread(mooring2).start();
//        new Thread(mooring3).start();
//        new Thread(ship1).start();
//        new Thread(ship2).start();
//        new Thread(ship3).start();
//        new Thread(ship11).start();
//        new Thread(ship12).start();
//        new Thread(ship13).start();


        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(mooring1);
        service.execute(mooring2);
        service.execute(mooring3);
        service.execute(ship1);
        service.execute(ship2);
        service.execute(ship3);
        service.execute(ship11);
        service.execute(ship12);
        service.execute(ship13);

        service.shutdown();
    }
}
