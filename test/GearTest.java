import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import gear.Gear;
import gear.HeadGear;
import gear.Potion;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

/**
 * Testing the Gear.
 *
 */
public class GearTest {

  Gear gear1;
  Gear gear2;
  
  @Before
  public void setUp() throws IOException {
    gear1 = new HeadGear(1);
    gear2 = new Potion(0);
  }

  @Test
  public void testGearValid() {
    assertTrue(gear1.validForUse());
    assertFalse(gear2.validForUse());
    gear1.used();
    assertFalse(gear1.validForUse());
    assertEquals(0, 0);
  }

}
