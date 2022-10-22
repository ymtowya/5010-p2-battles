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
public interface Gear extends Comparable<Gear> {
  
  /**
   * Get Gear id.
   *
   * @return id
   */
  int getId();
  
  /**
   * Get how much terms left.
   *
   * @return left terms
   */
  int getTermLeft();
  
  /**
   * Tell if Gear is valid for use.
   *
   * @return bool if valid for use
   */
  boolean validForUse();
  
  /**
   * Self-update after one turn of use.
   *
   */
  void used();
  
  /**
   * Get the affects of the gear.
   *
   * @return map containing affects
   */
  Map<Ability, Integer> getAffects();
  
  /**
   * Get gear type.
   *
   * @return gear type
   */
  GearType getGearType();
  
  /**
   * Get gear size.
   *
   * @return gear size
   */
  GearSize getGearSize();
  
  /**
   * Get the Gear Direct.
   *
   * @return Gear Direct
   */
  GearDirect getGearDirect();
  
  /**
   * Get the gear direct coefficient.
   *
   * @return coefficient
   */
  int getGearDirectIndex();
  
  /**
   * Tell if is same type of another gear.
   *
   * @param gear another gear
   * @return if is same type
   */
  boolean isSameType(Gear gear);
  
  /**
   * Set new affects.
   *
   * @param affects new Affects
   */
  void setAffects(Map<Ability, Integer> affects);
  
  /**
   * Assign random affects.
   *
   * @param helper random helper
   */
  void setRandAffects(RandomHelper helper);
  
  /**
   * Get the gear's affect on one ability.
   *
   * @param ability the ability
   * @return the affect
   */
  Integer getAffect(Ability ability);
  
  /**
   * Tell if the gear can be added to the list,
   * without exceeding capacity.
   *
   * @param gears list of gears
   * @return bool tell if we can add
   */
  boolean canAddInto(List<Gear> gears);
  
  /**
   * Set the Gear Direct.
   *
   * @param newGear new Gear Direct
   */
  void setGearDirect(GearDirect newGear);
}
