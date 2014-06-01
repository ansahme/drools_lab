package junit;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import department.Department;

public class TestDeptExpenseCalc {
	private static Department underTest;
	
	@BeforeClass
	public static void setupData() {
		// Assumption: No two employee ids are the same.
		underTest = DataSetup.getDepartment();
	}
	
	@Test
	public void testDuplicatedManagerEntry(){
		Assert.assertEquals(5,underTest.getManagers().size());
	}
	
	@Test
	public void testCalcSecondLevelManagerExpense(){
		Assert.assertEquals(new Double(2100),underTest.getExpenseByManager("secondLevelMan2"));
	}
	
	@Test
	public void testCalcFirstLevelManagerExpense(){
		Assert.assertEquals(new Double(1800), underTest.getExpenseByManager("firstLevelMan2"));
	}
	
	@Test
	public void testCalcTotalDeptExpense(){
		Assert.assertEquals(new Double(4500), underTest.getTotalMonthlyExpense());
	}
	
	@Test
	public void testGetDptTopMostManagerLeveId(){
		Assert.assertEquals(3, underTest.getHighestManagerLevel());
	}
	
	@Test
	public void testCalcThirdLevelManagerExpense(){
		Assert.assertEquals(new Double(4500),
				underTest.getExpenseByManager("ThirdLevelManager1"));
	}

}
