package department;

public enum Allocation {
	DEVELOPER(1000.0),QA(500.0),MANAGER(300.0);
	
	private Double allocAmt;
	
	private Allocation(Double allocAmt){
		this.allocAmt = allocAmt;
	}
	
	public Double getAllocation(){
		return this.allocAmt;
	}

}
