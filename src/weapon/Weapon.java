package weapon;

import player.Player;
import randomhelper.RandomHelper;

/**
 * Weapon is the interface representing the weapons in the game.
 *
 */
public interface Weapon {
  /**
   * Calculate how much damage can have used by the player.
   *
   * @param player the user
   * @param helper the random helper
   * @return the damage value
   */
  int getDamageBy(Player player, RandomHelper helper);
  
  /**
   * Get Max attack times.
   *
   * @return max times.
   */
  int getMaxAttackTimes();
}
