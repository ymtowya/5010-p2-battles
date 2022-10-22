package player;

import gear.Gear;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import weapon.Weapon;

/**
 * BattlePlayer is the player in the game, implementing Player.
 *
 */
public class BattlePlayer implements Player {

  private static int serialId = 1;
  
  private Map<Ability, Integer> abilities;
  private List<Gear> myGears;
  private int health;
  private Weapon myWeapon;
  private String name;
  private int id;
  
  /**
   * Init the player with the name.
   *
   * @param newName player's name
   */
  public BattlePlayer(String newName) {
    this.name = newName;
    this.id = serialId++;
    this.abilities = new HashMap<>();
    this.myGears = new ArrayList<>();
  }
  
  protected int getId() {
    return this.id;
  }
  
  @Override
  public String getName() {
    return String.format("Player #%d-%s", this.id, this.name);
  }
  
  private String getAbilitiesString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Ability - Value\n");
    for (Ability ability : abilities.keySet()) {
      sb.append(String.format("%s - %d\n",
          ability.name(), getAbbility(ability)));
    }
    return sb.toString();
  }
  
  @Override
  public Integer getAbbility(Ability ability) {
    Integer resultInteger = 0;
    if (abilities.containsKey(ability)) {
      resultInteger += abilities.get(ability);
    }
    for (Gear gear : myGears) {
      if (gear.validForUse()) {
        resultInteger += gear.getAffect(ability) * gear.getGearDirectIndex();
      }
    }
    return resultInteger;
  }

  @Override
  public Map<Ability, Integer> getAbilities() {
    Map<Ability, Integer> result = new HashMap<Ability, Integer>();
    result.put(Ability.STRENGTH, this.getAbbility(Ability.STRENGTH));
    result.put(Ability.CONSTITUITION, this.getAbbility(Ability.CONSTITUITION));
    result.put(Ability.DEXTERITY, this.getAbbility(Ability.DEXTERITY));
    result.put(Ability.CHARISMA, this.getAbbility(Ability.CHARISMA));
    return result;
  }
  
  private void refreshHealth() {
    int newHealth = 0;
    for (Integer value : this.abilities.values()) {
      newHealth += value;
    }
    this.health = newHealth;
  }

  @Override
  public int getHealth() {
    return this.health;
  }
  
  @Override
  public boolean isAlive() {
    return this.getHealth() > 0;
  }

  @Override
  public void updateAfterTurn() {
    for (Gear gear : this.myGears) {
      gear.used();
    }
  }

  @Override
  public Weapon getWeapon() {
    return myWeapon;
  }

  @Override
  public void setAbbilities(Map<Ability, Integer> newAbilities) {
    this.abilities.putAll(newAbilities);
    this.refreshHealth();
  }

  @Override
  public void setGears(List<Gear> newGears) {
    myGears.clear();
    myGears.addAll(newGears);
    Collections.sort(myGears);
  }

  @Override
  public void setWeapon(Weapon newWeapon) {
    myWeapon = newWeapon;
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("\n***Detailed Player's Description***\n");
    sb.append(getName());
    sb.append("\n***Player Abilities With Gears Affects***\n");
    sb.append(getAbilitiesString());
    sb.append("\n***Player is Wearing These Gears***\n");
    for (Gear gear : myGears) {
      sb.append(gear.toString());
    }
    sb.append("\n***Player is Using This Weapon***\n");
    sb.append(getWeapon().toString());
    sb.append("\n***End Of Description***\n");
    return sb.toString();
  }

}
