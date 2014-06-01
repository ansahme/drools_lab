package employee;

import java.util.HashSet;
import java.util.Set;

import department.Allocation;

public class Manager implements Employee{
	private String id;
	Allocation alloc = Allocation.MANAGER;
	ManagerLevel managerLevel;
	private Set<Employee> subordinates;
	
	public Manager(String id, ManagerLevel level){
		this.id = id;
		this.managerLevel = level;
	}

	@Override
	public Double getAllocation() {
		Double totalAllocation = this.alloc.getAllocation();
		
		if(this.subordinates != null && this.subordinates.size() > 0){
			for (Employee emp : this.subordinates){
				totalAllocation += emp.getAllocation();
			}
		}
		return totalAllocation;
	}
	
	public String getId(){
		return id;
	}
	
	public void  addSubordinate(Employee employee){
		if(this.subordinates == null){
			this.subordinates = new HashSet<Employee>();
		}
		this.subordinates.add(employee);
		
	}
	
	public Set<Employee> getSubordinates(){
		if(this.subordinates == null){
			this.subordinates = new HashSet<Employee>();
		}
		return this.subordinates;
	}
	
	public int getManagerLevel(){
		return this.managerLevel.levelId();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alloc == null) ? 0 : alloc.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((managerLevel == null) ? 0 : managerLevel.hashCode());
		result = prime * result
				+ ((subordinates == null) ? 0 : subordinates.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		if (alloc != other.alloc)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (managerLevel != other.managerLevel)
			return false;
		if (subordinates == null) {
			if (other.subordinates != null)
				return false;
		} else if (!subordinates.equals(other.subordinates))
			return false;
		return true;
	}
	
	

}
