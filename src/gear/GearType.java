package gear;

public enum GearType {
  HEADGEAR,
  POTION,
  BELT,
  FOOTWEAR;
  
  public static int getCapacityByType(GearType gearType) {
    int units = 1;
    switch (gearType) {
      case HEADGEAR:
        units = 1;
        break;
      case POTION:
        units = Integer.MAX_VALUE;
        break;
      case BELT:
        units = 10;
        break;
      case FOOTWEAR:
        units = 1;
        break;
      default:
        break;
    }
    return units;
  }
}
