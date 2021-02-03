package com;

/**
 * @author swapnilu
 *
 */
public class Player2 implements Comparable<Player2> {
	private String playerName;
	private int run;
	private String playsFor;
	private BattingStatus bat;
	private static int playing = 1;

	public static void setPlaying(int playing) {
		Player2.playing = playing;
	}

	public Player2(String name) {
		this.playerName = name;
		this.randomInit();
	}
	public Player2(String playerName, String teamName) {
		this.playerName = playerName;
		this.playsFor = teamName;
		this.randomInit();
	}

	public Player2(String name, int run) {
		this.playerName = name;
		this.run = run;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return playerName;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.playerName = name;
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
		return playerName.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null && !(obj instanceof Player2))
			return false;
		return this.playerName.equals(((Player2) obj).playerName);
	}

	@Override
	public int compareTo(Player2 o) {
		return this.playerName.compareTo(o.playerName);
	}

	@Override
	public String toString() {
		return playerName+" Runs: "+this.run;
	}
	public void randomInit() {
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

	/**
	 * @return the playsFor
	 */
	public String getPlaysFor() {
		return playsFor;
	}

	/**
	 * @param playsFor the playsFor to set
	 */
	public void setPlaysFor(String playsFor) {
		this.playsFor = playsFor;
	}
}
