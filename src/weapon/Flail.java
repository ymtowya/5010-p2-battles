package weapon;

import player.Ability;
import player.Player;
import randomhelper.RandomHelper;

/**
 * Flail represents the Flail weapon in the game.
 *
 *
 */
public class Flail implements Weapon {

  private boolean canWieldBy(Player player) {
    return player.getAbbility(Ability.DEXTERITY) > 14;
  }
  
  @Override
  public int getDamageBy(Player player, RandomHelper helper) {
    int damage = helper.randomInt(8, 12);
    if (!canWieldBy(player)) {
      damage /= 2;
    }
    return damage;
  }

  @Override
  public int getMaxAttackTimes() {
    return 1;
  }

  @Override
  public String toString() {
    return "Weapon: Flail";
  }
}
