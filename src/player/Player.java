package player;

import java.util.List;
import java.util.Map;

import gear.Gear;
import weapon.Weapon;

public interface Player {
  Integer getAbbility(Ability ability);
  Map<Ability, Integer> getAbilities();
  int getHealth();
  boolean isAlive();
  void updateAfterTurn();
  Weapon getWeapon();
  void setAbbilities(Map<Ability, Integer> abilities);
  void setGears(List<Gear> newGears);
  void setWeapon(Weapon newWeapon);
}
