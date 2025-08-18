package com.codegym.healthdeclaration;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.List;

public class HealthDeclaration {
    @NotEmpty(message = "Họ tên không được để trống")
    private String fullName;

    @NotNull(message = "Vui lòng chọn năm sinh")
    private Integer yearOfBirth;

    private String gender;
    private String nationality;
    private String idNumber;
    private String vehicleType;
    private String vehicleId;
    private Integer seatNumber;
    private String startDate;
    private String endDate;
    private String visitedProvinces;

    @NotEmpty(message = "Địa chỉ không được để trống")
    private String address;

    private String phone;
    private String email;

    private List<String> symptoms;
    private List<String> exposures;

    public HealthDeclaration() {
    }

    public HealthDeclaration(String fullName, Integer yearOfBirth, String gender, String nationality, String idNumber, String vehicleType, String vehicleId, Integer seatNumber, String startDate, String endDate, String visitedProvinces, String address, String phone, String email, List<String> symptoms, List<String> exposures) {
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.idNumber = idNumber;
        this.vehicleType = vehicleType;
        this.vehicleId = vehicleId;
        this.seatNumber = seatNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.visitedProvinces = visitedProvinces;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.symptoms = symptoms;
        this.exposures = exposures;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getVisitedProvinces() {
        return visitedProvinces;
    }

    public void setVisitedProvinces(String visitedProvinces) {
        this.visitedProvinces = visitedProvinces;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    public List<String> getExposures() {
        return exposures;
    }

    public void setExposures(List<String> exposures) {
        this.exposures = exposures;
    }
}
