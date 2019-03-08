package com.company.Domain;

public class Cazare {
    private int id, nrPersoane, nrCamera,nrZile;
    private boolean leftRoom;
    private String feedback;
    private int rating;


    @Override
    public String toString() {
        return "Cazare{" +
                "id=" + id +
                ", nrPersoane=" + nrPersoane +
                ", nrCamera=" + nrCamera +
                ", nrZile=" + nrZile +
                ", leftRoom=" + leftRoom +
                ", feedback='" + feedback + '\'' +
                ", rating=" + rating +
                '}';
    }

    public Cazare(int id, int nrPersoane, int nrCamera, int nrZile) {
        this.id = id;
        this.nrPersoane = nrPersoane;
        this.nrCamera = nrCamera;
        this.nrZile = nrZile;
    }

    public Cazare(int id, int nrPersoane, int nrCamera, int nrZile, boolean leftRoom, String feedback, int rating) {
        this.id = id;
        this.nrPersoane = nrPersoane;
        this.nrCamera = nrCamera;
        this.nrZile = nrZile;
        this.leftRoom = leftRoom;
        this.feedback = feedback;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNrPersoane() {
        return nrPersoane;
    }

    public void setNrPersoane(int nrPersoane) {
        this.nrPersoane = nrPersoane;
    }

    public int getNrCmera() {
        return nrCamera;
    }

    public void setNrCmera(int nrCmera) {
        this.nrCamera = nrCmera;
    }

    public int getNrZile() {
        return nrZile;
    }

    public void setNrZile(int nrZile) {
        this.nrZile = nrZile;
    }

    public boolean isLeftRoom() {
        return leftRoom;
    }

    public void setLeftRoom(boolean leftRoom) {
        this.leftRoom = leftRoom;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
