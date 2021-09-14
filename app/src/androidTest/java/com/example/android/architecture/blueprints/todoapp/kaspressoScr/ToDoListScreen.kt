package com.example.android.architecture.blueprints.todoapp.kaspressoScr

import android.view.View
import com.agoda.kakao.check.KCheckBox
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.example.android.architecture.blueprints.todoapp.R
import org.hamcrest.Matcher


object ToDoListScreen: Screen<ToDoListScreen>() {
    val addToo = KButton { withId(R.id.add_task_fab) }
    val todos = KRecyclerView(
        builder = { withId(R.id.tasks_list) },
        itemTypeBuilder = { itemType (::ToDoItem) }
    )

    class ToDoItem(parent: Matcher<View>) : KRecyclerItem<ToDoItem>(parent) {
        val toDoCheckBox = KCheckBox(parent) { withId(R.id.complete_checkbox) }
        val toDoTitle = KTextView(parent) { withId(R.id.title_text) }
    }


}