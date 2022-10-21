package player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import game.GameInfoKey;
import gear.Gear;
import randomhelper.RandomHelper;
import weapon.Weapon;

public class BattlePlayerCalculator implements PlayerCalculator {
  
  private RandomHelper helper;

  private void takeDamage(Player victim, int damage) {
    final int oldHealth = victim.getHealth();
    final int newHealth = Math.max(0, oldHealth - damage);
    Map<Ability, Integer> newAbilities = new HashMap<>();
    List<Integer> newValues = helper.randDivideVal(newHealth, 4);
    newAbilities.put(Ability.CHARISMA, newValues.get(0));
    newAbilities.put(Ability.CONSTITUITION, newValues.get(1));
    newAbilities.put(Ability.STRENGTH, newValues.get(2));
    newAbilities.put(Ability.DEXTERITY, newValues.get(3));
    victim.setAbbilities(newAbilities);
  }
  
  private Map<GameInfoKey, Object> calcAttackHelper(Player attacker, Player victim) {
    Map<GameInfoKey, Object> resultMap = new HashMap<>();
    resultMap.put(GameInfoKey.ATTACK_CAN_BOOL, false);
    resultMap.put(GameInfoKey.ATTACK_DONE_BOOL, false);
    resultMap.put(GameInfoKey.ATTACKER_PLAYER, attacker);
    resultMap.put(GameInfoKey.ATTACKER_NAME_STR, attacker.getName());
    resultMap.put(GameInfoKey.VICTIM_PLAYER, victim);
    resultMap.put(GameInfoKey.VICTIM_NAME_STR, victim.getName());
    if (getStikePower(attacker) > getAvoidance(victim)) {
      // Can Attack
      resultMap.put(GameInfoKey.ATTACK_CAN_BOOL, true);
      int actualDamage = getActualDamage(attacker, victim);
      if (actualDamage > 0) {
        // Has actual attack
        takeDamage(victim, actualDamage);
        resultMap.put(GameInfoKey.ATTACK_DONE_BOOL, true);
        resultMap.put(GameInfoKey.ACTUAL_DAMAGE_INT, actualDamage);
      }
    }
    return resultMap;
  }
  
  @Override
  public Map<GameInfoKey, Object> calcAttack(Player attcker, Player victim) {
    return calcAttackHelper(attcker, victim);
  }

  @Override
  public void attachWeapon(Player player) {
    player.setWeapon(helper.randWeaponChoice());
  }

  @Override
  public void attachGear(Player player) {
    player.setGears(helper.randGearChoices());
  }

  protected Integer getStikePower(Player player) {
    return player.getAbbility(Ability.STRENGTH) + helper.randomInt(1, 10);
  }

  protected Integer getAvoidance(Player player) {
    return player.getAbbility(Ability.DEXTERITY) + helper.randomInt(1, 6);
  }

  protected Integer getPotentialDamage(Player player) {
    return player.getAbbility(Ability.STRENGTH) +
        helper.randomInt(0, player.getWeapon().getDamageBy(player, helper));
  }

  protected Integer getActualDamage(Player attaker, Player victim) {
    return this.getPotentialDamage(attaker) - victim.getAbbility(Ability.CONSTITUITION);
  }

  @Override
  public List<Player> playersInOrder(Player player1, Player player2) {
    List<Player> resList = new ArrayList<>();
    if (player1.getAbbility(Ability.CHARISMA) < player2.getAbbility(Ability.CHARISMA)) {
      resList.add(player2);
      resList.add(player1);
    } else {
      resList.add(player1);
      resList.add(player2);
    }
    return resList;
  }

  @Override
  public void initPlayer(Player player) {
    // Ability & Health
    int value = helper.random4Dices();
    this.resetPlayer(player, value);
  }

  @Override
  public void resetPlayer(Player player, int value) {
    // Ability & Health
    Map<Ability, Integer> initAbs = new HashMap<>();
    initAbs.put(Ability.STRENGTH, value);
    initAbs.put(Ability.DEXTERITY, value);
    initAbs.put(Ability.CONSTITUITION, value);
    initAbs.put(Ability.CHARISMA, value);
    player.setAbbilities(initAbs);
    // Gear
    player.setGears(helper.randGearChoices());
    // Weapon
    player.setWeapon(helper.randWeaponChoice());
  }
}
