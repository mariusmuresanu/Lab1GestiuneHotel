package com.company.UI;

import com.company.Domain.Cazare;
import com.company.Domain.RoomAverageRatingViewModel;
import com.company.Service.CazareService;

import java.util.Scanner;

public class Console {

    private CazareService service;
    private Scanner scanner;


    public Console(CazareService Scanner) {
        this.service = service;
        scanner = new Scanner(System.in);
    }


    private void showMenu() {
        System.out.println("1. Intrare in cazare");
        System.out.println("2. Iesire din cazare");
        System.out.println("3. Raport rating camere");
        System.out.println("a. Afisare toate cazarie");
        System.out.println("x. Iesire");
    }

    public void run() {

        while (true) {
            showMenu();
            String option = scanner.nextLine();
            if (option.equals("1")) {
                handleCheckin();
            } else if (option.equals("2")) {
                handleCheckout();
            } else if (option.equals("3")) {
                handleRoomRating();
            } else if (option.equals("a")) {
                handleShowAll();
            } else if (option.equals("x")) {
                break;
            }
        }
    }

    private void handleRoomRating() {
        for (RoomAverageRatingViewModel roomAverage : service.getRoomRatingAverage())
            System.out.println(roomAverage);
    }

    private void handleCheckout() {
        try {
            System.out.println("Dati numarul camerei:");
            int nrCamera = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati un feedback");
            String feedback = scanner.nextLine();
            System.out.println("Dati ratingul camerei");
            int rating = Integer.parseInt(scanner.nextLine());
            service.exitCazare(nrCamera, feedback, rating);
        } catch (RuntimeException runtimeException) {
            System.out.println("Avem erori: " + runtimeException.getMessage());
        }
    }

    private void handleShowAll() {
        for (Cazare c : service.getAll())
            System.out.println(c);
    }

    private void handleCheckin() {

        try {
            System.out.println("Dati id-ul:");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati camera:");
            int nrCamera = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati numarul de persoane:");
            int nrPersoane = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati numarul de zile:");
            int nrZile = Integer.parseInt(scanner.nextLine());

            service.enterCazare(id, nrCamera, nrPersoane, nrZile);
        } catch (RuntimeException runtimeException) {
            System.out.println("Avem erori: " + runtimeException.getMessage());
        }
    }
}
