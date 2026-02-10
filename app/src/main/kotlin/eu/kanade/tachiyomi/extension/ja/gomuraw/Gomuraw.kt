package eu.kanade.tachiyomi.extension.ja.gomuraw

import okhttp3.Request
// インポートを削除（Stub内に定義したため不要）

class gomuraw : MangaReader("gomuraw", "https://gomuraw.dev", "ja") {
    
    override val popularMangaSelector = "div.bs, div.manga-item, div.utao, div.listupd div.bs"
    override val popularMangaNextPageSelector = "div.pagination a.next, .next.page-numbers"
    override val searchPathSegment = "search"
    override val searchKeyword = "q"
    override val chapterIdSelect = "ja-chaps"

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
            Note(),          // () を追加
            TypeFilter(),
            StatusFilter(),
            LanguageFilter(),
            SortFilter(),
        )
    }
}
