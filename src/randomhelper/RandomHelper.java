package randomhelper;

import java.util.List;

import gear.Gear;
import gear.GearDirect;
import gear.GearSize;
import player.Ability;
import weapon.Weapon;

public interface RandomHelper {
  int randomInt(int left, int right);
  int random4Dices();
  int randAffectValue();
  List<Gear> randGearChoices();
  Weapon randWeaponChoice();
  List<Integer> randDivideVal(Integer total, int parts);
  Ability randAbility();
  GearSize randGearSize();
  GearDirect randGearDirect();
}
