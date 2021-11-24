package com.beaverlisk.android.jetpacktest.ui.common

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget


@Composable
fun loadPicture(url: String, @DrawableRes placeholderRes: Int): MutableState<Bitmap?> {
    val bitmapState: MutableState<Bitmap?> = remember { mutableStateOf(null) }
    if (url.isEmpty()) return bitmapState
    Glide.with(LocalContext.current)
        .asBitmap()
        .load(placeholderRes)
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(
                resource: Bitmap,
                transition: com.bumptech.glide.request.transition.Transition<in Bitmap>?
            ) {
                bitmapState.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                //no op
            }
        })

    Glide.with(LocalContext.current)
        .asBitmap()
        .load(url)
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(
                resource: Bitmap,
                transition: com.bumptech.glide.request.transition.Transition<in Bitmap>?
            ) {
                bitmapState.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                //no op
            }
        })
    return bitmapState
}
