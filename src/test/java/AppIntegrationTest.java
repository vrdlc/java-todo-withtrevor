import java.util.ArrayList;

import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AppIntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Todo list!");
  }

  @Test
  public void cateogryIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a new Category"));
    fill("#name").with("Home");
    submit(".btn");
    assertThat(pageSource()).contains("Your category has been saved.");
  }

  @Test
  public void categoryIsDisplayedTest() {
    goTo("http://localhost:4567/categories/new");
    fill("#name").with("Home");
    submit(".btn");
    click("a", withText("View categories"));
    assertThat(pageSource()).contains("Home");
  }

  @Test
  public void categoryTasksFormIsDisplayed() {
    goTo("http://localhost:4567/categories/new");
    fill("#name").with("Shopping");
    submit(".btn");
    click("a", withText("View categories"));
    click("a", withText("Shopping"));
    click("a", withText("Add a new task"));
    assertThat(pageSource()).contains("Add a Task to Shopping");
  }

  @Test
  public void tasksIsAddedAndDisplayed() {
    goTo("http://localhost:4567/categories/new");
    fill("#name").with("Banking");
    submit(".btn");
    click("a", withText("View categories"));
    click("a", withText("Banking"));
    click("a", withText("Add a new task"));
    fill("#description").with("Deposit paycheck");
    submit(".btn");
    assertThat(pageSource()).contains("Deposit paycheck");
  }

//   @Test
//   public void taskIsDisplayedTest() {
//     goTo("http://localhost:4567/tasks/new");
//     fill("#description").with("Mow the lawn");
//     submit(".btn");
//     click("a", withText("View all tasks"));
//     assertThat(pageSource()).contains("Mow the lawn");
//   }
//
//   @Test
//   public void multipleTasksAreDisplayedTest() {
//     goTo("http://localhost:4567/tasks/new");
//     fill("#description").with("Mow the lawn");
//     submit(".btn");
//     goTo("http://localhost:4567/tasks/new");
//     fill("#description").with("Buy groceries");
//     submit(".btn");
//     click("a", withText("View all tasks"));
//     assertThat(pageSource()).contains("Mow the lawn");
//     assertThat(pageSource()).contains("Buy groceries");
//   }
}
