package employee;

public enum ManagerLevel {
	MANAGER1(1),MANAGER2(2),MANAGER3(3),MANAGER4(4);
	
	private int levelId;
	private ManagerLevel(int level){
		this.levelId = level;
	}

	public int levelId(){
		return levelId;
	}
}
