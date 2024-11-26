package com.workdev.launcher

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ResolveInfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class viewModel():ViewModel() {

    private var data: MutableLiveData<List<ResolveInfo>> = MutableLiveData<List<ResolveInfo>>()

    val ShowProductLive: LiveData<List<ResolveInfo>> get() = data




    suspend fun setup(list:List<ResolveInfo>){

        data.value=list
    }























}