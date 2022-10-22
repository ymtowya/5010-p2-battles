package weapon;

import player.Ability;
import player.Player;
import randomhelper.RandomHelper;

public class TwoHandSword implements Weapon {

  private boolean canWieldBy(Player player) {
    return player.getAbbility(Ability.STRENGTH) > 14;
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
    return "Weapon: Two Handed Sword";
  }

}
