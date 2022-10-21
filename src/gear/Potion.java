package gear;

import java.util.HashMap;
import java.util.Map;

import player.Ability;
import randomhelper.RandomHelper;

public class Potion extends AbstractBattleGear {

  public Potion(int termLimit) {
    super(GearSize.NA, termLimit);
  }

  @Override
  public GearType getGearType() {
    return GearType.POTION;
  }

  @Override
  public void setRandAffects(RandomHelper helper) {
    Ability affectedAbility = helper.randAbility();
    int points = helper.randAffectValue();
    Map<Ability, Integer> res = new HashMap<>();
    res.put(affectedAbility, points);
    this.setAffects(res);
  }

}
