package gear;

import java.util.HashMap;
import java.util.Map;

import player.Ability;
import randomhelper.RandomHelper;

public class Belt extends AbstractBattleGear {
  
  public Belt(GearSize size, int term) {
    super(size, term);
  }

  @Override
  public GearType getGearType() {
    return GearType.BELT;
  }

  @Override
  public void setRandAffects(RandomHelper helper) {
    Ability affectedAbility1 = helper.randAbility();
    Ability affectedAbility2 = helper.randAbility();
    int points1 = helper.randAffectValue();
    int points2 = helper.randAffectValue();
    Map<Ability, Integer> res = new HashMap<>();
    res.put(affectedAbility1, points1);
    res.put(affectedAbility2, points2);
    this.setAffects(res);
  }

}
