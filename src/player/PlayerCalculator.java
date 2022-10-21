package player;

import java.util.List;
import java.util.Map;

import gear.Gear;
import weapon.Weapon;

public interface PlayerCalculator {
  Map<String, Object> calcAttack(Player attcker, Player victim);
  Map<String, Object> attachWeapon(Player player, List<Weapon> weapons);
  Map<String, Object> attachGear(Player player, List<Gear> gears);
}
