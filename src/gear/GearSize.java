package gear;

/**
 * Size of Gear.
 *
 *
 */
public enum GearSize {
  SMALL,
  MEDIUM,
  LARGE,
  NA;
  
  /**
   * Return the unit of the size.
   *
   * @param gearSize the direct
   * @return the unit
   */
  public static int getUnitBySize(GearSize gearSize) {
    int res = 1;
    switch (gearSize) {
      case SMALL:
        res = 1;
        break;
      case MEDIUM:
        res = 2;
        break;
      case LARGE:
        res = 4;
        break;
      case NA:
      default:
        res = 1;
        break;
    }
    return res;
  }
}
