import java.util.ArrayList;

public class Category {
  private static ArrayList<Category> cats = new ArrayList<Category>();

  private String mLocation;
  private int mId;
  private String mTask;
  private ArrayList<Task> mTasks;

  public Category(String location) {
    mLocation = location;
    cats.add(this);
    mId = cats.size();
    mTasks = new ArrayList<Task>();
  }

  public String getLocation() {
    return mLocation;
  }

  public int getId() {
    return mId;
  }

  public ArrayList<Task> getTasks() {
    return mTasks;
  }

  public void addTask(Task task) {
    mTasks.add(task);
  }

  public static ArrayList<Category> all() {
    return cats;
  }
  public static void clear() {
    cats.clear();
  }

  public static Category find(int id) {
    try {
      return cats.get(id-1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }
}
