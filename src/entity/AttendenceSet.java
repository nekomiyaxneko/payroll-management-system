package entity;

public class AttendenceSet {
	private String id;
	private double lateCome;   //³Ùµ½·£¿î
	private double earlyLeave;  //ÔçÍË·£¿î
	private double leave;   //Çë¼Ù·£¿î
	private double overtime;
	private double negletwork;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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

	
}
