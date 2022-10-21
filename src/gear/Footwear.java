package gear;

import randomhelper.RandomHelper;

public class Footwear extends AbstractBattleGear {

  public Footwear(int termLimit) {
    super(GearSize.NA, termLimit);
    // TODO Auto-generated constructor stub
  }

  @Override
  public GearType getGearType() {
    return GearType.FOOTWEAR;
  }

  @Override
  public void setAffects(RandomHelper helper) {
    // TODO Auto-generated method stub

  }

}
