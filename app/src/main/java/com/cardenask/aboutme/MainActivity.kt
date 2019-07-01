package com.cardenask.aboutme

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import com.cardenask.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Padding is spacing added inside the boundary of a View or Element
    // Margin is spacing added on the outside of the boundary
    // Styles are used to extract a layout for a certain view which you have already created. Allows for reuse
    // Styles go into styles.xml
    // ScrollView can only hold one other view as a child (the view it scrolls commonly a LinearLayout which can hold other views)
    // Data Binding - special technique which connects a layout to an Activity or Fragment at compile time. Using findViewById is always
    //              done at run time. Binding class is created when the Activity is created. Access the different views without any extra
    //              overhead. Good performance gain
    // To enable Data Binding you have to make sure that you're adding the correct tag in the build.gradle for the app level gradle


    private lateinit var binding : ActivityMainBinding // Created by the compiler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.doneButton.setOnClickListener{
            addNickname(it)
        }

    }

    private fun addNickname(view: View) {

        val editText : EditText = binding.nicknameEdittxt
        val nicknameTextView : TextView = binding.nicknameText

        binding.invalidateAll()
        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE

        // Hiding keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
