package gear;

import java.util.HashMap;
import java.util.Map;

import player.Ability;
import randomhelper.RandomHelper;

public class HeadGear extends AbstractBattleGear {
  
  public HeadGear(int termLimit) {
    super(GearSize.NA, termLimit);
  }

  @Override
  public GearType getGearType() {
    return GearType.HEADGEAR;
  }

  @Override
  public void setRandAffects(RandomHelper helper) {
    int points = helper.randAffectValue();
    Map<Ability, Integer> res = new HashMap<>();
    res.put(Ability.CONSTITUITION, points);
    this.setAffects(res);
  }

}
