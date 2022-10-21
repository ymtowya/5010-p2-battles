package gear;

import java.util.HashMap;
import java.util.Map;

import player.Ability;
import randomhelper.RandomHelper;

public class Footwear extends AbstractBattleGear {

  public Footwear(int termLimit) {
    super(GearSize.NA, termLimit);
  }

  @Override
  public GearType getGearType() {
    return GearType.FOOTWEAR;
  }

  @Override
  public void setRandAffects(RandomHelper helper) {
    int points = helper.randAffectValue();
    Map<Ability, Integer> res = new HashMap<>();
    res.put(Ability.DEXTERITY, points);
    this.setAffects(res);
  }
}
