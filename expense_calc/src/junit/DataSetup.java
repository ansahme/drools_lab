package junit;

import department.Department;
import employee.Developer;
import employee.Manager;
import employee.ManagerLevel;
import employee.QA;

public class DataSetup {
	public static Department getDepartment(){
		Department underTest = new Department();
		//manager 1
		Manager firstLevelMan1 = new Manager("firstLevelMan1", ManagerLevel.MANAGER1);
		Developer dev1 = new Developer("Dev1");
		QA qa1 = new QA("Qa1");

		firstLevelMan1.getSubordinates().add(dev1);
		firstLevelMan1.getSubordinates().add(qa1);

		//manager2
		Manager secondLevelMan1 = new Manager("secondLevelMan1",ManagerLevel.MANAGER2);
		secondLevelMan1.addSubordinate(firstLevelMan1);

		underTest.addManager(secondLevelMan1);
		underTest.addManager(firstLevelMan1);
		underTest.addManager(secondLevelMan1);//for testing duplicate entry
		underTest.addManager(firstLevelMan1); //for testing duplicate entry
		
		//add senior manager 3
		Manager firstLevelMan2 = new Manager("firstLevelMan2", ManagerLevel.MANAGER1);
		Developer dev2 = new Developer("Dev2");
		QA qa2 = new QA("Qa2");

		firstLevelMan2.getSubordinates().add(dev2);
		firstLevelMan2.getSubordinates().add(qa2);

		//manager4
		Manager secondLevelMan2 = new Manager("secondLevelMan2",ManagerLevel.MANAGER2);
		secondLevelMan2.addSubordinate(firstLevelMan2);

		underTest.addManager(secondLevelMan2);
		underTest.addManager(firstLevelMan2);
		
		//third level manager - manager5
		Manager thirdLevelManager1 = new Manager("ThirdLevelManager1",ManagerLevel.MANAGER3);
		thirdLevelManager1.addSubordinate(secondLevelMan1);
		thirdLevelManager1.addSubordinate(secondLevelMan2);
		
		underTest.addManager(thirdLevelManager1);
		
		return underTest;
	}

}
