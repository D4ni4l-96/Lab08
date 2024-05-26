package com.danial.lab08

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.danial.lab08.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val pizzaSizes = arrayOf("Please Select Size","Small","Medium","large","Extra Large")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)


        binding.scheduleBtn.setOnClickListener {

            var intent = Intent(this, ThanksActivity2::class.java)
            intent.putExtra("name",binding.nameEditText.text.toString())
            intent.putExtra("phone",binding.phoneEditText.text.toString())
            intent.putExtra("size",binding.sizeTextView.text.toString())
            intent.putExtra("date",binding.dateTextView.text.toString())
            intent.putExtra("time",binding.timeTextView.text.toString())

            startActivity(intent)
        }


        binding.sizeSeekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {

            // Bila seekbar bergerak / berubah nilai
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.sizeTextView.text = pizzaSizes[progress]
            }

            // Bila seekbar mula ditekan
            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            // Bila seekbar habis ditekan
            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
            binding.dateBtn.setOnClickListener {
                //get the current date
                val c = Calendar.getInstance()
                val day = c.get(Calendar.DAY_OF_MONTH)
                val month = c.get(Calendar.MONTH)
                val year = c.get(Calendar.YEAR)


                // DatePicker dialog ada 6 argument
                //1) Di mana ia keluar (this) => Ia akan keluar di MainActivity
                //2) Design / style datePicker => Default style yang dipanggil theme overlay
                //3) Listener => Setelah tarikh dipilih, what should be executed?
                //4) Default year
                //5) Default month
                //6) Default date

                val myDatePicker =
                    DatePickerDialog(
                        this,
                        android.R.style.ThemeOverlay,
                        DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                            // year, month, dayOfMonth di dalam listener merujuk kepada pilihan pengguna
                            // month start from 0, that is why we +1 here
                            binding.dateTextView.text = "$dayOfMonth/${month+1}/$year"},
                        year,
                        month,
                        day
                    )
                myDatePicker.show()

            }
        binding.timeBtn.setOnClickListener {

            val c = Calendar.getInstance() // get current date and time
            val hour = c.get(Calendar.HOUR_OF_DAY)
            val minutes = c.get(Calendar.MINUTE)

            // Membina Time Picker
            //1) Di mana ia keluar (this) => Ia akan keluar di MainActivity
            //2) Listener => Setelah time dipilih, what should be executed?
            //3) Default hour
            //4) Default minutes
            //5) 24 hours or 12 hours
            val myTimePicker = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    val hourFormatted = String.format("%02d",hourOfDay) // 1 = 01, 12 = 12
                    val minuteFormatted = String.format("%02d",minute) // 5 = 05
                    binding.timeTextView.text = "$hourFormatted:$minuteFormatted"},
                hour,
                minutes,
                true
            )
            // Menunjuk time picker
            myTimePicker.show()
        }
    }
}
