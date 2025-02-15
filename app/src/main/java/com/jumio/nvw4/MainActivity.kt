package com.jumio.nvw4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jumio.nvw4.databinding.ActivityMainBinding
import com.jumio.nvw4.fragments.SettingsFragment
import com.jumio.nvw4.fragments.WebviewFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        val toolbar = binding.toolbar

        setContentView(view)
        setSupportActionBar(toolbar)

// menampilkan halaman isi url
//        if (savedInstanceState == null) {
//            supportFragmentManager
//                .beginTransaction()
//                .add(R.id.fragment_container, SettingsFragment.newInstance())
//                .commit()
//        }

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, WebviewFragment.newInstance(" https://roughly-gorgeous-cicada.ngrok-free.app/dlh"))
                .addToBackStack("webview").commitAllowingStateLoss()
        }


    }

    fun showWebview(url: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, WebviewFragment.newInstance(url))
            .addToBackStack("webview").commitAllowingStateLoss()
    }
}
