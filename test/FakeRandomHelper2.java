import gear.Gear;
import java.util.ArrayList;
import java.util.List;
import weapon.Weapon;

/**
 * Fake Random Helper.
 *
 *
 */
public class FakeRandomHelper2 extends FakeRandomHelper1 {
  
  @Override
  public List<Gear> randGearChoices() {
    List<Gear> gears = new ArrayList<>();
    return gears;
  }
  
  @Override
  public Weapon randWeaponChoice() {
    return null;
  }
}
