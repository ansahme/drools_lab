package employee;

import department.Allocation;

public class Developer implements Employee{

	private String id;
	private Allocation alloc = Allocation.DEVELOPER;
	
	public Developer(String id) {
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
