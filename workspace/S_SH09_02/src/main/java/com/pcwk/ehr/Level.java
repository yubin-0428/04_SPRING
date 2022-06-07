package com.pcwk.ehr;

public enum Level {

	BASIC(1),SILVER(2),GOLD(3);
	
	private final int value;
	
	Level(int value){
		this.value = value;
	}

	/**
	 * 값을 가지고 올 때 사용
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
		
		default: throw new AssertionError("Unknown value:"+value);
		
		}
	}
	
	
}
