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

  @Test
  public void all_returnsAllInstancesOfCategory_true() {
    Category firstCategory = new Category("Home");
    Category secondCategory = new Category("Work");
    assertTrue(Category.all().contains(firstCategory));
    assertTrue(Category.all().contains(secondCategory));
  }

  @Test
  public void newId_categoryInstantiatesWithAnID_true() {
    Category myCategory = new Category ("Home");
    assertEquals(Category.all().size(), myCategory.getId());
  }

  @Test
  public void find_returnsCategoryWithSameId_secondCategory() {
    Category firstCategory = new Category("Home");
    Category secondCategory = new Category("Work");
    assertEquals(Category.find(secondCategory.getId()), secondCategory);
  }

  @Test
  public void find_returnsNullWhenNoCategoryFound_null() {
    assertTrue(Category.find(999) == null);
  }

    @Test
    public void clear_emptiesAllCategoriesFromArrayList() {
      Category myCategory = new Category("Home");
      Category.clear();
      assertEquals(Category.all().size(), 0);
    }
}
