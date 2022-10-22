package gear;

import java.util.HashMap;
import java.util.Map;

import player.Ability;
import randomhelper.RandomHelper;

/**
 * Head Gear as a type of Battle Gear.
 *
 */
public class HeadGear extends AbstractBattleGear {
  
  /**
   * Init the Headgear with term limit.
   *
   * @param termLimit term length
   */
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
  
  @Override
  public String toString() {
    return String.format("%s\n%s%s\n",
        "----Gear: HeadGear----",
        getAffectString(),
        "--------------------");
  }
  
  @Override
  protected int compareToBelt(Belt belt) {
    return -1;
  }
  
  @Override
  protected int compareToFootwear(Footwear footwear) {
    return -1;
  }
  
  @Override
  protected int compareToHeadGear(HeadGear headGear) {
    return this.getId() - headGear.getId();
  }
  
  @Override
  protected int compareToPotion(Potion potion) {
    return -1;
  }

  @Override
  public int compareTo(Gear o) {
    if (o instanceof AbstractBattleGear) {
      return -1 * ((AbstractBattleGear) o).compareToHeadGear(this);
    }
    return 0;
  }

}
