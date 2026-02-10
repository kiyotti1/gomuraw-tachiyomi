package eu.kanade.tachiyomi.extension.ja.gomuraw

import eu.kanade.tachiyomi.source.model.*
import okhttp3.Request

// 親クラスにプロパティを追加して、gomuraw.kt からの上書きを許可します
open class MangaReader(val name: String, val baseUrl: String, val lang: String) {
    // これらを追加することで gomuraw.kt のエラーが消えます
    open val popularMangaSelector: String = ""
    open val popularMangaNextPageSelector: String? = null
    open val searchPathSegment: String = ""
    open val searchKeyword: String = ""
    open val chapterIdSelect: String = ""

    open fun getAjaxUrl(id: String): String = ""
    open fun searchMangaRequest(page: Int, query: String, filters: FilterList): Request = throw Exception("Stub")
    open fun getFilterList(): FilterList = FilterList()
}

// フィルター関連のスタブ（変更なし）
open class Filter(val name: String)
class FilterList(vararg filters: Any)
class Note : Filter("Note")
class TypeFilter : Filter("Type")
class StatusFilter : Filter("Status")
class LanguageFilter : Filter("Language")
class SortFilter : Filter("Sort")
