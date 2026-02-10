package eu.kanade.tachiyomi.extension.ja.gomuraw

import eu.kanade.tachiyomi.source.model.*
import okhttp3.Request

class gomuraw : MangaReader("gomuraw", "https://new-url.com/", "ja") {
    
    // 1. 人気の漫画リストを取得するための設定
    // サイトのトップページやカタログページで、各漫画を囲んでいるHTMLタグを指定します
    val popularMangaSelector = "div.bs" 
    val popularMangaNextPageSelector = "div.pagination a.next"

    // 2. 検索結果の設定
    override val searchPathSegment = "search"
    override val searchKeyword = "q"

    // 3. チャプター（各話）のリストを取得する設定
    override val chapterIdSelect = "ja-chaps" // 前回の設定を維持

    // 4. 画像URLを解析するロジック（ここが最重要）
    // 通常、MangaReader系はJSONで画像リストを返します
    override fun getAjaxUrl(id: String): String {
        return "$baseUrl/json/chapter?mode=vertical&id=$id"
    }

    // --- 以下は継承した基本機能の調整 ---

    override fun searchMangaRequest(page: Int, query: String, filters: FilterList): Request {
        return Request.Builder()
            .url("$baseUrl/$searchPathSegment?page=$page&$searchKeyword=$query")
            .build()
    }

    override fun getFilterList(): FilterList {
        return FilterList(Note, TypeFilter(), StatusFilter())
    }
}
