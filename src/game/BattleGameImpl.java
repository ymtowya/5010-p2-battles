package game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import player.BattlePlayer;
import player.Player;
import player.PlayerCalculator;

/**
 * One implementation of the Battle Game.
 *
 *
 */
public class BattleGameImpl implements BattleGame {
  private Player player1;
  private Player player2;
  private int player1InitHealth;
  private int player2InitHealth;
  private boolean playerFlag;
  private String stateString;
  private PlayerCalculator calculator;
  
  /**
   * Initialize the Battle Game.
   *
   * @param name1 Player 1 's name
   * @param name2 Player 2 's name
   * @param cal Calculator to compute game process
   */
  public BattleGameImpl(String name1, String name2, PlayerCalculator cal) {
    this.calculator = cal;
    this.playerFlag = true;
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
  
  private String getAttckResString(Map<GameInfoKey, Object> attackMap) {
    StringBuilder sb = new StringBuilder();
    sb.append("-----Attack-----\n")
        .append("{%s} --attacks-> {%s}\n")
        .append("Result: %s\n")
        .append("Attack Times: %d\n")
        .append("Caused Damage: %d\n")
        .append("----------------\n");
    final String attName = (String) attackMap.get(GameInfoKey.ATTACKER_NAME_STR);
    final String vicName = (String) attackMap.get(GameInfoKey.VICTIM_NAME_STR);
    final boolean attempt = (boolean) attackMap.get(GameInfoKey.ATTACK_DONE_BOOL);
    final String resState = attempt ? "Success" : "Fail";
    final int attkTimes = (int) attackMap.get(GameInfoKey.ATTACK_TIMES_INT);
    final int damage = attempt
        ? (int) attackMap.get(GameInfoKey.ACTUAL_DAMAGE_INT) : 0;
    
    return String.format(sb.toString(), 
        attName, vicName, resState, attkTimes, damage);
  }
  
  @Override
  public Map<GameInfoKey, Object> runNewTurn() {
    Player attacker = getAttacker();
    Player victim = getVictim();
    Map<GameInfoKey, Object> resMap = new HashMap<>();
    Map<GameInfoKey, Object> attackMap = calculator.calcAttack(attacker, victim);
    resMap.put(GameInfoKey.DETAIL_MAP, attackMap);
    this.stateString = this.getAttckResString(attackMap);
    resMap.put(GameInfoKey.STATE_STR, new String(this.stateString));
    attacker.updateAfterTurn();
    victim.updateAfterTurn();
    this.playerFlag = !(this.playerFlag);
    return resMap;
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
    this.stateString = "----Players Initialised----\n";
  }
  
  @Override
  public boolean isOver() {
    return !player1.isAlive() || !player2.isAlive();
  }
  
  @Override
  public String getStateString() {
    return this.stateString;
  }
  
  @Override
  public String getResultString() {
    if (!isOver()) {
      return "Game is not over yet\n";
    }
    boolean p1Done = !player1.isAlive();
    boolean p2Done = !player2.isAlive();
    if (p1Done && p2Done) {
      return "Game ends in a DRAW\n";
    }
    if (p1Done) {
      // Winner is P2
      return String.format("Game ends. Winner is %s.\n",
          player2.getName());
    }
    if (p2Done) {
      return String.format("Game ends. Winner is %s.\n",
          player1.getName());
    }
    return "Unknown State\n";
  }
  
  @Override
  public void rematch() {
    calculator.resetPlayer(player1, this.player1InitHealth);
    calculator.resetPlayer(player2, this.player2InitHealth);
    this.playerFlag = true;
    this.stateString = "----Game Restarted----\n";
  }

  @Override
  public String getPlayersString() {
    final String res = String.format("\nPlayer :\n%s\nPlayer :\n%s\n",
        player1.toString(),
        player2.toString());
    return res;
  }
}
