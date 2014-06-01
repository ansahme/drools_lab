package employee;

import department.Allocation;

public class QA implements Employee{

	private Allocation alloc = Allocation.QA;
	private String id;
	
	public QA(String id){
		this.id = id;
	}
	
	@Override
	public Double getAllocation() {
		return this.alloc.getAllocation();
	}

	@Override
	public String getId() {
		return this.id;
	}
	

}
