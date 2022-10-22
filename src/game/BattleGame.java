package game;

import java.util.Map;

/**
 * This is the interface representing the Battle Game.
 *
 */
public interface BattleGame {
  
  /**
   * The function to call for each turn.
   *
   * @return map Information map containing every turn's result
   */
  Map<GameInfoKey, Object> runNewTurn();
  
  /**
   * Tell if the game is over.
   *
   * @return boolean value denoting if game ends or not
   */
  boolean isOver();
  
  /**
   * Generate the string of player's basic information,
   * including name, gears, abilities, and weapons.
   *
   * @return information string
   */
  String getPlayersString();
  
  /**
   * Generate the state string of the game, telling
   * the game state.
   *
   * @return game state string
   */
  String getStateString();
  
  /**
   * Generate the string for the game's result.
   *
   * @return result string
   */
  String getResultString();
  
  /**
   * Re-match the game.
   *
   */
  void rematch();
}
