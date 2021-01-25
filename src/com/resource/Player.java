package com.resource;

/**
 * @author swapnilu
 *
 */
public class Player implements Comparable<Player> {
	private String name;

	public Player(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null && !(obj instanceof Player))
			return false;
		return this.name.equals(((Player) obj).name);
	}

	@Override
	public int compareTo(Player o) {
		return this.name.compareTo(o.name);
	}

	@Override
	public String toString() {
		return name;
	}

}
