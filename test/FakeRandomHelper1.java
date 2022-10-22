import gear.Gear;
import gear.GearDirect;
import gear.GearSize;
import gear.Potion;
import java.util.ArrayList;
import java.util.List;
import player.Ability;
import randomhelper.RandomHelper;
import weapon.Axe;
import weapon.Weapon;

/**
 * Fake Random Helper.
 *
 *
 */
public class FakeRandomHelper1 implements RandomHelper {

  @Override
  public int randomInt(int left, int right) {
    return left;
  }

  @Override
  public int random4Dices() {
    return 16;
  }

  @Override
  public int randAffectValue() {
    return 3;
  }

  @Override
  public List<Gear> randGearChoices() {
    List<Gear> gears = new ArrayList<>();
    Gear gear = new Potion(3);
    gear.setGearDirect(GearDirect.POSITIVE);
    gear.setRandAffects(this);
    gears.add(gear);
    return gears;
  }

  @Override
  public Weapon randWeaponChoice() {
    return new Axe();
  }

  @Override
  public List<Integer> randDivideVal(Integer total, int parts) {
    final int unit = Math.floorDiv(total, parts);
    final int left = total - unit * (parts - 1);
    List<Integer> resultList = new ArrayList<>(parts);
    for (int i = 0; i < parts; ++i) {
      resultList.add(unit);
    }
    resultList.set(randomInt(0, parts - 1), left);
    return resultList;
  }

  @Override
  public Ability randAbility() {
    return Ability.STRENGTH;
  }

  @Override
  public GearSize randGearSize() {
    return GearSize.LARGE;
  }

  @Override
  public GearDirect randGearDirect() {
    return GearDirect.POSITIVE;
  }

}
