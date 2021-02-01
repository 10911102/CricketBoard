package com;

/**
 * @author swapnilu
 *
 */
public class Player implements Comparable<Player> {
	private String name;
	private int run;
	private BattingStatus bat;
	private static int playing = 1;

	public static void setPlaying(int playing) {
		Player.playing = playing;
	}

	public Player(String name) {
		this.name = name;
		int key = (int) (Math.random() * 3);
		if (key == 0) {
			this.bat = BattingStatus.PLAYED;
			this.run = (int) (Math.random() * 100);
		} else if (key == 1)
			this.bat = BattingStatus.NYP;
		else if (playing <= 2) {
			this.bat = BattingStatus.PLAYING;
			this.run = (int) (Math.random() * 100);
			playing++;
		} else {
			this.bat = BattingStatus.NYP;
		}
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

	/**
	 * @return the bat
	 */
	public BattingStatus getBat() {
		return bat;
	}

	/**
	 * @param bat the bat to set
	 */
	public void setBat(BattingStatus bat) {
		this.bat = bat;
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
		return name+" Runs: "+this.run;
	}

}
