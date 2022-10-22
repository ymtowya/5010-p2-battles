package gear;

import java.util.HashMap;
import java.util.Map;

import player.Ability;
import randomhelper.RandomHelper;

/**
 * Potion is a type of Battle Gear.
 *
 *
 */
public class Potion extends AbstractBattleGear {

  /**
   * Init the Potion with term limit.
   *
   * @param termLimit term length
   */
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
  
  @Override
  public String toString() {
    return String.format("%s\n%s%s\n",
        "----Gear: Potion----",
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
    return 1;
  }
  
  @Override
  protected int compareToPotion(Potion potion) {
    return this.getId() - potion.getId();
  }

  @Override
  public int compareTo(Gear o) {
    if (o instanceof AbstractBattleGear) {
      return -1 * ((AbstractBattleGear) o).compareToPotion(this);
    }
    return 0;
  }

}
