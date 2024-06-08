package com.imarkoff.hci_tests

import android.app.Application
import com.imarkoff.hci_tests.data.MainDb

class App: Application() {
    val db by lazy {
        MainDb.create(this)
    }
}