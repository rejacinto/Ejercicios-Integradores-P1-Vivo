package bootcamp;

import bootcamp.domain.*;
import bootcamp.exceptions.TrackerNotFoundException;
import bootcamp.repository.GenericRepositoryImp;
import bootcamp.repository.IGenericRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static IGenericRepository<Client> clientRepository = new GenericRepositoryImp<>();
    static IGenericRepository<Tracker> trackerRepository = new GenericRepositoryImp<>();
    static final double twoTrackersDiscount = 0.05;
    static final double completePackageDiscount = 0.1;
    static final double twoBookingsDiscount = 0.05;

    public static void main( String[] args )
    {
        Client client = new Client("Renzo", "Jacinto");
        Tracker tracker = new Tracker(client);
        tracker.addCompleteBooking(1500.0, 500.0, 2500.0, 300.0);

        trackerRepository.save(tracker, tracker.getId());
        clientRepository.save(client, client.getId());

        try {
            Tracker trackerFetched = trackerRepository.findById(tracker.getId()).orElseThrow(TrackerNotFoundException::new);
            System.out.println(trackerFetched);
        } catch (TrackerNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void calculateDiscountsAndShowResults() {
        for (Client client : clientRepository.findAll()){
            int clientId = client.getId();
            List<Tracker> trackersOfClient = trackerRepository.findAll().stream().filter(t -> t.getClient().getId() == clientId).collect(Collectors.toList());
            double initialTotal = trackersOfClient.stream().map(Tracker::getTotal).reduce(0.0, Double::sum);
            boolean hasTwoTrackersDiscount = false;
            boolean hasCompletePackageDiscount = false;
            boolean hasTwoBookingsDiscount = false;
            for (Tracker trackerOfClient : trackersOfClient) {
                if (trackerOfClient.hasCompleteTouristPackage()) {
                    hasCompletePackageDiscount = true;
                    break;
                }
            }
            double total = hasCompletePackageDiscount ? initialTotal * completePackageDiscount : initialTotal;
        }

    }

}
