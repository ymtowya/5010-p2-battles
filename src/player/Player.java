package player;

import gear.Gear;
import java.util.List;
import java.util.Map;
import weapon.Weapon;

/**
 * Player interface represents the player in the game.
 *
 */
public interface Player {
  
  /**
   * Get player's value of certain ability.
   *
   * @param ability the ability
   * @return the value
   */
  Integer getAbbility(Ability ability);
  
  /**
   * Get player's value of all abilities.
   *
   * @return all abilities
   */
  Map<Ability, Integer> getAbilities();
  
  /**
   * Get health of the player.
   *
   * @return the health
   */
  int getHealth();
  
  /**
   * Tell if is alive.
   *
   * @return bool if is alive
   */
  boolean isAlive();
  
  /**
   * Update gears after each turn.
   *
   */
  void updateAfterTurn();
  
  /**
   * Get player weapon.
   *
   * @return weapon
   */
  Weapon getWeapon();
  
  /**
   * Get player's name.
   *
   * @return name
   */
  String getName();
  
  /**
   * Set abilities and update the health.
   *
   * @param abilities new abilities
   */
  void setAbbilities(Map<Ability, Integer> abilities);
  
  /**
   * Set new Gears.
   *
   * @param newGears new gears
   */
  void setGears(List<Gear> newGears);
  
  /**
   * Set new weapon.
   *
   * @param newWeapon new weapon
   */
  void setWeapon(Weapon newWeapon);
}
