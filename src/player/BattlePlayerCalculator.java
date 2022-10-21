package player;

import java.util.List;
import java.util.Map;

import gear.Gear;
import weapon.Weapon;

public class BattlePlayerCalculator implements PlayerCalculator {
  
  
  
  private Map<String, Object> calcAttackHelper(BattlePlayer attacker, BattlePlayer victim) {
    
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
  public Map<String, Object> attachWeapon(Player player, List<Weapon> weapons) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Map<String, Object> attachGear(Player player, List<Gear> gears) {
    // TODO Auto-generated method stub
    return null;
  }
}
