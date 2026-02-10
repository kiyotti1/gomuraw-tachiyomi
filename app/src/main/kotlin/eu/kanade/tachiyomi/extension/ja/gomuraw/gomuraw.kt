package eu.kanade.tachiyomi.extension.ja.gomuraw

import eu.kanade.tachiyomi.source.model.*
import okhttp3.Request

/**
 * Gomraw 拡張機能
 * MangaReader クラスを継承し、Tachiyomi の標準形式に準拠させています。
 * 足りない部品（FilterList等）は Stub.kt が補完します。
 */
class gomuraw : MangaReader("gomuraw", "https://gomuraw.dev/", "ja") {
    
    // 1. チャプターリストを取得するためのセレクタ（サイト固有の設定）
    override val chapterIdSelect = "ja-chaps"

    // 2. 画像読み込み等で使用する Ajax 用の URL 構築
    override fun getAjaxUrl(id: String): String {
        return "$baseUrl/json/chapter?mode=vertical&id=$id"
    }

    // 3. 検索設定
    override val searchPathSegment = ""
    override val searchKeyword = "q"

    // 4. 検索リクエストの構築
    override fun searchMangaRequest(page: Int, query: String, filters: FilterList): Request {
        // 現在は単純なキーワード検索のみ実装
        return Request.Builder()
            .url("$baseUrl/search?q=$query")
            .build()
    }

    // 5. フィルターメニューの設定
    // Stub.kt で定義した各 Filter クラスを使用してメニューを構成
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
