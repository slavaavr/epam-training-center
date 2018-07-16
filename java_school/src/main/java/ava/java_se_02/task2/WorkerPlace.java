package ava.java_se_02.task2;

import java.util.Arrays;
import java.util.List;

public class WorkerPlace {
    private Employee employee;
    private List<Chancery> chanceries;

    public WorkerPlace(Employee employee, Chancery... chanceries) {
        this.employee = employee;
        this.chanceries = Arrays.asList(chanceries);
    }

    public int entireCostOfChancery() {
        return chanceries.stream().mapToInt(Chancery::getPrice).sum();
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Chancery> getChanceries() {
        return chanceries;
    }

    public void setChanceries(List<Chancery> chanceries) {
        this.chanceries = chanceries;
    }

}
