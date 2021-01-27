package com.resource;

/**
 * @author swapnilu
 *
 */
public class Player implements Comparable<Player> {
	private String name;
	private int run;

	public Player(String name) {
		this.name = name;
		this.run = (int) (Math.random() * 100);
	}

	public Player(String name, int run) {
		this.name = name;
		this.run = run;
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

	/**
	 * @return the run
	 */
	public int getRun() {
		return run;
	}

	/**
	 * @param run the run to set
	 */
	public void setRun(int run) {
		this.run = run;
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
