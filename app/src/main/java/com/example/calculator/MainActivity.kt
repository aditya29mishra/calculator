package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        num0.setOnClickListener {
            evaluateExpression("0", clear = false)
        }

        num1.setOnClickListener {
            evaluateExpression("1", clear = false)
        }

        num2.setOnClickListener {
            evaluateExpression("2", clear = false)
        }
        num3.setOnClickListener {
            evaluateExpression("3", clear = false)
        }

        num4.setOnClickListener {
            evaluateExpression("4", clear = false)
        }

        num5.setOnClickListener {
            evaluateExpression("5", clear = false)
        }

        num6.setOnClickListener {
            evaluateExpression("6", clear = false)
        }

        num7.setOnClickListener {
            evaluateExpression("7", clear = false)
        }

        num8.setOnClickListener {
            evaluateExpression("8", clear = false)
        }

        num9.setOnClickListener {
            evaluateExpression("9", clear = false)
        }

        dot.setOnClickListener {
            evaluateExpression(".", clear = false)
        }

        Divide.setOnClickListener {
            evaluateExpression("/", clear = false)
        }

        Multiply.setOnClickListener {
            evaluateExpression("*", clear = false)
        }

        Add.setOnClickListener {
            evaluateExpression("+", clear = false)
        }

        Minus.setOnClickListener {
            evaluateExpression("-", clear = false)
        }

        startBracket.setOnClickListener {
            evaluateExpression("(", clear = false)
        }

        closeBracket.setOnClickListener {
            evaluateExpression(")", clear = false)
        }

        clear.setOnClickListener {
            input.text = ""
            answer.text = ""
        }

        fact.setOnClickListener {
            try {
                val value = input.text.toString().toInt()
                val fact = factorial(value)
                input.text = "$value!"
                answer.text = "$fact"
            } catch (e: Exception) {
                answer.text = getString(R.string.error)
            }
        }

        root.setOnClickListener {
            try {
                val str: String = input.text.toString()
                val r = sqrt(str.toDouble())
                val result = r.toString()
                input.text="√$str"
                answer.text = result
            }catch (e: Exception) {
                answer.text = getString(R.string.error)
            }
        }



        Equals.setOnClickListener {
            try {
                val text = input.text.toString()
                val expression = ExpressionBuilder(text).build()
                val result = expression.evaluate()
                val longResult = result.toLong()

                if (result == longResult.toDouble()) {
                    answer.text = longResult.toString()
                } else {
                    answer.text = result.toString()
                }
            } catch (e: Exception) {
                answer.text = getString(R.string.error)
            }
        }

        back.setOnClickListener {
            var text = input.text.toString()
            if (text.isNotEmpty()) {
                text = text.substring(0, text.length - 1)
                input.text = text
            }
            answer.text = ""
        }
    }

    fun factorial(n: Int): Int {
        return if (n == 1 || n == 0) 1 else n * factorial(n - 1)
    }

    fun evaluateExpression(string: String, clear: Boolean) {
        if (clear) {
            input.text = ""
            answer.text = ""
        } else {
            input.append(string)
        }

        Log.d("my activity", "output to log")
    }
}