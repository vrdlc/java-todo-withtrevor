import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;

public class CategoryTest {


  @Test
  public void category_instantiatesCorrectly_true() {
    Category myCategory = new Category("Home");
    assertEquals(true, myCategory instanceof Category);
  }

  @Test
  public void category_intantiatesWithLocation_true() {
    Category myCategory = new Category("Home");
    assertEquals("Home", myCategory.getLocation());
  }

}
