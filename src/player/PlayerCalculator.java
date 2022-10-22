package player;

import game.GameInfoKey;
import java.util.List;
import java.util.Map;
import randomhelper.RandomHelper;

/**
 * PlayerCalculator is the interface to calculate player's state and action.
 *
 */
public interface PlayerCalculator {
  
  /**
   * Change to new random helper.
   *
   * @param newHelper new helper
   */
  void changeHelper(RandomHelper newHelper);
  
  /**
   * Calculate the effect of an attack in the game.
   *
   * @param attcker the Attacker
   * @param victim the Victim
   * @return result of the attck
   */
  Map<GameInfoKey, Object> calcAttack(Player attcker, Player victim);
  
  /**
   * Attach weapon to the player and change the state.
   *
   * @param player the player
   */
  void attachWeapon(Player player);
  
  /**
   * Attach Gears to the player.
   *
   * @param player the player
   */
  void attachGear(Player player);
  
  /**
   * Sort the players in order of attacking.
   *
   * @param player1 one player
   * @param player2 another player
   * @return the List where players are in order
   */
  List<Player> playersInOrder(Player player1, Player player2);
  
  /**
   * Init the player.
   *
   * @param player the player
   */
  void initPlayer(Player player);
  
  /**
   * Reset the player.
   *
   * @param player the player
   * @param value basic ability value
   */
  void resetPlayer(Player player, int value);
  
  /**
   * Calculate the striking power.
   *
   * @param player who strikes
   * @return striking power
   */
  Integer getStikePower(Player player);
  
  /**
   * Calculate Avoidance value.
   *
   * @param player who avoids
   * @return avoidance value
   */
  Integer getAvoidance(Player player);
  
  /**
   * Calculate potential damage.
   *
   * @param player who attacks
   * @return potential damage
   */
  Integer getPotentialDamage(Player player);
  
  /**
   * Calculate actual damage.
   *
   * @param attaker the attacker
   * @param victim the victim player
   * @return the actual damage value
   */
  Integer getActualDamage(Player attaker, Player victim);
}
