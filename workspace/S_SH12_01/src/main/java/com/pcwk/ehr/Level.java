package com.pcwk.ehr;

public enum Level {

	//BASIC(1),SILVER(2),GOLD(3);
	GOLD(3,null),SILVER(2,GOLD), BASIC(1,SILVER);
	
	private final int value;
	//다음 레벨
	private final Level next;
	
	
	Level(int value,Level next){
		this.value = value;
		this.next  = next;
	}

	/**
	 * 다음 Level 가지고 오기
	 * @return Level
	 */
	public Level nextLevel() {
		return this.next;
	}
	
	/**
	 * 값을 가지고 올때 사용
	 * @return
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * 값으로 부터 Level 가져오기
	 * 1 -> BASIC
	 * 2 -> SILVER
	 * 3 -> GOLD
	 * @param value
	 * @return Level
	 */
	public static Level valueOf(int value) {
		switch(value) {
		case 1: return BASIC;
		case 2: return SILVER;
		case 3: return GOLD;
		default: throw new AssertionError("Unknown value:"+ value);
		
		}
	}
	
	
}
