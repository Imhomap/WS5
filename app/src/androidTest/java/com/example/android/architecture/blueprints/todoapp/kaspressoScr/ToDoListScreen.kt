package com.example.android.architecture.blueprints.todoapp.kaspressoScr

import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.example.android.architecture.blueprints.todoapp.R

object ToDoListScreen: Screen<ToDoListScreen>() {
    val addToo = KButton {withId(R.id.add_task_fab)}

}