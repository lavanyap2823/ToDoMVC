#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: In order to remember the things i want to do, as a ToDo MVC user, I want to manage my ToDo List

@Scenario
Scenario: User logged on to the MVC application
Given User is on ToDoMVC Home Page

@CreateTask
Scenario Outline: MVC User Create Task in ToDo 
When User add task to ToDo list as <Task>
Then User Verify task is added under ToDo List as <Task>
And User Verify task is displayed in Active Tab as <Task>
And User Verify ToDo Count
When User Select Task from ToDo list as <Task>
Then User verify Selected Task is displayed Under All Tab as <Task>
Then User verify Selected Task is displayed Under Completed Tab as <Task>
Then User Verify ToDo Count
And User Click on Clear Button
But User verify Task is not displayed Under All Tab as <Task>
And User verify Task is not displayed Under Completed Tab <Task>
Then User Remove task from the ToDo list as <Task>
Then User verify task is removed from the List as <Task>
Examples:
| Task |
| Validate |
#| Compile |
#| Verify |
#| Install |
#| Deploy |

