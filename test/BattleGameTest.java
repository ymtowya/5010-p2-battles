import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import game.BattleGame;
import game.BattleGameImpl;
import game.GameInfoKey;
import gear.Belt;
import gear.Footwear;
import gear.Gear;
import gear.GearDirect;
import gear.GearSize;
import gear.HeadGear;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import player.Ability;
import player.BattlePlayer;
import player.BattlePlayerCalculator;
import player.Player;
import player.PlayerCalculator;
import randomhelper.BattleRandomHelper;
import randomhelper.RandomHelper;

/**
 * Testing the Battle Game.
 *
 *
 */
public class BattleGameTest {

  BattleGame game;
  RandomHelper helper1;
  RandomHelper helper2;
  RandomHelper helper3;
  RandomHelper helper4;
  PlayerCalculator calculator;
  Player player1;
  Player player2;

  private Map<Ability, Integer> getMaps(int value) {
    Map<Ability, Integer> initAbs = new HashMap<>();
    initAbs.put(Ability.STRENGTH, value);
    initAbs.put(Ability.DEXTERITY, value);
    initAbs.put(Ability.CONSTITUITION, value);
    initAbs.put(Ability.CHARISMA, value);
    return initAbs;
  }

  /**
   * Set up beforehand.
   *
   * @throws Exception when error
   */
  @Before
  public void setUp() throws IOException {
    helper1 = new FakeRandomHelper1();
    helper2 = new BattleRandomHelper(6);
    helper3 = new FakeRandomHelper2();
    calculator = new BattlePlayerCalculator(helper1);
    game = new BattleGameImpl("Charlie", "Fionna", calculator);
    player1 = new BattlePlayer("Naomi");
    player2 = new BattlePlayer("Trisha");
    calculator.resetPlayer(player1, 26);
    calculator.resetPlayer(player2, 21);
  }

  @Test
  public void testWeapon() {
    calculator.changeHelper(helper1);
    Map<GameInfoKey, Object> resMap = calculator.calcAttack(player1, player2);
    int damage = (int) resMap.get(GameInfoKey.ACTUAL_DAMAGE_INT);
    assertEquals(damage, 8);
  }

  @Test
  public void testAbilityRange() {
    calculator.changeHelper(helper1);
    calculator.initPlayer(player1);
    Map<Ability, Integer> abilities = player1.getAbilities();
    for (Integer value : abilities.values()) {
      assertTrue(value < 100);
      assertTrue(value >= 0);
    }
  }

  @Test
  public void testAbilityBasic() {
    calculator.changeHelper(helper1);
    calculator.initPlayer(player1);
    calculator.attachGear(player1);
    assertEquals((int) player1.getAbbility(Ability.STRENGTH), 19);
    for (int i = 0; i < 3; ++i) {
      player1.updateAfterTurn();
    }
    assertEquals((int) player1.getAbbility(Ability.STRENGTH), 16);
  }

  @Test
  public void testHealth() {
    calculator.changeHelper(helper1);
    calculator.initPlayer(player1);
    calculator.attachGear(player1);
    assertEquals(64, player1.getHealth());
    calculator.calcAttack(player2, player1);
    assertEquals(56, player1.getHealth());
  }

  @Test
  public void testPowerAndDamage() {
    calculator.changeHelper(helper1);
    calculator.initPlayer(player1);
    calculator.attachGear(player1);
    Map<Ability, Integer> map = new HashMap<>();
    map.put(Ability.CONSTITUITION, 10);
    map.put(Ability.DEXTERITY, 1);
    player2.setAbbilities(map);

    assertEquals(20, calculator.getStikePower(player1).intValue());
    assertEquals(2, calculator.getAvoidance(player2).intValue());
    assertEquals(19, calculator.getPotentialDamage(player1).intValue());
    assertEquals(9, calculator.getActualDamage(player1, player2).intValue());

    // Positive Damage
    assertEquals(53, player2.getHealth());
    calculator.calcAttack(player1, player2);
    // System.out.println(resMap);
    assertEquals(44, player2.getHealth());
  }

  @Test
  public void testNegativeDamage() {
    calculator.changeHelper(helper1);
    calculator.initPlayer(player1);
    calculator.attachGear(player1);
    Map<Ability, Integer> map = new HashMap<>();
    map.put(Ability.DEXTERITY, 1);
    player2.setAbbilities(map);
    assertEquals(-2, calculator.getActualDamage(player1, player2).intValue());

    // Negative Damage
    assertEquals(64, player2.getHealth());
    calculator.calcAttack(player1, player2);
    assertEquals(64, player2.getHealth());
  }

  @Test
  public void enterArena() {
    calculator.changeHelper(helper3);
    calculator.initPlayer(player1);
    assertEquals(16, player1.getAbbility(Ability.STRENGTH).intValue());
    calculator.changeHelper(helper1);
    calculator.attachGear(player1);
    assertEquals(19, player1.getAbbility(Ability.STRENGTH).intValue());
  }

  @Test
  public void onlyOneHead() {
    calculator.changeHelper(helper2);
    calculator.initPlayer(player1);
    calculator.attachGear(player1);
    List<Gear> gears = helper2.randGearChoices();
    int count = 0;
    for (Gear gear : gears) {
      if (gear instanceof HeadGear) {
        count++;
      }
    }
    assertTrue(count <= 1);
  }

  @Test
  public void onlyOneFootwear() {
    calculator.changeHelper(helper2);
    calculator.initPlayer(player1);
    calculator.attachGear(player1);
    List<Gear> gears = helper2.randGearChoices();
    int count = 0;
    for (Gear gear : gears) {
      if (gear instanceof Footwear) {
        count++;
      }
    }
    assertTrue(count <= 1);
  }

  @Test
  public void tenUnitsBelt() {
    helper4 = new FakeRandomHelper3(false);
    calculator.changeHelper(helper4);
    calculator.initPlayer(player1);
    calculator.attachGear(player1);
    assertEquals(26, player1.getAbbility(Ability.STRENGTH).intValue());
    assertEquals(26, player1.getAbbility(Ability.STRENGTH).intValue());
  }

  @Test
  public void tenBeltOver10() {
    List<Gear> gears = new ArrayList<>();
    for (int i = 0; i < 10; ++i) {
      Gear gear = new Belt(GearSize.SMALL, 3);
      gear.setGearDirect(GearDirect.POSITIVE);
      gears.add(gear);
    }
    Gear myGear = new Belt(GearSize.SMALL, 2);
    assertFalse(myGear.canAddInto(gears));
  }

  @Test
  public void testEquipped() {
    calculator.changeHelper(helper2);
    calculator.initPlayer(player1);
    calculator.attachGear(player1);
    String details = player1.toString();
    assertTrue(details.contains("Gear: HeadGear"));
    assertTrue(details.contains("Gear: Potion"));
    assertTrue(details.contains("Gear: SMALL Belt") || details.contains("Gear: MEDIUM Belt")
        || details.contains("Gear: LARGE Belt"));
    assertTrue(details.contains("Gear: Footwear"));
  }

  @Test
  public void testTurn() {
    calculator.changeHelper(helper2);
    game = new BattleGameImpl("Charlie", "Fionna", calculator);
    Map<GameInfoKey, Object> resMap = game.runNewTurn();
    System.out.println(resMap);
    //    String p1 = (String) resMap.get(GameInfoKey.ATTACKER_NAME_STR);
    //    String p2 = (String) resMap.get(GameInfoKey.VICTIM_NAME_STR);
  }

}
