package weapon;

import player.Player;
import randomhelper.RandomHelper;

/**
 * Katana represents the Katana weapon in the game.
 *
 *
 */
public class Katana implements Weapon {

  @Override
  public int getDamageBy(Player player, RandomHelper helper) {
    return helper.randomInt(4, 6);
  }

  @Override
  public int getMaxAttackTimes() {
    return 2;
  }

  @Override
  public String toString() {
    return "Weapon: Katanas";
  }
}
