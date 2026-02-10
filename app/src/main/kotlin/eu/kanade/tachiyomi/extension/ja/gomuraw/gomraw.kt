package eu.kanade.tachiyomi.extension.ja.mangamura



class gomuraw : MangaReader(
    "gomuraw",
    "https://gomuraw.com/",
    "ja",
) {
    override val chapterIdSelect = "ja-chaps"

    override fun getAjaxUrl(id: String): String {
        return "$baseUrl/json/chapter?mode=vertical&id=$id"
    }

    override val searchPathSegment = ""
    override val searchKeyword = "q"

    override fun searchMangaRequest(page: Int, query: String, filters: FilterList): Request {
        val request = super.searchMangaRequest(page, query, filters)

        // avoid 302
        val newUrl = request.url.newBuilder()
            .addPathSegment("")
            .build()

        return request.newBuilder()
            .url(newUrl)
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
