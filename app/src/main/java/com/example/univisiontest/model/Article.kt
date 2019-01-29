package com.example.univisiontest.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Article : RealmObject() {

    @PrimaryKey @JvmField
    var id: Long = 0

    @JvmField
    var cityId: String? = null
    @JvmField
    var content: String? = null


    override fun equals(obj: Any?): Boolean {
        if (obj === this) {
            return true
        }
        return if (obj is Article) {
            obj.id == id
        } else false
    }

    override fun hashCode(): Int {
        return (id % Integer.MAX_VALUE).toInt()
    }
}