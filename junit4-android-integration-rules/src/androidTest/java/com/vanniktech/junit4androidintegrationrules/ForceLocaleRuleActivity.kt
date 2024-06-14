package com.vanniktech.junit4androidintegrationrules

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import java.util.Locale

class ForceLocaleRuleActivity : Activity() {
  lateinit var textView: TextView

  @SuppressLint("ResourceType") override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    textView = TextView(this).apply {
      id = 1
      text = Locale.getDefault()
    }

    setContentView(textView)
  }
}
