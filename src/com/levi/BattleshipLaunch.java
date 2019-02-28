package com.levi;

import java.util.List;

/**
 * Calls for the creation of ships and requests the user's guess.
 * @version 3.0
 * @since 2019
 * @author Levi Rosal
 */
public class BattleshipLaunch {
  /**
   * variable sdasdas
   */
  private BattleshipActions actions = new BattleshipActions();
  private Game game;
  private List<String> locations1;
  private List<String> locations2;


  /**
   * Create a new game.
   * @param nameP1 Name of player 1.
   * @param locFile1 Location of ships of player 1.
   * @param nameP2 Name of player 2.
   * @param locFile2 Location of ships of player 2.
   */
  public void launch(String nameP1, String locFile1, String nameP2, String locFile2){
    System.out.println("\nYour goal is to sink enemy ships.");
    System.out.println(" A *  *  *  *  *  *  *");
    System.out.println(" B *  *  *  *  *  *  *");
    System.out.println(" C *  *  *  *  *  *  *");
    System.out.println(" D *  *  *  *  *  *  *");
    System.out.println(" E *  *  *  *  *  *  *");
    System.out.println(" F *  *  *  *  *  *  *");
    System.out.println(" G *  *  *  *  *  *  *");
    System.out.println("   0  1  2  3  4  5  6\n");

    game = new Game(nameP1, locFile1, nameP2, locFile2);

    locations1 = game.getLocations1();
    locations2 = game.getLocations2();
  }

  /**
   * Calls the method to insert your shot and method to check guess
   */
  public void start() {
    String userGuess;
    String name;
    int player = 0;

    actions.setLocations1(locations1);
    actions.setLocations2(locations2);

    while (true) {
      player = 1;

      System.out.print("\n" +  game.getNameP1());
      userGuess = actions.getUserInput();

      if (actions.checkShot(player, userGuess).equals("kill")) {
        name = game.getNameP1();
        break;
      }

      player = 2;
      System.out.print("\n" + game.getNameP2());
      userGuess = actions.getUserInput();
      if (actions.checkShot(player, userGuess).equals("kill")) {
        name = game.getNameP2();
        break;
      }
    }
    game.finish(name);
  }
}
