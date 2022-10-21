package weapon;

import player.Player;
import randomhelper.RandomHelper;

public interface Weapon {
  int getDamageBy(Player player, RandomHelper helper);
  int getMaxAttackTimes();
}
