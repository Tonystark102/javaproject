package com.manageyourresource.dto;

public class SalaryDetails {
	
   
	private int HouseRentAllowances;
	private int conveyanceAllowances;
	private int medicalAllowances;
	private int specialAllowances;
	private int grossSalary;
	private int tds;
	private int healthInsurance;
	private int netPay;
	private int totalDeduction;
	public int getHouseRentAllowances() {
		return HouseRentAllowances;
	}
	public void setHouseRentAllowances(int houseRentAllowances) {
		HouseRentAllowances = houseRentAllowances;
	}
	public int getConveyanceAllowances() {
		return conveyanceAllowances;
	}
	public void setConveyanceAllowances(int conveyanceAllowances) {
		this.conveyanceAllowances = conveyanceAllowances;
	}
	public int getMedicalAllowances() {
		return medicalAllowances;
	}
	public void setMedicalAllowances(int medicalAllowances) {
		this.medicalAllowances = medicalAllowances;
	}
	public int getSpecialAllowances() {
		return specialAllowances;
	}
	public void setSpecialAllowances(int specialAllowances) {
		this.specialAllowances = specialAllowances;
	}
	public int getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(int grossSalary) {
		this.grossSalary = grossSalary;
	}
	public int getTds() {
		return tds;
	}
	public void setTds(int tds) {
		this.tds = tds;
	}
	public int getHealthInsurance() {
		return healthInsurance;
	}
	public void setHealthInsurance(int healthInsurance) {
		this.healthInsurance = healthInsurance;
	}
	public int getNetPay() {
		return netPay;
	}
	public void setNetPay(int netPay) {
		this.netPay = netPay;
	}
	public int getTotalDeduction() {
		return totalDeduction;
	}
	public void setTotalDeduction(int totalDeduction) {
		this.totalDeduction = totalDeduction;
	}
	
	

}
