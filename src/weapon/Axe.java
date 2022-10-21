package weapon;

import player.Player;
import randomhelper.RandomHelper;

public class Axe implements Weapon {

  @Override
  public int getDamageBy(Player player, RandomHelper helper) {
    return helper.randomInt(6, 10);
  }

  @Override
  public int getMaxAttackTimes() {
    return 1;
  }

}
