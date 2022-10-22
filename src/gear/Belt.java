package gear;

import java.util.HashMap;
import java.util.Map;
import player.Ability;
import randomhelper.RandomHelper;

/**
 * This class represents the Belt Gear.
 *
 */
public class Belt extends AbstractBattleGear {
  
  /**
   * Initialize the Belt.
   *
   * @param size belt size
   * @param term gear term
   */
  public Belt(GearSize size, int term) {
    super(size, term);
  }

  @Override
  public GearType getGearType() {
    return GearType.BELT;
  }

  @Override
  public void setRandAffects(RandomHelper helper) {
    Ability affectedAbility1 = helper.randAbility();
    Ability affectedAbility2 = helper.randAbility();
    int points1 = helper.randAffectValue();
    int points2 = helper.randAffectValue();
    Map<Ability, Integer> res = new HashMap<>();
    res.put(affectedAbility1, points1);
    res.put(affectedAbility2, points2);
    this.setAffects(res);
  }

  @Override
  public String toString() {
    final String title = String.format("----Gear: %s Belt----",
        this.getGearSize().name());
    return String.format("%s\n%s%s\n",
        title,
        getAffectString(),
        "--------------------");
  }

  @Override
  protected int compareToBelt(Belt belt) {
    if (belt.getGearSize() != this.getGearSize()) {
      return GearSize.getUnitBySize(this.getGearSize())
          - GearSize.getUnitBySize(belt.getGearSize());
    }
    return this.getId() - belt.getId();
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
    return 1;
  }

  @Override
  public int compareTo(Gear o) {
    if (o instanceof AbstractBattleGear) {
      return -1 * ((AbstractBattleGear) o).compareToBelt(this);
    }
    return 0;
  }
}
