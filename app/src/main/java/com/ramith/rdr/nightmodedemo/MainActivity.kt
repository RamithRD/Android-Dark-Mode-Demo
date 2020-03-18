package com.ramith.rdr.nightmodedemo

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appThemePrefs : SharedPreferences = getSharedPreferences("AppThemePrefs", Context.MODE_PRIVATE)
        val appThemeEditor : SharedPreferences.Editor = appThemePrefs.edit()
        val isDarkModeActive : Boolean = appThemePrefs.getBoolean("nightModeStatus", false)

        if(isDarkModeActive){

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            switch_btn.text = "Disable Dark Mode"

        } else {

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            switch_btn.text = "Enable Dark Mode"

        }


        switch_btn.setOnClickListener {

            if(isDarkModeActive){

                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                appThemeEditor.putBoolean("nightModeStatus", false)
                appThemeEditor.apply()

                switch_btn.text = "Enable Dark Mode"

            } else {

                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                appThemeEditor.putBoolean("nightModeStatus", true)
                appThemeEditor.apply()

                switch_btn.text = "Disable Dark Mode"

            }


        }

    }
}
