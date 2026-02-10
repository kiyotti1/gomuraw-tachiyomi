package eu.kanade.tachiyomi.extension.ja.gomuraw

import eu.kanade.tachiyomi.source.model.*
import okhttp3.Request

class gomuraw : MangaReader("gomuraw", "https://gomuraw.dev", "ja") {
    
    // 変数名を MangaReader の定義に合わせて修正
    override val popularMangaSelector = "div.bs, div.manga-item, div.utao, div.listupd div.bs"
    
    override val popularMangaNextPageSelector = "div.pagination a.next, .next.page-numbers"

    // 検索設定
    override val searchPathSegment = "search"
    override val searchKeyword = "q"

    // チャプターリストの設定
    override val chapterIdSelect = "ja-chaps"

    // 画像URL取得用の設定
    override fun getAjaxUrl(id: String): String {
        return "$baseUrl/json/chapter?mode=vertical&id=$id"
    }

    override fun searchMangaRequest(page: Int, query: String, filters: FilterList): Request {
        return Request.Builder()
            .url("$baseUrl/$searchPathSegment?page=$page&$searchKeyword=$query")
            .build()
    }

    override fun getFilterList(): FilterList {
        return FilterList(
            Note,
            TypeFilter(),
            StatusFilter(),
            LanguageFilter(),
            SortFilter(),
        )
    }
}
