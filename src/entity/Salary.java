package entity;

public class Salary {
	private String id;
	private String empId;
	private String trueName;
	private String year;
	private String month;
	private double baseSalary;  //基本工资
	private double finalSalary;  //实发工资
	private double lateCome;   //迟到罚款
	private double earlyLeave;  //早退罚款
	private double leave;      //请假罚款
	private double overtime;   //加班奖金
	private double negletwork;  //旷工罚金
	private double old;           //养老保险
	private double unemployment;  //失业保险
	private double injury;         //工伤保险
	private double bear;            //生育保险
	private double medical;       //医疗保险
	private double house;          //公积金
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	public double getFinalSalary() {
		return finalSalary;
	}
	public void setFinalSalary(double finalSalary) {
		this.finalSalary = finalSalary;
	}
	public double getLateCome() {
		return lateCome;
	}
	public void setLateCome(double lateCome) {
		this.lateCome = lateCome;
	}
	public double getEarlyLeave() {
		return earlyLeave;
	}
	public void setEarlyLeave(double earlyLeave) {
		this.earlyLeave = earlyLeave;
	}
	public double getLeave() {
		return leave;
	}
	public void setLeave(double leave) {
		this.leave = leave;
	}
	public double getOvertime() {
		return overtime;
	}
	public void setOvertime(double overtime) {
		this.overtime = overtime;
	}
	public double getNegletwork() {
		return negletwork;
	}
	public void setNegletwork(double negletwork) {
		this.negletwork = negletwork;
	}
	public double getOld() {
		return old;
	}
	public void setOld(double old) {
		this.old = old;
	}
	public double getUnemployment() {
		return unemployment;
	}
	public void setUnemployment(double unemployment) {
		this.unemployment = unemployment;
	}
	public double getInjury() {
		return injury;
	}
	public void setInjury(double injury) {
		this.injury = injury;
	}
	public double getBear() {
		return bear;
	}
	public void setBear(double bear) {
		this.bear = bear;
	}
	public double getMedical() {
		return medical;
	}
	public void setMedical(double medical) {
		this.medical = medical;
	}
	public double getHouse() {
		return house;
	}
	public void setHouse(double house) {
		this.house = house;
	}
	

	
	
}
