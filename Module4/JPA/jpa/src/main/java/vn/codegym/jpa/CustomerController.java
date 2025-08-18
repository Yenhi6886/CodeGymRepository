package vn.codegym.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.codegym.jpa.model.Customer;
import vn.codegym.jpa.service.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String list(Model model, @RequestParam(value = "name", required = false, defaultValue = "") String name) {
        List<Customer> customers;
        if (name != null && !name.isEmpty()) {
            customers = customerService.findByName(name);
        } else {
            customers = customerService.findAll();
        }
        model.addAttribute("customers", customers);
        model.addAttribute("searchName", name);
        return "list";
    }

    // Create Customer
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/create")
    public String create(Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    // Update Customer
    @GetMapping("/edit")
    public String showEditForm(@RequestParam("id") Long id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Customer customer) {
        customerService.update(customer);
        return "redirect:/customers";
    }

    // Delete Customer
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        customerService.delete(id);
        return "redirect:/customers";
    }

}
