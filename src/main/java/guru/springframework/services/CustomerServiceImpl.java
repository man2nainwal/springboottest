package guru.springframework.services;

import guru.springframework.domain.BaseCustomer;
import guru.springframework.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<Integer, Customer> customerMap = new HashMap<>();

    public CustomerServiceImpl() {
        loadCustomer();
    }

    private void loadCustomer() {
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("Manoj");
        customer1.setLastName("Nainwal");
        customer1.setAddress("Ramnagar");
        customer1.setCity("Nainital");
        customer1.setState("Uttarakhand");
        customer1.setEmail("manoj92nainwal@gmail.com");
        customer1.setPhoneNumber("9933994348");
        customerMap.put(1, customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setFirstName("Bhisham");
        customer2.setLastName("Kumar");
        customer2.setAddress("Arwal");
        customer2.setCity("Patna");
        customer2.setState("Bihar");
        customer2.setEmail("bhisham.kumar@gmail.com");
        customer2.setPhoneNumber("1122113344");
        customerMap.put(2, customer2);

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setFirstName("Dhiman");
        customer3.setLastName("Mandal");
        customer3.setAddress("Bakura");
        customer3.setCity("Steel city");
        customer3.setState("WB");
        customer3.setEmail("heyDmanl@gmail.com");
        customer3.setPhoneNumber("9911991199");
        customerMap.put(3, customer3);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerMap.get(id);
    }

    @Override
    public List<BaseCustomer> getCustomerList() {
        List<BaseCustomer> baseCustomerList = new ArrayList<>();
        for(Integer key : customerMap.keySet()) {
            Customer temp = customerMap.get(key);
            BaseCustomer customer = new BaseCustomer();
            customer.setEmail(temp.getEmail());
            customer.setFirstName(temp.getFirstName());
            customer.setId(temp.getId());;
            customer.setLastName(temp.getLastName());
            baseCustomerList.add(customer);
        }
        return baseCustomerList;
    }

    @Override
    public Customer insertOrUpdateCustomer(Customer customer) {
        if(null == customer) {
            if (null != customer.getId()) {
                customer.setId(giveNextNum());
            }
            customerMap.put(customer.getId(), customer);
        } else {
            throw new RuntimeException("Customer information is null");
        }

        return customer;
    }

    private Integer giveNextNum () {
        return Collections.max(customerMap.keySet()) + 1;
    }
}
