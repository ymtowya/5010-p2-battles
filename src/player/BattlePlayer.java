package player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gear.Gear;

public class BattlePlayer implements Player {

  private Map<Ability, Integer> abilities;
  private int health;
  private List<Gear> myGears;
  
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

  @Override
  public int getHealth() {
    return this.health;
  }
  
  @Override
  public boolean isAlive() {
    return this.health > 0;
  }
  
  void loseHealth(int points) {
    this.health -= points;
    this.health = Math.max(0, this.health);
  }
  
  void gainHealth(int points) {
    this.health += points;
  }

  @Override
  public void updateAfterTurn() {
    for (Gear gear : this.myGears) {
      gear.used();
    }
    
  }
  
}