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
            evaluateExpression("0", clear = true)
        }

        num1.setOnClickListener {
            evaluateExpression("1", clear = true)
        }

        num2.setOnClickListener {
            evaluateExpression("2", clear = true)
        }
        num3.setOnClickListener {
            evaluateExpression("3", clear = true)
        }

        num4.setOnClickListener {
            evaluateExpression("4", clear = true)
        }

        num5.setOnClickListener {
            evaluateExpression("5", clear = true)
        }

        num6.setOnClickListener {
            evaluateExpression("6", clear = true)
        }

        num7.setOnClickListener {
            evaluateExpression("7", clear = true)
        }

        num8.setOnClickListener {
            evaluateExpression("8", clear = true)
        }

        num9.setOnClickListener {
            evaluateExpression("9", clear = true)

        Divide.setOnClickListener {
            evaluateExpression("/", clear = true)
        }

        Multiply.setOnClickListener {
            evaluateExpression("*", clear = true)
        }

        Add.setOnClickListener {
            evaluateExpression("*", clear = true)
        }

        Minus.setOnClickListener {
            evaluateExpression("*", clear = true)
        }

        startBracket.setOnClickListener {
            evaluateExpression("*", clear = true)
        }

        closeBracket.setOnClickListener {
            evaluateExpression("*", clear = true)
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

   private fun evaluateExpression(string: String, clear: Boolean) {
      if (clear) {
        input.text=""
        answer.text=""
        }
      else {
        input.append(string)
      }
   }

}