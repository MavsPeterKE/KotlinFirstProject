package com.example.kotlinfirst

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnAction: Button;
    private lateinit var edFirstValue: EditText;
    private lateinit var edSecondValue: EditText;
    private lateinit var tvResult: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

        btnAction.setOnClickListener {
            validateUserInputs();
        }
    }

    private fun validateUserInputs() {
        val num1: String = edFirstValue.text.toString();
        val num2: String = edSecondValue.text.toString();

        if (num1.isEmpty() || num1 == "") {
            edFirstValue.setError("Required", null);
        } else if (num2.isEmpty() || num2 == "") {
            edSecondValue.setError("Required", null);

        } else {
            getTotalCalculation(num1, num2);
        }
    }

    private fun getTotalCalculation(input1: String, input2: String) {
        if (isInputNumeric(input1) && isInputNumeric(input2)) {
            var total = Integer.parseInt(input1) + Integer.parseInt(input2);
            tvResult.text = "Total is $total";
            tvResult.visibility = View.VISIBLE;
        } else {
            Toast.makeText(this, "Input Required should be a number", Toast.LENGTH_SHORT).show();
        }

    }

    private fun isInputNumeric(input1: String): Boolean {
        return input1.matches("\\d+".toRegex())
    }

    private fun initViews() {
        btnAction = findViewById(R.id.actionPoint);
        edFirstValue = findViewById(R.id.firstValue)
        edSecondValue = findViewById(R.id.secondValue)
        tvResult = findViewById(R.id.result)
    }
}
