package eu.kanade.tachiyomi.extension.ja.mangamura

import okhttp3.Request
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull

// ライブラリがないので、一旦「普通のクラス」として定義します
class gomuraw {
    val name = "gomuraw"
    val baseUrl = "https://gomuraw.com/"
    val lang = "ja"

    val chapterIdSelect = "ja-chaps"

    fun getAjaxUrl(id: String): String {
        return "$baseUrl/json/chapter?mode=vertical&id=$id"
    }

    val searchPathSegment = ""
    val searchKeyword = "q"

    // FilterListなどの不明な型を Any に変えるか、使わない形にします
    fun searchMangaRequest(page: Int, query: String, filters: Any): Request {
        val url = "$baseUrl/search?q=$query".toHttpUrlOrNull()!!
        
        return Request.Builder()
            .url(url)
            .build()
    }

    // エラーの元になるフィルター関数を一旦無効化します
    /*
    fun getFilterList(): Any {
        return Any()
    }
    */
}
