package com.example.numberpuzal

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var btn6: Button
    lateinit var btn7: Button
    lateinit var btn8: Button
    lateinit var btn9: Button

    var mybuton = ArrayList<Button>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)

        mybuton.add(btn1)
        mybuton.add(btn2)
        mybuton.add(btn3)
        mybuton.add(btn4)
        mybuton.add(btn5)
        mybuton.add(btn6)
        mybuton.add(btn7)
        mybuton.add(btn8)
        mybuton.add(btn9)

        click(0)
        click(1)
        click(2)
        click(3)
        click(4)
        click(5)
        click(6)
        click(7)
        click(8)

    }

    fun click(i: Int) {
        mybuton[i].setOnClickListener {

            if (i == 0) {
                change(0, 1)
                change(0, 3)
                change(0, 1, 2)
                change(0, 3, 6)
            }
            if (i == 1) {
                change(1, 2)
                change(1, 0)
                change(1, 4)
                change(1, 4, 7)

            }
            if (i == 2) {
                change(2, 1)
                change(2, 5)
                change(2, 1, 0)
                change(2, 5, 8)

            }
            if (i == 3) {
                change(3, 0)
                change(3, 4)
                change(3, 6)
                change(3, 4, 5)

            }
            if (i == 4) {
                change(4, 1)
                change(4, 3)
                change(4, 5)
                change(4, 7)

            }
            if (i == 5) {
                change(5, 2)
                change(5, 4)
                change(5, 8)
                change(5, 4, 3)

            }
            if (i == 6) {
                change(6, 3)
                change(6, 7)
                change(6, 3, 0)
                change(6, 7, 8)

            }
            if (i == 7) {
                change(7, 6)
                change(7, 4)
                change(7, 8)
                change(7, 4, 1)
            }
            if (i == 8) {
                change(8, 5)
                change(8, 7)
                change(8, 7, 6)
                change(8, 5, 2)

            }
            if (mybuton[0].text.toString().equals("1") && mybuton[1].text.toString()
                    .equals("2") && mybuton[2].text.toString().equals("3") && mybuton[3].text.toString()
                    .equals("4") && mybuton[4].text.toString().equals("5") && mybuton[5].text.toString()
                    .equals("6") && mybuton[6].text.toString().equals("7") && mybuton[7].text.toString()
                    .equals("8")
            ) {
                Toast.makeText(this@MainActivity, "you are win", Toast.LENGTH_LONG).show()
                showWinDialog()
            }
            else
            {

            }

        }

    }

    private fun showWinDialog() {

        val dialogView = layoutInflater.inflate(R.layout.win_dialog, null)
        val dialog = AlertDialog.Builder(this).setView(dialogView).setCancelable(false).create()
        dialog.show()
        val btnOk = dialogView.findViewById<Button>(R.id.btn_ok)
        btnOk.setOnClickListener {
            dialog.dismiss()
            val ab = ArrayList<String>()
            repeat(9) {
                while (true) {
                    val a = (Math.random() * 9).toInt()
                    if (!ab.contains("$a")) {
                        ab.add("$a")
                        break
                    }
                }
            }
            ab[ab.indexOf("0")] = ""
            ab.forEachIndexed { index, _ ->
                mybuton[index].text = ab[index]
            }
        }
    }

    private fun change(first: Int, second: Int) {

        if (mybuton[second].text.toString().isEmpty()) {

            mybuton[second].setText(mybuton[first].text.toString())
            mybuton[first].setText("")

        }
    }

    private fun change(first: Int, second: Int, third: Int) {

        if (mybuton[third].text.toString().isEmpty()) {

            mybuton[third].setText(mybuton[second].text.toString())
            mybuton[second].setText(mybuton[first].text.toString())
            mybuton[first].setText("")

        }

    }

}