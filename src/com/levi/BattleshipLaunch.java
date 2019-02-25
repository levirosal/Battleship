package com.levi;

import java.util.List;

/**
 * Calls for the creation of ships and requests the user's guess.
 * @version 3.0
 * @since 2019
 * @author Levi Rosal
 */
public class BattleshipLaunch {
  private BattleshipActions actions;
  private List<String> locations1;
  private List<String> locations2;

  /**
   * Creates new game.
   */
  public void launch(){
    System.out.println("\nYour goal is to sink enemy ships.");
    System.out.println(" A *  *  *  *  *  *  *");
    System.out.println(" B *  *  *  *  *  *  *");
    System.out.println(" C *  *  *  *  *  *  *");
    System.out.println(" D *  *  *  *  *  *  *");
    System.out.println(" E *  *  *  *  *  *  *");
    System.out.println(" F *  *  *  *  *  *  *");
    System.out.println(" G *  *  *  *  *  *  *");
    System.out.println("   0  1  2  3  4  5  6\n");

    Game game = new Game();

    locations1 = game.getLocations1();
    locations2 = game.getLocations2();

  }

  /**
   * Calls the method to insert your shot and method to check guess
   */
  public void start() {
    actions = new BattleshipActions();
    String userGuess;
    int player = 0;

    actions.setLocations1(locations1);
    actions.setLocations2(locations2);

    while (true) {
      player = 1;
      System.out.println("\nPlayer 1");
      userGuess = actions.getUserInput();
      if (actions.checkShot(player, userGuess).equals("kill")) {
        break;
      }

      player = 2;
      System.out.println("\nPlayer 2");
      userGuess = actions.getUserInput();
      if (actions.checkShot(player, userGuess).equals("kill")) {
        break;
      }
    }
    actions.finish(player);

  }
}
