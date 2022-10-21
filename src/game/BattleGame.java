package game;

import java.util.Map;

import player.Player;

public interface BattleGame {
  Map<GameInfoKey, Object> runNewTurn();
  boolean isOver();
  String getStateString();
  String getResultString();
  void rematch();
}
