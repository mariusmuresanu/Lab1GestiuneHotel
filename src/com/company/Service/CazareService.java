package com.company.Service;

import com.company.Domain.Cazare;
import com.company.Domain.RoomAverageRatingViewModel;
import com.company.Repository.CazareRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CazareService {
    private CazareRepository repository;

    public CazareService(CazareRepository repository) {
        this.repository = repository;
    }

    /**
     * @param id
     * @param nrPersoane
     * @param nrCamera
     * @param nrZile
     */
    public void enterCazare(int id, int nrPersoane, int nrCamera, int nrZile) {
        Cazare cazare = new Cazare(id, nrPersoane, nrCamera, nrZile);
        List<Cazare> cazari = repository.getAll();
        for (Cazare c : cazari) {
            if (c.getNrCmera() == nrCamera && !c.isLeftRoom()) {
                throw new RuntimeException("Camera este deja ocupata!");
            }
        }
        repository.add(cazare);
    }


    public void exitCazare(int nrCamera, String feedback, int rating) {
        Cazare cazarePeCamera = null;
        List<Cazare> cazari = repository.getAll();
        for (Cazare c : cazari) {
            if (c.getNrCmera() == nrCamera && !c.isLeftRoom()) ;
            {
                cazarePeCamera = c;
            }
        }
        if (cazarePeCamera != null) {
            cazarePeCamera.setFeedback(feedback);
            cazarePeCamera.setRating(rating);
            repository.update(cazarePeCamera);
        } else {
            throw new RuntimeException("Nu este o cazare activa pe camera respectiva");
        }
    }

    public List<RoomAverageRatingViewModel> getRoomRatingAverage() {
        List<RoomAverageRatingViewModel> results = new ArrayList<>();
        Map<Integer, List<Double>> ratingForRooms = new HashMap<>();

        for (Cazare c : repository.getAll()) {
            if (c.isLeftRoom()) {
                int nrCamera = c.getNrCmera();
                double rating = c.getRating();
                if (!ratingForRooms.containsKey(nrCamera)) {
                    ratingForRooms.put(nrCamera, new ArrayList<>());
                }
                ratingForRooms.get(nrCamera).add(rating);
            }
        }
        for (int nrCamera : ratingForRooms.keySet()) {
            List<Double> ratings = ratingForRooms.get(nrCamera);
            double average = 0;
            for (double r : ratings) {
                average += r;
            }
            average /= ratings.size();
            results.add(new RoomAverageRatingViewModel(nrCamera, average));
        }
            results.sort((r1, r2) -> {
                if (r1.getAverageRating() > r2.getAverageRating())
                    return -1;
                else if (r1.getAverageRating() == r2.getAverageRating())
                    return 0;
                else
                    return 1;
            });
            return results;

        }

    public List<Cazare> getAll() {
        return repository.getAll();
    }

}