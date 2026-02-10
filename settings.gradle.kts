/**
 * あなたの現在のフォルダ構成（app/src/...）に合わせた設定
 */
include(":app")

// 元々あった複雑な自動読み込みは、一旦コメントアウトか削除します
// loadAllIndividualExtensions() 

/**
 * ===================================== COMMON CONFIGURATION ======================================
 */
// Load all modules under /lib (もしあれば)
if (File(rootDir, "lib").exists()) {
    File(rootDir, "lib").eachDir { include("lib:${it.name}") }
}

fun File.eachDir(block: (File) -> Unit) {
    val files = listFiles() ?: return
    for (file in files) {
        if (file.isDirectory && file.name != ".gradle" && file.name != "build") {
            block(file)
        }
    }
}
