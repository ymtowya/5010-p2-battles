package game;

import java.util.List;
import java.util.Map;

import player.BattlePlayer;
import player.Player;
import player.PlayerCalculator;

public class BattleGameImpl implements BattleGame {
  private Player player1;
  private Player player2;
  private int player1InitHealth;
  private int player2InitHealth;
  private boolean playerFlag;
  private String stateString;
  private PlayerCalculator calculator;
  
  public BattleGameImpl(String name1, String name2, PlayerCalculator cal) {
    this.calculator = cal;
    this.initPlayers(name1, name2);
  }
  
  private Player getAttacker() {
    if (playerFlag) {
      return this.player1;
    }
    return this.player2;
  }
  
  private Player getVictim() {
    if (playerFlag) {
      return this.player2;
    }
    return this.player1;
  }
  
  @Override
  public Map<GameInformKey, Object> newTurn() {
    Player attacker = getAttacker();
    Player victim = getVictim();
    calculator.calcAttack(attacker, victim);
    attacker.updateAfterTurn();
    victim.updateAfterTurn();
    this.playerFlag = !this.playerFlag;
    return null;
  }
  
  private void initPlayers(String name1, String name2) {
    Player p1 = new BattlePlayer(name1);
    calculator.initPlayer(p1);
    Player p2 = new BattlePlayer(name2);
    calculator.initPlayer(p2);
    List<Player> players = calculator.playersInOrder(p1, p2);
    this.player1 = players.get(0);
    this.player2 = players.get(1);
    this.player1InitHealth = this.player1.getHealth();
    this.player2InitHealth = this.player2.getHealth();
  }
  
  @Override
  public boolean isOver() {
    return !player1.isAlive() || !player2.isAlive();
  }
  @Override
  public String getStateString() {
    // TODO Auto-generated method stub
    return null;
  }
  @Override
  public String getResultString() {
    // TODO Auto-generated method stub
    return null;
  }
  @Override
  public void rematch() {
    calculator.resetPlayer(player1, this.player1InitHealth);
    calculator.resetPlayer(player2, this.player2InitHealth);
    this.playerFlag = true;
  }
}
