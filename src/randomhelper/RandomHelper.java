package randomhelper;

import gear.Gear;
import gear.GearDirect;
import gear.GearSize;
import java.util.List;
import player.Ability;
import weapon.Weapon;

/**
 * Random Helper interface serves as the center of generating random
 * results for all purposes in the game.
 *
 */
public interface RandomHelper {
  
  /**
   * Get a randomly generated value with the left (inclusive) and
   * right (inclusive) range.
   *
   * @param left left bound (inclusive)
   * @param right right bound (inclusive)
   * @return generated value
   */
  int randomInt(int left, int right);
  
  /**
   * Get a randomly generated value of 4 dices.
   *
   * @return the value
   */
  int random4Dices();
  
  /**
   * Get a random value for the Gear to determine affects.
   *
   * @return the value
   */
  int randAffectValue();
  
  /**
   * Get a List of randomly generated Gears.
   *
   * @return gear list
   */
  List<Gear> randGearChoices();
  
  /**
   * Get a random weapon.
   *
   * @return weapon
   */
  Weapon randWeaponChoice();
  
  /**
   * Split one value into several parts and return them.
   *
   * @param total the to-be-split value
   * @param parts number of parts
   * @return List containing the parts of the value
   */
  List<Integer> randDivideVal(Integer total, int parts);
  
  /**
   * Randomly generate an Ability.
   *
   * @return ability
   */
  Ability randAbility();
  
  /**
   * Randomly generate a size.
   *
   * @return the size
   */
  GearSize randGearSize();
  
  /**
   * Randomly generate a Direct for Gear.
   *
   * @return Gear Direct
   */
  GearDirect randGearDirect();
}
