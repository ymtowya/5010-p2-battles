package gear;

import java.util.List;
import java.util.Map;

import player.Ability;
import randomhelper.RandomHelper;

/**
 * Interface representing Gear.
 *
 *
 */
public interface Gear extends Comparable<Gear>{
  
  /**
   * Get Gear id.
   *
   * @return id
   */
  int getId();
  
  /**
   * Get how much terms left.
   *
   * @return
   */
  int getTermLeft();
  boolean validForUse();
  void used();
  Map<Ability, Integer> getAffects();
  GearType getGearType();
  GearSize getGearSize();
  GearDirect getGearDirect();
  int getGearDirectIndex();
  boolean isSameType(Gear gear);
  void setAffects(Map<Ability, Integer> affects);
  void setRandAffects(RandomHelper helper);
  Integer getAffect(Ability ability);
  boolean canAddInto(List<Gear> gears);
  void setGearDirect(GearDirect newGear);
}
