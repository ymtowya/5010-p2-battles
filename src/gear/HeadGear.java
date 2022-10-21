package gear;

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
  public void setAffects(RandomHelper helper) {
    
  }

}
