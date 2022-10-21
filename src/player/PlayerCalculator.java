package player;

import java.util.List;
import java.util.Map;

import gear.Gear;
import weapon.Weapon;

public interface PlayerCalculator {
  Map<String, Object> calcAttack(Player attcker, Player victim);
  void attachWeapon(Player player);
  void attachGear(Player player);
  List<Player> playersInOrder(Player player1, Player player2);
  void initPlayer(Player player);
  void resetPlayer(Player player, int value);
}
