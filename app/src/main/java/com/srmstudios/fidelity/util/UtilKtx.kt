package com.srmstudios.fidelity.util

import android.widget.ImageView
import androidx.core.net.toUri
import coil.load
import com.srmstudios.fidelity.R


fun ImageView.loadHttpsUrl(httpsUrl: String){
    load(httpsUrl.toUri().buildUpon().scheme("https").build()){
        placeholder(R.drawable.loading_img)
        error(R.drawable.ic_broken_image)
    }
}