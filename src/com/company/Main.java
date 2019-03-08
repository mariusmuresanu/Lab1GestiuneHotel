package com.company;

import com.company.Domain.CazareValidator;
import com.company.Repository.CazareRepository;
import com.company.Service.CazareService;
import com.company.UI.Console;

public class Main {

    public static void main(String[] args) {


        CazareValidator validator = new CazareValidator();
        CazareRepository repository = new CazareRepository(validator);
        CazareService service = new CazareService(repository);

        service.enterCazare(1,2,14,4);
        service.enterCazare(2,3,11,2);

        Console console = new Console(service);
        console.run();

	// write your code here
    }
}
