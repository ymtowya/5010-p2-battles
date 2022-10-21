package weapon;

import player.Player;
import randomhelper.RandomHelper;

public class Katana implements Weapon {

  @Override
  public int getDamageBy(Player player, RandomHelper helper) {
    return helper.randomInt(4, 6);
  }

  @Override
  public int getMaxAttackTimes() {
    return 2;
  }

}
