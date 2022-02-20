package com.example.tientip

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tientip.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.but1.setOnClickListener{
            val so : String = Nhap.text.toString()
            if( so.trim().length > 0 )
            {
                calculateTip()
            }
            else{
                Toast.makeText(applicationContext, "Làm ơn nhập số đi nào:((", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun calculateTip() {
        val Edit1 = binding.Nhap.text.toString()
        val cost =  Edit1.toDouble()
        val selectedId = binding.radi.checkedRadioButtonId
        val Option = when (selectedId) {
            R.id.op1 -> 0.20
            R.id.op2 -> 0.18
            else -> 0.15
        }
        var tip = Option * cost
        val ChuyenDoi = binding.switch1.isChecked
        if (ChuyenDoi) {
            tip = kotlin.math.ceil(tip)
        }
        val sTip = tip.toString()
        binding.textv3.text = sTip
    }
}