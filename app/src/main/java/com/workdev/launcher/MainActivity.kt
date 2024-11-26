package com.workdev.launcher

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ResolveInfo
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.workdev.launcher.databinding.ActivityMainBinding
import eightbitlab.com.blurview.RenderScriptBlur
import kotlinx.coroutines.coroutineScope

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    val  viewmodel:viewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)










































        lifecycleScope.launchWhenCreated {
            viewmodel.setup( getInstalledApps())
        }


        binding.recycler.layoutManager = LinearLayoutManager(this)


        viewmodel.ShowProductLive.observe(this){

            val adapter = AdapterColor(it,packageManager) { app ->
                // تشغيل التطبيق عند النقر عليه

                val launchIntent = packageManager.getLaunchIntentForPackage(app.activityInfo.packageName)
                startActivity(launchIntent)
            }
            binding.recycler.adapter = adapter


        }






































    }


















    @SuppressLint("QueryPermissionsNeeded")
    private fun getInstalledApps(): List<ResolveInfo> {
        val pm = packageManager
        val intent = Intent(Intent.ACTION_MAIN, null).apply {
            addCategory(Intent.CATEGORY_LAUNCHER)
        }
        return pm.queryIntentActivities(intent, 0)
    }





}