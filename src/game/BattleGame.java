package game;

import java.util.Map;

import player.Player;

public interface BattleGame {
  Map<GameInformKey, Object> doAttack(Player attacker, Player victim);
}
