package com.example.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity()
{
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
            evaluateExpression("4", clear =false)
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

        Divide.setOnClickListener {
            evaluateExpression("/", clear =false)
        }

        Multiply.setOnClickListener {
            evaluateExpression("*", clear = false)
        }

        Add.setOnClickListener {
            evaluateExpression("*", clear = false)
        }

        Minus.setOnClickListener {
            evaluateExpression("*", clear =false)
        }

        startBracket.setOnClickListener {
            evaluateExpression("*", clear = false)
        }

        closeBracket.setOnClickListener {
            evaluateExpression("*", clear = false)
        }

        clear.setOnClickListener {
            input.text = ""
            answer.text = ""
        }

       Equals.setOnClickListener {
           val text = input.text.toString()
           val expression = ExpressionBuilder(text).build()
           val result = expression.evaluate()
           val longResult = result.toLong()

           if (result == longResult.toDouble()) {
               answer.text = longResult.toString()
           }
           else {
           answer.text = result.toString()
           }

       back.setOnClickListener {
          val text = input.text.toString()
             if (text.isNotEmpty()) {
                 input.text = text.drop(1)
             }
                 answer.text = ""
             }
          }
       }
    }

    fun evaluateExpression(string: String, clear: Boolean) {
      if (clear) {
        input.text=""
        answer.text=""
        }
      else {
        input.append(string)
      }

   }
}