package player;

import java.util.Map;

public interface Player {
  Integer getAbbility(Ability ability);
  Map<Ability, Integer> getAbilities();
  int getHealth();
  boolean isAlive();
  void updateAfterTurn();
}
