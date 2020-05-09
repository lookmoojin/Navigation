package com.truedigital.navigation.article.extension

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.bumptech.glide.request.target.ImageViewTarget
import com.bumptech.glide.request.target.SimpleTarget
import java.io.File

fun ImageView?.load(context: Context?,
                    url: String?,
                    placeholder: Int? = null,
                    scaleType: ImageView.ScaleType = ImageView.ScaleType.FIT_CENTER) {

    if (isValidate(this, context)) {
        initGlide(context!!, url, placeholder, scaleType)
                .into(this!!)
    }
}

fun ImageView?.loadWithErrorImage(context: Context?,
                                  url: String?,
                                  errorImage: Int? = null,
                                  scaleType: ImageView.ScaleType = ImageView.ScaleType.FIT_CENTER) {

    if (isValidate(this, context)) {
        initGlideWithErrorImage(context!!, url, errorImage, scaleType)
                .into(this!!)
    }
}

fun ImageView?.loadCircle(context: Context?,
                          url: String?,
                          placeholder: Int?,
                          scaleType: ImageView.ScaleType = ImageView.ScaleType.FIT_CENTER,
                          listener: ((Drawable) -> Unit)? = null) {

    if (isValidate(this, context)) {
        initGlideAsBitmap(context!!, url, placeholder, scaleType)
                .into(object : BitmapImageViewTarget(this) {
                    override fun setResource(resource: Bitmap?) {
                        val circularBitmapDrawable = RoundedBitmapDrawableFactory
                                .create(context!!.resources, resource)
                                .apply {
                                    isCircular = true
                                }
                        view.setImageDrawable(circularBitmapDrawable)
                        listener?.invoke(circularBitmapDrawable)
                    }
                })
    }
}

fun ImageView?.loadFileCircle(context: Context?,
                              file: File?,
                              placeholder: Int?,
                              scaleType: ImageView.ScaleType = ImageView.ScaleType.FIT_CENTER,
                              listener: ((Drawable) -> Unit)? = null) {
    if (isValidate(this, context)) {
        Glide.with(context!!)
                .asBitmap()
                .load(file)
                .apply(RequestOptions()
                        .apply {
                            diskCacheStrategy(DiskCacheStrategy.NONE)
                            skipMemoryCache(true)
                        }
                        .apply {
                            placeholder?.let {
                                placeholder(it)
                                error(it)
                            }
                        }
                        .apply {
                            if (scaleType == ImageView.ScaleType.FIT_CENTER) {
                                this.fitCenter()
                            } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                                this.centerCrop()
                            }
                        })
                .into(object : BitmapImageViewTarget(this) {
                    override fun setResource(resource: Bitmap?) {
                        val circularBitmapDrawable = RoundedBitmapDrawableFactory
                                .create(context!!.resources, resource)
                                .apply {
                                    isCircular = true
                                }
                        view.setImageDrawable(circularBitmapDrawable)
                        listener?.invoke(circularBitmapDrawable)
                    }
                })
    }
}

fun ImageView?.loadGift(context: Context?, resource: Int?, placeholder: Int? = null) {

    if (isValidate(this, context)) {
        Glide.with(context!!)
                .asGif()
                .load(resource)
                .apply(RequestOptions()
                        .apply {
                            placeholder?.let {
                                error(it)
                            }
                        })
                .into(this!!)
    }
}

fun loadAsBitmap(context: Context, url: String): Bitmap {
    //Call this on background thread
    return Glide.with(context).asBitmap().load(url).submit().get()
}


fun loadAsBitmap(context: Context?, url: String, target: SimpleTarget<Bitmap>) {
    if (context == null || !context.isValidForGlide()) return
    initGlideAsBitmap(context, url, null)
            .into(target)
}

fun loadAsBitmap(context: Context?, url: String, placeholder: Int? = null, target: ImageViewTarget<Bitmap>) {
    if (context == null || !context.isValidForGlide()) return
    initGlideAsBitmap(context, url, placeholder)
            .into(target)
}

fun ImageView?.cancelLoad() {
    this?.let { Glide.with(it).clear(it) }
}

private fun initGlide(context: Context,
                      url: String?,
                      placeholder: Int? = null,
                      scaleType: ImageView.ScaleType? = ImageView.ScaleType.FIT_CENTER): RequestBuilder<Drawable> {

    return Glide.with(context)
            .load(url)
            .apply(RequestOptions()
                    .apply {
                        placeholder?.let {
                            placeholder(it)
                            error(it)
                        }
                    }
                    .apply {
                        if (scaleType == ImageView.ScaleType.FIT_CENTER) {
                            this.fitCenter()
                        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                            this.centerCrop()
                        }
                    }

            )
}

private fun initGlideAsBitmap(context: Context,
                              url: String?,
                              placeholder: Int? = null,
                              scaleType: ImageView.ScaleType = ImageView.ScaleType.FIT_CENTER): RequestBuilder<Bitmap> {

    return Glide.with(context)
            .asBitmap()
            .load(url)
            .apply(RequestOptions()
                    .apply {
                        placeholder?.let {
                            this.placeholder(it)
                            this.error(it)
                        }
                    }
                    .apply {
                        if (scaleType == ImageView.ScaleType.FIT_CENTER) {
                            this.fitCenter()
                        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                            this.centerCrop()
                        }
                    })
}

private fun initGlideWithErrorImage(context: Context,
                                    url: String?,
                                    errorImage: Int? = null,
                                    scaleType: ImageView.ScaleType? = ImageView.ScaleType.FIT_CENTER): RequestBuilder<Drawable> {

    return Glide.with(context)
            .load(url)
            .apply(RequestOptions()
                    .apply {
                        errorImage?.let {
                            error(it)
                        }
                    }
                    .apply {
                        if (scaleType == ImageView.ScaleType.FIT_CENTER) {
                            this.fitCenter()
                        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                            this.centerCrop()
                        }
                    }

            )
}

private fun isValidate(imageView: ImageView?, context: Context?): Boolean {
    return (imageView != null && context != null && context.isValidForGlide())
}

private fun Context.isValidForGlide(): Boolean {
    return if (this is Activity) {
        !this.isDestroyed
    } else {
        true
    }
}