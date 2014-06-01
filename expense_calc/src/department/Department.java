package department;

import java.util.HashSet;
import java.util.Set;

import employee.Manager;

public class Department {
	private Set<Manager> managers = new HashSet<Manager>();
	
	public Double getTotalMonthlyExpense(){
		Double expense = 0.0;
		if(managers.size() > 0){
			for ( Manager manager : managers){
				if(manager.getManagerLevel() == getHighestManagerLevel()){
					expense += manager.getAllocation();
				}			
			}
		}
		return expense;
	}
	
	public Double getExpenseByManager(String managerId){
		Double managerExpense = 0.0;
		if(managers.size() > 0){
			for (Manager manager : managers){
				if(manager.getId().equalsIgnoreCase(managerId)){
					managerExpense+= manager.getAllocation();
				}
			}
		}
		return managerExpense;
	}
	
	public void addManager(Manager manager){
		this.managers.add(manager);
	}

	public int getHighestManagerLevel(){
		int topManLevelId = 0;
		
		for (Manager manager : managers){
			topManLevelId = (topManLevelId > 
			manager.getManagerLevel()? topManLevelId:manager.getManagerLevel());
		}
		
		return topManLevelId;
	}
	
	public Set<Manager> getManagers(){
		return this.managers;
	}

}
