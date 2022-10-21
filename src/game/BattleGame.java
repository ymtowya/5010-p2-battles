package game;

import java.util.Map;

import player.Player;

public interface BattleGame {
  Map<GameInformKey, Object> newTurn();
  boolean isOver();
  String getStateString();
  String getResultString();
  void rematch();
}
