package gear;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import player.Ability;
import randomhelper.RandomHelper;

public abstract class AbstractBattleGear implements Gear {
  
  protected Map<Ability, Integer> affects;
  private GearSize gearSize;
  private GearDirect gearDirect;
  private int term;
  
  public AbstractBattleGear(GearSize size, int termLimit) {
    this.term = termLimit;
    this.gearSize = size;
    this.gearDirect = GearDirect.POSITIVE;
    this.affects = new HashMap<Ability, Integer>();
    this.affects.put(Ability.STRENGTH, 0);
    this.affects.put(Ability.CONSTITUITION, 0);
    this.affects.put(Ability.DEXTERITY, 0);
    this.affects.put(Ability.CHARISMA, 0);
  }
  
  @Override
  public boolean canAddInto(List<Gear> gears) {
    final int unit_limit = GearType.getCapacityByType(this.getGearType());
    final int per_unit = GearSize.getUnitBySize(this.getGearSize());
    int curr_units = per_unit; // We are testing if this can be added.
    for (Gear oldGear : gears) {
      if (this.isSameType(oldGear)) {
        curr_units += per_unit;
      }
    }
    return curr_units <= unit_limit;
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

  @Override
  public Integer getAffect(Ability ability) {
    if (this.affects.containsKey(ability)) {
      return this.affects.get(ability);
    }
    return 0;
  }

  @Override
  abstract public GearType getGearType();
  
  private Integer getValueOr0(Map<Ability, Integer> newAffects, Ability ability) {
    if (newAffects.containsKey(ability)) {
      return newAffects.get(ability);
    }
    return 0;
  }
  
  @Override
  public void setAffects(Map<Ability, Integer> affects) {
    this.affects.put(Ability.STRENGTH, getValueOr0(affects, Ability.STRENGTH));
    this.affects.put(Ability.CONSTITUITION, getValueOr0(affects, Ability.CONSTITUITION));
    this.affects.put(Ability.DEXTERITY, getValueOr0(affects, Ability.DEXTERITY));
    this.affects.put(Ability.CHARISMA, getValueOr0(affects, Ability.CHARISMA));
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
}
