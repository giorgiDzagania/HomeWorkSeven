package com.exercise.tbchomeworkseven

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.text.InputType
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.exercise.tbchomeworkseven.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonAdd.setOnClickListener {
            val text = binding.textTitle.text.toString()
            if (isEmpty(text)){
                Toast.makeText(this, "Title is empty!", Toast.LENGTH_SHORT).show()
            }else{
                addNewEditText()
            }
        }

        binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
            binding.checkBox.isChecked = isChecked
            if (isChecked) {
                setUpNumeric()
            } else {
                setUpCharacter()
            }
        }

    }

    private fun addNewEditText() {
        val textTitle = binding.textTitle
        val checkBox = binding.checkBox
        val newEditText = EditText(this)
        newEditText.maxLines = 1
        newEditText.filters = arrayOf(InputFilter.LengthFilter(30))
        if (checkBox.isChecked){
            textTitle.inputType = InputType.TYPE_CLASS_NUMBER
            newEditText.inputType = InputType.TYPE_CLASS_NUMBER
            newEditText.hint = "Numeric"
        }else{
            textTitle.inputType = InputType.TYPE_CLASS_TEXT
            newEditText.inputType = InputType.TYPE_CLASS_TEXT
            newEditText.hint = "Text"
            newEditText.paddingStart
        }
        textTitle.text?.clear()

        newEditText.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        val linearLayout = binding.tvNewTextView
        linearLayout.addView(newEditText)
    }


    private fun isEmpty(text: String):Boolean{
        return text.isEmpty()
    }

    private fun setUpNumeric(){
        binding.textTitle.inputType = InputType.TYPE_CLASS_NUMBER
    }

    private fun setUpCharacter(){
        binding.textTitle.inputType = InputType.TYPE_CLASS_TEXT
    }
}