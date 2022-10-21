package player;

import java.util.List;
import java.util.Map;

import gear.Gear;
import randomhelper.RandomHelper;
import weapon.Weapon;

public class BattlePlayerCalculator implements PlayerCalculator {
  
  private RandomHelper helper;
  
  private Map<String, Object> calcAttackHelper(BattlePlayer attacker, BattlePlayer victim) {
    // TODO
    return null;
  }
  
  @Override
  public Map<String, Object> calcAttack(Player attcker, Player victim) {
    if (attcker instanceof BattlePlayer &&
        victim instanceof BattlePlayer) {
      return calcAttackHelper((BattlePlayer)attcker, (BattlePlayer)victim);
    }
    return null;
  }

  @Override
  public Map<String, Object> attachWeapon(Player player) {
    player.setWeapon(helper.randWeaponChoice());
    return null;
  }

  @Override
  public Map<String, Object> attachGear(Player player) {
    player.setGears(helper.randGearChoices());
    return null;
  }
}
