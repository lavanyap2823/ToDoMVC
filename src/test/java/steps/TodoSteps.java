package steps;

import com.config.TestDataManager;
import com.pages.HomePage;
import driver.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;



public class TodoSteps {

    TestDataManager testDataManager = Hooks.testDataManager;
    HomePage homePage = new HomePage();

    String editedTodo;

    @Given("the user is on the todos page")
    public void theUserIsOnTheTodosPage() {
        Driver.getdriver.get(testDataManager.url());
    }

    @When("the user clicks in todo input Textbox")
    public void theUserClicksAddTodoButton() {
        homePage.clickAddToDo();
    }

    @When("the user add New Todo in the list")
    public void theUserAddNewTodoInList() {
        homePage.addNewTodo(testDataManager.newtodo1());
        homePage.enter();
        homePage.addNewTodo(testDataManager.newtodo2());
        homePage.enter();
        homePage.addNewTodo(testDataManager.newtodo3());
        homePage.enter();
    }

    @When("verify add todo in the list")
    public void theUserVerifyAddNewTodoInList() {
        Assert.assertEquals(testDataManager.newtodo1(), homePage.listOfTodos(testDataManager.newtodo1()));
    }

    @When("the user marks a todo as completed")
    public void markTodoAscompleted() {
        homePage.clickOnTodoCheckbox(testDataManager.newtodo1());
    }

    @Then("the todo should be displayed as completed")
    public void theTodoShouldBeCompleted() {
        Assert.assertEquals(testDataManager.newtodo1(), homePage.verifyCompletedTodo(testDataManager.newtodo1()));
    }

    @Then("the user verify Active todos")
    public void verifyActiveTodos() {
        homePage.clickActiveLink();
        Assert.assertTrue(homePage.verifyTodoList(testDataManager.newtodo2()));
        Assert.assertTrue(homePage.verifyTodoList(testDataManager.newtodo3()));
    }

    @Then("the user should see the Number of Active todos")
    public void verifyNoOfActiveTodos() {
        Assert.assertEquals("2", homePage.getTodoCount());
    }

    @Then("the user verify Completed todos")
    public void verifyCompletedTodos() {
        homePage.clickCompletedLink();
        Assert.assertTrue(homePage.verifyTodoList(testDataManager.newtodo1()));
    }

    @Then("the user delete a Completed todo")
    public void deleteCompletedTodo() {
        homePage.clickClearCompletedLink();
    }

    @Then("the Completed todo should be removed from the list")
    public void verifydeleteCompletedTodo() {
        Assert.assertFalse(homePage.verifyTodoList(testDataManager.newtodo1()));
    }

    @Then("the user edit a todo")
    public void editTodo() {
        homePage.clickAllLink();
        editedTodo = testDataManager.newtodo2() + " edited";
        homePage.doubleClickonTodo(testDataManager.newtodo2(), editedTodo);
    }

    @Then("the todo should be updated in the list")
    public void verifyEditTodoinList() {
        Assert.assertTrue(homePage.verifyTodoList(editedTodo));
    }

    // Other steps for Edit, Delete, etc.
}

