package tw.nekomimi.nekogram.utils

import org.json.JSONArray
import org.telegram.messenger.ApplicationLoader
import java.io.ByteArrayInputStream
import java.io.File

object ProxyUtil {

    @JvmStatic
    val cacheFile = File(ApplicationLoader.applicationContext.filesDir.parent, "nekox/proxy_list.json")

    @JvmStatic
    fun reloadProxyList(): Boolean {

        val ctx = ApplicationLoader.applicationContext

        cacheFile.parentFile?.mkdirs()

        runCatching {

            val list = JSONArray(HttpUtil.get("https://nekogramx.github.io/ProxyList/proxy_list.json")).toString()

            if (list != cacheFile.readText()) {

                cacheFile.writeText(list)

                return true

            }

        }.recover {

            val list = JSONArray(HttpUtil.get("https://raw.githubusercontent.com/NekogramX/ProxyList/master/proxy_list.json")).toString()

            if (list != cacheFile.readText()) {

                cacheFile.writeText(list)

                return true

            }

        }.recover {

            val master = HttpUtil.getByteArray("https://github.com/NekogramX/ProxyList/archive/master.zip")

            val list = JSONArray(String(ZipUtil.read(ByteArrayInputStream(master), "ProxyList-master/proxy_list.json"))).toString()

            if (list != cacheFile.readText()) {

                cacheFile.writeText(list)

                return true

            }

        }

        return false

    }

}