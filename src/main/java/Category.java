import java.util.ArrayList;

public class Category {
  private static ArrayList<Category> cats = new ArrayList<Category>();

  private String mLocation;
  private int mId;

  public Category(String location) {
    mLocation = location;
    cats.add(this);
    mId = cats.size();
  }

  public String getLocation() {
    return mLocation;
  }

  public static ArrayList<Category> all() {
    return cats;
  }

  public int getId() {
    return mId;
  }

}
