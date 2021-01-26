package guru.springframework.controllers;

import guru.springframework.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
    CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/customers")
    public String getCustomerList(Model model) {
        model.addAttribute("customers", customerService.getCustomerList());

        return "customerlist";
    }

    @RequestMapping("/customer/{id}")
    public String getCustomerDetailById(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));

        return "customer";
    }
}
