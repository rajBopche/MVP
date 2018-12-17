package com.playground.Model.Database

import com.playground.Utils.App
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DatabaseOperations {

    private var db: AppDatabase? = null
    private var genderDao: GenderDao? = null
    var appClass = App()

    private fun performDbOperations(vararg data: String) {
        Observable.fromCallable {
            db = AppDatabase.getAppDataBase(appClass.getAppContext())
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