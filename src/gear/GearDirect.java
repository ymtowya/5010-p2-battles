package gear;

/**
 * Direct of Gear.
 *
 *
 */
public enum GearDirect {
  POSITIVE,
  NEGATIVE;
  
  /**
   * Return the coefficient of the direct.
   *
   * @param direct the direct
   * @return the coefficient
   */
  public static int getIndex(GearDirect direct) {
    int res = 1;
    switch (direct) {
      case NEGATIVE:
        res = -1;
        break;
      case POSITIVE:
      default:
        res = 1;
        break;
    }
    return res;
  }
}
