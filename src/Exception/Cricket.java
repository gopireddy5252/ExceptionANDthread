package Exception;

import java.util.Scanner;

class InvalidNumberOfPlayersException extends Exception {
	public InvalidNumberOfPlayersException() {

	}

	public InvalidNumberOfPlayersException(String msg) {
		super(msg);
	}
}

class EmptyPlayerNameException extends Exception {
	public EmptyPlayerNameException() {

	}

	public EmptyPlayerNameException(String msg) {
		super(msg);
	}
}

class T20Players {
	private int noOfPlayers;
	private String[] players;

	public T20Players(int noOfPlayers) {
		super();
		this.noOfPlayers = noOfPlayers;
		players = new String[noOfPlayers];
	}

	public void selectPlayer(int index, String name) {
		players[index] = name;
	}

	public void displaySelectedPlayers() {
		for (int i = 0; i < noOfPlayers; i++) {
			System.out.println(players[i]);
		}
	}

}

public class Cricket {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int noPlayers;
		try (sc) {
			OUTER1: while (true) {
				try {

					System.out.println("Enter number of players to select : ");
					noPlayers = sc.nextInt();
					sc.nextLine();
					if (noPlayers < 0) {
						throw new InvalidNumberOfPlayersException("Number can't be -ve");
					}
					T20Players t = new T20Players(noPlayers);
					int i = 0;
					OUTER2: while (true) {
						try {
							for (; i < noPlayers; i++) {
								System.out.println("Enter " + (i + 1) + " player name : ");
								String name = sc.nextLine();
								if (name.isEmpty()) {
									throw new EmptyPlayerNameException("Name cant be empty..");
								}
								t.selectPlayer(i, name);
							}
							break;

						} catch (EmptyPlayerNameException e) {
							System.out.println(e.getMessage());
							continue OUTER2;
						}

					}

					t.displaySelectedPlayers();
				} catch (InvalidNumberOfPlayersException e) {
					System.out.println(e.getMessage());
					continue OUTER1;
				}
				break;
			}
		}

	}

}
