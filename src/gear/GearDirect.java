package gear;

public enum GearDirect {
  POSITIVE,
  NEGATIVE;
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
