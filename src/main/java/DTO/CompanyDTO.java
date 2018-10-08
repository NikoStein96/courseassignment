package DTO;

import entity.Company;
import java.util.List;

public class CompanyDTO {

    private Long id;
    private String name;
    private String description;
    private int cvr;
    private int numEmployees;
    private int marketValue;

    public CompanyDTO(Company company) {
        this.name = company.getName();
        this.description = company.getDescription();
        this.cvr = company.getCvr();
        this.numEmployees = company.getNumEmployees();
        this.marketValue = company.getMarketValue();
    }

    public CompanyDTO(Long id, String name, String description, int cvr, int numEmployees, int marketValue) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cvr = cvr;
        this.numEmployees = numEmployees;
        this.marketValue = marketValue;
    }

    public CompanyDTO(String name, String description, int cvr, int numEmployees, int marketValue) {
        this.name = name;
        this.description = description;
        this.cvr = cvr;
        this.numEmployees = numEmployees;
        this.marketValue = marketValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCvr() {
        return cvr;
    }

    public void setCvr(int cvr) {
        this.cvr = cvr;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(int numEmployees) {
        this.numEmployees = numEmployees;
    }

    public int getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(int marketValue) {
        this.marketValue = marketValue;
    }

}
