package com.example.android.architecture.blueprints.todoapp.kaspressoTest

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.rules.activityScenarioRule
import com.example.android.architecture.blueprints.todoapp.kaspressoScr.AddToDoScr
import com.example.android.architecture.blueprints.todoapp.kaspressoScr.ToDoListScreen
import com.example.android.architecture.blueprints.todoapp.tasks.TasksActivity
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

class  ToDoListTest: TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(TasksActivity::class.java)

    @Test
    fun checkAddToDo() = run {
        step("Click on add TODO button") {
            ToDoListScreen{
                addToo{
                    click()
                }
        }
        }
        step("Creating a new TODO") {
        AddToDoScr {
            title {
                replaceText("MY MY MY TODO")
            }
            description {
                replaceText("BLA BLA BLA.....")
            }
            saveButton {
                click()
            }
        }
        }

        step("Checking created TODO") {
            ToDoListScreen {
                todos.childAt<ToDoListScreen.ToDoItem>(2) {
                    toDoTitle {
                        isDisplayed()
                        hasText("MY MY MY TODO")
                    }
                    toDoCheckBox {
                        isNotChecked()
                    }

                }
                todos {
                    hasSize(3)
                }
            }
        }
    }


}