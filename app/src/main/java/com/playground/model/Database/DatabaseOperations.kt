package com.playground.model.Database

import android.content.Context
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DatabaseOperations {

    private var db: AppDatabase? = null
    private var genderDao: GenderDao? = null

    @Inject
    lateinit var applicationContext: Context


    private fun performDbOperations(vararg data: String) {
        Observable.fromCallable {
            db = AppDatabase.getAppDataBase(applicationContext)
            genderDao = db?.genderDao()

            val gender1 = Gender(1, "Male")
            val gender2 = Gender(2, "Female")

            with(genderDao) {
                this?.insertGender(gender1)
                this?.insertGender(gender2)
            }
            val list = db?.genderDao()?.getGenders()

        }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe()
    }
}