package randomhelper;

import gear.Belt;
import gear.Footwear;
import gear.Gear;
import gear.GearDirect;
import gear.GearSize;
import gear.HeadGear;
import gear.Potion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import player.Ability;
import weapon.Axe;
import weapon.Broadsword;
import weapon.Flail;
import weapon.Katana;
import weapon.TwoHandSword;
import weapon.Weapon;

public class BattleRandomHelper implements RandomHelper {
  
  private static final Ability[] ABILITIES = {Ability.STRENGTH,
                                              Ability.CONSTITUITION,
                                              Ability.DEXTERITY,
                                              Ability.CHARISMA};
  private static final GearSize[] GEARSIZES = {
    GearSize.LARGE, GearSize.MEDIUM, GearSize.SMALL  
  };
  private static final GearDirect[] GEARDIRECTS = {
    GearDirect.POSITIVE, GearDirect.NEGATIVE
  };
  
  Random rand;
  
  public BattleRandomHelper(int seed) {
    rand = new Random(seed);
  }

  @Override
  public int randomInt(int left, int right) {
    return rand.nextInt(right - left + 1) + left;
  }

  @Override
  public int random4Dices() {
    int result = 0;
    for (int i = 0; i < 4; ++i) {
      result += this.rand.nextInt(5) + 2;
    }
    return result;
  }

  private List<Gear> randGearsHelper(List<Gear> options, int nums) {
    Collections.shuffle(options);
    return options.subList(0, nums);
  }

  private Weapon randWeaponHelper(List<Weapon> options) {
    return options.get(this.randomInt(0, options.size() - 1));
  }
  
  private int randTerm() {
    return this.randomInt(5, 20);
  }

  @Override
  public List<Gear> randGearChoices() {
    List<Gear> resultGears = new ArrayList<>();
    List<Gear> tmpGears = new ArrayList<>();
    // HeadGear
    tmpGears.clear();
    for (int i = 0; i < randomInt(5, 8); ++i) {
      tmpGears.add(new HeadGear(randTerm()));
    }
    resultGears.addAll(randGearsHelper(tmpGears, 1));
    // Footwear
    tmpGears.clear();
    for (int i = 0; i < randomInt(5, 8); ++i) {
      tmpGears.add(new Footwear(randTerm()));
    }
    resultGears.addAll(randGearsHelper(tmpGears, 1));
    // Belts
    tmpGears.clear();
    for (int i = 0; i < randomInt(15, 20); ++i) {
      tmpGears.add(new Belt(randGearSize(), randTerm()));
    }
    for (Gear belt : randGearsHelper(tmpGears, 10)) {
      if (belt.canAddInto(resultGears)) {
        resultGears.add(belt);
      }
    }
    // Potions
    tmpGears.clear();
    int leftSpace = 20 - resultGears.size();
    for (int i = 0; i < randomInt(15, 20); ++i) {
      tmpGears.add(new Potion(randTerm()));
    }
    resultGears.addAll(randGearsHelper(tmpGears, randomInt(0, leftSpace)));
    // Assign Direct
    return resultGears;
  }

  @Override
  public Weapon randWeaponChoice() {
    List<Weapon> resList = new ArrayList<>();
    resList.add(new Axe());
    resList.add(new Flail());
    resList.add(new Katana());
    resList.add(new TwoHandSword());
    resList.add(new Broadsword());
    return randWeaponHelper(resList);
  }

  @Override
  public List<Integer> randDivideVal(Integer total, int parts) {
    final int unit = total / parts;
    final int left = total - unit * (parts - 1);
    List<Integer> resultList = new ArrayList<>();
    for (int i = 0; i < parts - 1; ++i) {
      resultList.add(unit);
    }
    resultList.add(left);
    return resultList;
  }

  @Override
  public int randAffectValue() {
    return this.randomInt(0, 15);
  }

  @Override
  public Ability randAbility() {
    return ABILITIES[this.randomInt(0, 3)];
  }

  @Override
  public GearSize randGearSize() {
    return GEARSIZES[this.randomInt(0, 2)];
  }

  @Override
  public GearDirect randGearDirect() {
    return GEARDIRECTS[this.randomInt(0, 1)];
  }

}
