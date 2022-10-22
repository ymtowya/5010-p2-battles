package weapon;

import player.Player;
import randomhelper.RandomHelper;

/**
 * Broadsword represents the Broadsword weapon in the game.
 *
 *
 */
public class Broadsword implements Weapon {

  @Override
  public int getDamageBy(Player player, RandomHelper helper) {
    return helper.randomInt(6, 10);
  }

  @Override
  public int getMaxAttackTimes() {
    return 1;
  }

  @Override
  public String toString() {
    return "Weapon: Broadsword";
  }
}
