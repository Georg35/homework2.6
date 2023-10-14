package pro.sky.homework26.service;

import org.springframework.stereotype.Service;
import pro.sky.homework26.employee.Employee;
import pro.sky.homework26.exception.EmployeeAlreadyAddedException;
import pro.sky.homework26.exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employeelist;

    public EmployeeServiceImpl() {
        this.employeelist = new ArrayList<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeelist.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeelist.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeelist.contains(employee)) {
            employeelist.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeelist.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employeelist);
    }
}
