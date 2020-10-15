package org.example.dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_dialog.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDialogCancelable.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Dialog Cancelable")
            dialog.setMessage("Dialog cancelable bisa ditutup dengan klik bagian luar dialog")
            dialog.setCancelable(true)

            dialog.show()
        }

        btnDialogNonCancelable.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Dialog Non Cancelable")
            dialog.setMessage("Dialog Non Cancelable harus ditutup dari tombol Action")
            dialog.setCancelable(false)

            dialog.setPositiveButton("Tutup") { dialogInterface, p1 ->
                dialogInterface.dismiss()
            }

            dialog.show()
        }

        btnDialogPositiveNegative.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Dialog Dengan Button")
            dialog.setMessage("Dialog Dengan Button untuk berbagai Aksi")
            dialog.setIcon(R.mipmap.ic_launcher)

            dialog.setCancelable(false)
            dialog.setPositiveButton("Positive Button"){dialogInterface, p1 ->
                Toast.makeText(this,"Positive Button Clicked",Toast.LENGTH_LONG).show()
            }

            dialog.setNegativeButton("Negative Button"){dialogInterface, p1->
                Toast.makeText(this,"Negative Button Clicked",Toast.LENGTH_LONG).show()
            }

            dialog.setNeutralButton("Neutral Button"){dialogInterface, p1->
                Toast.makeText(this,"Neutral Button Clicked",Toast.LENGTH_LONG).show()
            }

            dialog.show()
        }

        btnCustomDialog.setOnClickListener {
            val view = LayoutInflater.from(this).inflate(R.layout.custom_dialog,null,false)
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setView(view)

            val dialog = dialogBuilder.create()

            view.btnTutup.setOnClickListener {
                Toast.makeText(this,"Custom Dialog Closed",Toast.LENGTH_LONG).show()
                dialog.dismiss()
            }

            dialog.show()
        }

        btnFragmentDialog.setOnClickListener {
            val dialogFragment = ExampleDialogFragment()
            dialogFragment.show(supportFragmentManager,null)
        }

        btnFragmentDialogData.setOnClickListener {
            val dialogFragment = ExampleDialogFragment(etName.text.toString())
            dialogFragment.show(supportFragmentManager,null)
        }
    }
}