package com.truedigital.navigation.me.model

import android.os.Parcel
import android.os.Parcelable

class InboxModel() : Parcelable {

    var id: String? = null
    var title: String? = null
    var description: String? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        title = parcel.readString()
        description = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<InboxModel> {
        override fun createFromParcel(parcel: Parcel): InboxModel {
            return InboxModel(parcel)
        }

        override fun newArray(size: Int): Array<InboxModel?> {
            return arrayOfNulls(size)
        }
    }
}