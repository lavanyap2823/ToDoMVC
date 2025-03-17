  Feature: Manage Todos

  @test
  Scenario: Add a new Todo
  Given the user is on the todos page
  When the user clicks in todo input Textbox
  Then the user add New Todo in the list
  Then verify add todo in the list



  # Mark StatusReportTodo as Completed
  Then the user marks a todo as completed
  Then the todo should be displayed as completed

  # Verify Active and Complted Todos
  And the user verify Active todos
  Then the user should see the Number of Active todos
  And the user verify Completed todos

  # Delete a  Completed Todos
  And the user delete a Completed todo
  Then the Completed todo should be removed from the list

  # Edit a Todos
  And the user edit a todo
  Then the todo should be updated in the list

