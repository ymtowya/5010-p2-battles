package gear;

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
  public void setAffects(RandomHelper helper) {
    // TODO Auto-generated method stub

  }

}
