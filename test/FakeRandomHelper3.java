import gear.Belt;
import gear.Gear;
import gear.GearDirect;
import gear.GearSize;
import java.util.ArrayList;
import java.util.List;


/**
 * Fake Random Helper.
 *
 *
 */
public class FakeRandomHelper3 extends FakeRandomHelper1 {
  
  private boolean overTen;
  
  public FakeRandomHelper3(boolean value) {
    this.overTen = value;
  }
  
  @Override
  public int randAffectValue() {
    return 1;
  }
  
  @Override
  public List<Gear> randGearChoices() {
    List<Gear> gears = new ArrayList<>();
    int target = 10;
    if (overTen) {
      target = 11;
    }
    for (int i = 0; i < target; ++i) {
      Gear gear = new Belt(GearSize.SMALL, 3);
      gear.setGearDirect(GearDirect.POSITIVE);
      gear.setRandAffects(this);
      gears.add(gear);
    }
    return gears;
  }
}
