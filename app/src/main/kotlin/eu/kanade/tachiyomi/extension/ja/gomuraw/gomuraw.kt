package eu.kanade.tachiyomi.extension.ja.gomuraw

import eu.kanade.tachiyomi.source.model.*
import okhttp3.Request

/**
 * Gomraw 拡張機能
 * 提供されたソース（gomuraw.dev）に合わせてセレクタを最適化しています。
 */
class gomuraw : MangaReader("gomuraw", "https://gomuraw.dev", "ja") {
    
    // 1. 人気/最新の漫画リストを取得するための目印
    // 一般的なMangaReader系サイトで使われるセレクタを網羅しています
    override val popularMangaSelector = "div.bs, div.manga-item, div.utao, div.listupd div.bs"
    
    // 次のページボタン
    override val popularMangaNextPageSelector = "div.pagination a.next, .next.page-numbers"

    // 2. 検索設定
    override val searchPathSegment = "search"
    override val searchKeyword = "q"

    // 3. チャプター（話数）リストの設定
    // サイト内の各話リストを囲むIDやクラスを指定
    override val chapterIdSelect = "ja-chaps"

    // 4. 画像読み込み用のAjax URL設定
    override fun getAjaxUrl(id: String): String {
        return "$baseUrl/json/chapter?mode=vertical&id=$id"
    }

    // --- 以下、リクエストの構築ロジック ---

    override fun searchMangaRequest(page: Int, query: String, filters: FilterList): Request {
        // 検索URLを構築（例: https://gomuraw.dev/search?q=呪術&page=1）
        return Request.Builder()
            .url("$baseUrl/$searchPathSegment?page=$page&$searchKeyword=$query")
            .build()
    }

    override fun getFilterList(): FilterList {
        // スタブで定義したフィルターを並べてメニューを表示させます
        return FilterList(
            Note,
            TypeFilter(),
            StatusFilter(),
            LanguageFilter(),
            SortFilter(),
        )
    }
}
