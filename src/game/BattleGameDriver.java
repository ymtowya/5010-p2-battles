package game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import player.BattlePlayerCalculator;
import player.PlayerCalculator;
import randomhelper.BattleRandomHelper;
import randomhelper.RandomHelper;

/**
 * Driver Class for the game.
 *
 *
 */
public class BattleGameDriver {
  
  static FileWriter writer;
  static Scanner in;
  static BattleGame game;

  private static void fileSetUp() throws IOException {
    File myObjFile = new File("./res/runningResult.txt");
    writer = new FileWriter(myObjFile);
    in = new Scanner(System.in);
  }
  
  private static void log(String string) throws IOException {
    writer.write(string);
  }
  
  private static void setUp3() throws IOException {
    try {
      fileSetUp();
    } catch (IOException e) {
      e.printStackTrace();
    }
    log("\n---------START----------\n");
    log("Initializing the Game:\n");
    RandomHelper helper = new BattleRandomHelper(7);
    PlayerCalculator calculator = new BattlePlayerCalculator(helper);
    game = new BattleGameImpl("Tobby", "Dianna", calculator);
    log("\n-------------------\n");
    log("The game state now is:\n");
    log(game.getStateString());
    log("\n-------------------\n");
    log("The Players Now are like:\n");
    log(game.getPlayersString());
    log("\n-------------------\n");
    log("Now we start the game by running in turns:\n");
    while (!game.isOver()) {
      game.runNewTurn();
      log(game.getStateString());
    }
    log("\n-------------------\n");
    log("Now the game result is:\n");
    log(game.getResultString());
    
    log("\n-------------------\n");
    System.out.println("Now input 're' to RE-match them:");
    String str = in.next();
    if ("re".equals(str)) {
      log("Now for REMATCH\n");
      game.rematch();
      log("The game state now is:\n");
      log(game.getStateString());
      log("Now we re-start the game by running in turns:\n");
      while (!game.isOver()) {
        game.runNewTurn();
        log(game.getStateString());
      }
      log("\n-------------------\n");
      log("Now the game result is:\n");
      log(game.getResultString());
    }
    log("\n---------END----------\n");
  }

  /**
   * Main Function of Driver.
   *
   * @param args arguments
   */
  public static void main(String[] args) {
    try {
      // setUp4()
      setUp3();
      // setUp2()
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
