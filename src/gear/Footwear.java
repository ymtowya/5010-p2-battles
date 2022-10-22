package gear;

import java.util.HashMap;
import java.util.Map;
import player.Ability;
import randomhelper.RandomHelper;

/**
 * This class represents the Footwear Gear.
 *
 */
public class Footwear extends AbstractBattleGear {

  /**
   * Initialize the Footwear.
   * 
   * @param termLimit term length
   */
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
  
  @Override
  public String toString() {
    return String.format("%s\n%s%s\n",
        "----Gear: Footwear----",
        getAffectString(),
        "--------------------");
  }
  
  @Override
  protected int compareToBelt(Belt belt) {
    return 1;
  }
  
  @Override
  protected int compareToFootwear(Footwear footwear) {
    return this.getId() - footwear.getId();
  }
  
  @Override
  protected int compareToHeadGear(HeadGear headGear) {
    return 1;
  }
  
  @Override
  protected int compareToPotion(Potion potion) {
    return 1;
  }

  @Override
  public int compareTo(Gear o) {
    if (o instanceof AbstractBattleGear) {
      return -1 * ((AbstractBattleGear) o).compareToFootwear(this);
    }
    return -1;
  }
}
