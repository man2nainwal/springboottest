package guru.springframework.services;

import guru.springframework.domain.BaseCustomer;
import guru.springframework.domain.Customer;

import java.util.List;

public interface CustomerService {

    public Customer getCustomerById(Integer id);

    public List<BaseCustomer> getCustomerList();

    public Customer insertOrUpdateCustomer(Customer customer);
}
