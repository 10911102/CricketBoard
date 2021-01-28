package com.resource;

public enum BattingStat {
	PLAYED("Played and Out"),
	PLAYING("Currently playing"),
	NYP("Not Yet Played");

	private String description;

	BattingStat(String string) {
		this.description = string;
	}

	/**
	 * @return the value
	 */
	public String getDescription() {
		return description;
	}
}
