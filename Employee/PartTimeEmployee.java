class PartTimeEmployee extends Employee {
    
	private double paymentPerHour;

    public PartTimeEmployee() {
    }

    public PartTimeEmployee(int id, String name, double paymentPerHour) {
        super(id, name);
        this.paymentPerHour = paymentPerHour;
    }

    public void setPaymentPerHour(double paymentPerHour) {
        this.paymentPerHour = paymentPerHour;
    }

    public double getPaymentPerHour() {
        return paymentPerHour;
    }

    public void showPartTimeEmployeeInfo() {
        super.showEmployeeInfo();
        System.out.println("Employee Payment per Hour: " + paymentPerHour);
	}
	
	public void dailyIncome(int hour){
		System.out.println("Daily Income  :"+ paymentPerHour * hour);
	}
}