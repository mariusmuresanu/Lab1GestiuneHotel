package com.company.Domain;

public class RoomAverageRatingViewModel {
    private int nrCamera;
    private double averageRating;

    @Override
    public String toString() {
        return "RoomAverageRatingViewModel{" +
                "nrCamera=" + nrCamera +
                ", averageRating=" + averageRating +
                '}';
    }

    public int getNrCamera() {
        return nrCamera;
    }

    public void setNrCamera(int nrCamera) {
        this.nrCamera = nrCamera;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public RoomAverageRatingViewModel(int nrCamera, double averageRating) {
        this.nrCamera = nrCamera;
        this.averageRating = averageRating;
    }
}
