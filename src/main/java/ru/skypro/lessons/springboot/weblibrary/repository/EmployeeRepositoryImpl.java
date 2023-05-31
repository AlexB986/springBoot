package ru.skypro.lessons.springboot.weblibrary.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final static List<Employee> EMPLOYEE_LIST = List.of(
            new Employee("Катя", 90_000),
            new Employee("Дима", 102_000),
            new Employee("Олег", 80_000),
            new Employee("Вика", 165_000)
    );

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(EMPLOYEE_LIST);
    }

    @Override
    public int getAllEmployeeSumSalary() {
        int sum = 0;
        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
            sum += EMPLOYEE_LIST.get(i).getSalary();
        }

        return sum;
    }

    @Override
    public int getEmployeeMinSalary() {
        int min = getEmployeeMaxSalary();
        for (int i = 0; i < EMPLOYEE_LIST.size(); i++)
            if (EMPLOYEE_LIST.get(i).getSalary() < min) {
                min = EMPLOYEE_LIST.get(i).getSalary();
            }
        return min;
    }

    @Override
    public int getEmployeeMaxSalary() {
        int max = 0;
        for (int i = 0; i < EMPLOYEE_LIST.size(); i++)
            if (EMPLOYEE_LIST.get(i).getSalary() > max) {
                max = EMPLOYEE_LIST.get(i).getSalary();
            }
        return max;
    }

    @Override
    public int getEmployeeHighSalarySalary() {
        int midian = getEmployeeMaxSalary() / EMPLOYEE_LIST.size();

        return midian;
    }
}
