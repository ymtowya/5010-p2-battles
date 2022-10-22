package gear;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import player.Ability;
import randomhelper.RandomHelper;

/**
 * Abstract class for the battle gears.
 *
 *
 */
public abstract class AbstractBattleGear implements Gear {
  
  private static int serialId = 1;
  
  protected Map<Ability, Integer> affects;
  private GearSize gearSize;
  private GearDirect gearDirect;
  private int term;
  private int id;
  
  /**
   * Initialize the Gear.
   *
   * @param size gear's size
   * @param termLimit gear's term length
   */
  public AbstractBattleGear(GearSize size, int termLimit) {
    this.id = getNextId();
    this.term = termLimit;
    this.gearSize = size;
    this.gearDirect = GearDirect.POSITIVE;
    this.affects = new HashMap<Ability, Integer>();
    this.affects.put(Ability.STRENGTH, 0);
    this.affects.put(Ability.CONSTITUITION, 0);
    this.affects.put(Ability.DEXTERITY, 0);
    this.affects.put(Ability.CHARISMA, 0);
  }
  
  private static int getNextId() {
    return serialId++;
  }
  
  @Override
  public int getId() {
    return this.id;
  }
  
  @Override
  public boolean canAddInto(List<Gear> gears) {
    final int unit_limit = GearType.getCapacityByType(this.getGearType());
    final int per_unit = GearSize.getUnitBySize(this.getGearSize());
    int currUnits = per_unit; // We are testing if this can be added.
    for (Gear oldGear : gears) {
      if (this.isSameType(oldGear)) {
        currUnits += per_unit;
      }
    }
    return currUnits <= unit_limit;
  }
  
  @Override
  public boolean isSameType(Gear gear) {
    return this.getGearType().equals(gear.getGearType());
  }
  
  @Override
  public int getTermLeft() {
    return this.term;
  }
  
  @Override
  public boolean validForUse() {
    return this.getTermLeft() != 0;
  }
  
  @Override
  public void used() {
    if (this.term > 0) {
      this.term--;
    }
  }

  @Override
  public Map<Ability, Integer> getAffects() {
    Map<Ability, Integer> affectsCopy = new HashMap<>();
    affectsCopy.putAll(this.affects);
    return affectsCopy;
  }
  
  /**
   * Get the gear's affects.
   *
   * @return string of affects
   */
  protected String getAffectString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Effected Ability - Effect Value - P/N\n");
    for (Ability ability : this.affects.keySet()) {
      if (this.affects.get(ability) > 0) {
        sb.append(String.format("%s - %s - %s\n",
            ability.name(), String.valueOf(affects.get(ability)),
            getGearDirect() == GearDirect.POSITIVE ? "P" : "N"));
      }
    }
    return sb.toString();
  }

  @Override
  public Integer getAffect(Ability ability) {
    if (this.affects.containsKey(ability)) {
      return this.affects.get(ability);
    }
    return 0;
  }

  @Override
  public abstract GearType getGearType();
  
  private Integer getValueOr0(Map<Ability, Integer> newAffects, Ability ability) {
    if (newAffects.containsKey(ability)) {
      return newAffects.get(ability);
    }
    return 0;
  }
  
  @Override
  public void setAffects(Map<Ability, Integer> newAffects) {
    this.affects.put(Ability.STRENGTH, getValueOr0(newAffects, Ability.STRENGTH));
    this.affects.put(Ability.CONSTITUITION, getValueOr0(newAffects, Ability.CONSTITUITION));
    this.affects.put(Ability.DEXTERITY, getValueOr0(newAffects, Ability.DEXTERITY));
    this.affects.put(Ability.CHARISMA, getValueOr0(newAffects, Ability.CHARISMA));
  }
  
  @Override
  public abstract void setRandAffects(RandomHelper helper);
  
  @Override
  public GearDirect getGearDirect() {
    return this.gearDirect;
  }
  
  @Override
  public int getGearDirectIndex() {
    return GearDirect.getIndex(this.getGearDirect());
  }

  @Override
  public GearSize getGearSize() {
    return this.gearSize;
  }
  
  @Override
  public void setGearDirect(GearDirect newGearDirect) {
    this.gearDirect = newGearDirect;
  }
  
  @Override
  public abstract int compareTo(Gear o);
  
  protected int compareToBelt(Belt belt) {
    return -1;
  }
  
  protected int compareToFootwear(Footwear footwear) {
    return -1;
  }
  
  protected int compareToHeadGear(HeadGear headGear) {
    return -1;
  }
  
  protected int compareToPotion(Potion potion) {
    return -1;
  }
}
