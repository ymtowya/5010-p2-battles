package gear;

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
  public void setAffects(RandomHelper helper) {
    // TODO Auto-generated method stub

  }

}
