// パッケージを細かく分ける必要があるため、ファイル内で定義を整理します
package eu.kanade.tachiyomi.source.model

import okhttp3.Request

// --- model パッケージに属するもの ---
class FilterList(vararg list: Any) : ArrayList<Any>(list.asList())
object Note
open class TypeFilter
open class StatusFilter
open class LanguageFilter
open class SortFilter

interface SChapter
interface SManga

// --- 本来は別のパッケージにあるが、ビルドを通すためにここに配置 ---
interface Source

open class MangaReader(val name: String, val baseUrl: String, val lang: String) : Source {
    open val chapterIdSelect = ""
    open val searchPathSegment = ""
    open val searchKeyword = ""
    
    open fun getAjaxUrl(id: String): String = ""
    open fun searchMangaRequest(page: Int, query: String, filters: FilterList): Request {
        return Request.Builder().url(baseUrl).build()
    }
    open fun getFilterList(): FilterList = FilterList()
}
