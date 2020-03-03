package tw.nekomimi.nekogram.utils

import android.content.SharedPreferences
import org.telegram.messenger.FileLog

object PrefUtil {

    @JvmStatic
    fun shiftPref(pref: SharedPreferences, prefPref: SharedPreferences) {

        runCatching {

            val editor = prefPref.edit()

            pref.all.forEach { (key, value) ->

                if (value is String) {

                    editor.putString(key, value)

                } else if (value is Set<*>) {

                    editor.putStringSet(key, value as Set<String>)

                } else if (value is Int) {

                    editor.putInt(key, value)

                } else if (value is Long) {

                    editor.putLong(key, value)

                } else if (value is Float) {

                    editor.putFloat(key, value)

                } else if (value is Boolean) {

                    editor.putBoolean(key, value)

                }

            }

            editor.apply()

            pref.edit().clear().apply()

        }.onFailure {

            FileLog.e(it)

        }

    }

}