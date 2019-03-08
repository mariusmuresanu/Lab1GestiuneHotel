package com.company.Domain;

public class CazareValidator {

    /**
     *Valideaza o cazare
     * @param cazare
     * @throws RuntimeException if there are validation errors.
     */

public void validate(Cazare cazare){
    if (cazare.getNrZile() <=0 ){
        throw new RuntimeException("Numarul de zile trebuie sa fie pozitiv!");
    }
//    if (cazare.isLeftService() && car.getPrice() <= 0) {
//        throw new RuntimeException("Price must be positive!");
//    }

}
}
