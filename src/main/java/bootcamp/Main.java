package bootcamp;

import bootcamp.domain.*;
import bootcamp.domain.booking.FoodBooking;
import bootcamp.domain.booking.HotelBooking;
import bootcamp.repository.GenericRepositoryImp;
import bootcamp.repository.IGenericRepository;
import bootcamp.service.BillServiceImp;
import bootcamp.service.IBillService;
import bootcamp.service.ITrackerService;
import bootcamp.service.TrackerServiceImp;

import java.util.Arrays;

public class Main {

    static IGenericRepository<Client> clientRepository = new GenericRepositoryImp<>();
    static IGenericRepository<Tracker> trackerRepository = new GenericRepositoryImp<>();
    static IGenericRepository<Bill> billRepository = new GenericRepositoryImp<>();

    public static void main( String[] args )
    {
        Client client = new Client("Renzo", "Jacinto");
        Client client23 = new Client("Renzo11", "Jacinto11");
        Tracker tracker1 = new Tracker(client);
        tracker1.addCompleteBooking(1500, 500, 2500, 300);

        Tracker tracker2 = new Tracker(Arrays.asList(
                new HotelBooking(2000),
                new FoodBooking(300)
        ), client);

        Tracker tracker3 = new Tracker(Arrays.asList(
                new HotelBooking(2000),
                new FoodBooking(1000)
        ), client);

        clientRepository.save(client);
        trackerRepository.save(tracker1);
        trackerRepository.save(tracker2);
        trackerRepository.save(tracker3);

        System.out.println(trackerRepository.findAll());

        ITrackerService trackerService = new TrackerServiceImp(clientRepository, trackerRepository);

        trackerService.calculateDiscountsAndShowResults();

        System.out.println("Cantidad de localizadores vendidos: " + trackerService.getAmountOfTrackersSold());
        System.out.println("Cantidad total de reservas: " + trackerService.getAmountOfBookings());
        System.out.println("Reservas categorizadas por tipo: " + trackerService.getBookingsByType());
        System.out.println("Total de ventas: $" + trackerService.getTotalOfSales());
        System.out.println("Promedio de todas las ventas: $" + trackerService.getAvgOfSales());

        System.out.println(clientRepository.findAll());

        clientRepository.update(new Client(client.getId(), "Rodolfo", "Gutierrez"), client.getId());
        System.out.println("Cliente modificado: " + clientRepository.findById(client.getId()));
        Client deletedClient = clientRepository.deleteById(client.getId());
        System.out.println("Cliente eliminado: " + deletedClient);
        System.out.println("Listado de clientes luego de eliminarlo: " + clientRepository.findAll());

        IBillService billService = new BillServiceImp(billRepository, clientRepository);
        Client client2 = new Client("Fulano", "Mengano");
        Bill bill = new Bill(client2);
        billService.addBill(bill);
        System.out.println("Lista de facturas: " + billRepository.findAll());
    }

}
