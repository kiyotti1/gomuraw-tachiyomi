package eu.kanade.tachiyomi.extension.ja.gomuraw

import okhttp3.Request

// ダミーのモデルクラスを定義してインポートエラーを防ぐ
open class MangaReader(val name: String, val baseUrl: String, val lang: String) {
    open val popularMangaSelector: String = ""
    open val popularMangaNextPageSelector: String? = null
    open val searchPathSegment: String = ""
    open val searchKeyword: String = ""
    open val chapterIdSelect: String = ""

    open fun getAjaxUrl(id: String): String = ""
    open fun searchMangaRequest(page: Int, query: String, filters: FilterList): Request = throw Exception("Stub")
    open fun getFilterList(): FilterList = FilterList()
}

// 必要なダミークラス群
class FilterList(vararg filters: Any)
open class Filter(val name: String)
class Note : Filter("Note")
class TypeFilter : Filter("Type")
class StatusFilter : Filter("Status")
class LanguageFilter : Filter("Language")
class SortFilter : Filter("Sort")
