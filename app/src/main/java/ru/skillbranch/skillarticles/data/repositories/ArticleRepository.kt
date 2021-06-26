package ru.skillbranch.skillarticles.data.repositories

import androidx.lifecycle.LiveData
import ru.skillbranch.skillarticles.data.*

interface IArticleRepository {
    fun loadArticleContent(articleId: String): LiveData<List<String>?>
    fun getArticle(articleId: String): LiveData<ArticleData?>
    fun loadArticlePersonalInfo(articleId: String): LiveData<ArticlePersonalInfo?>
    fun getAppSettings(): LiveData<AppSettings>
    fun updateSettings(appSettings: AppSettings)
    fun updateArticlePersonalInfo(info: ArticlePersonalInfo)
}

class ArticleRepository(
    private val local: LocalDataHolder = LocalDataHolder,
    private val network: NetworkDataHolder = NetworkDataHolder
) : IArticleRepository {

    override fun loadArticleContent(articleId: String): LiveData<List<String>?> {
        return network.loadArticleContent(articleId) //5s delay from network
    }

    override fun getArticle(articleId: String): LiveData<ArticleData?> {
        return local.findArticle(articleId) //2s delay from db
    }

    override fun loadArticlePersonalInfo(articleId: String): LiveData<ArticlePersonalInfo?> {
        return local.findArticlePersonalInfo(articleId) //1s delay from db
    }

    override fun getAppSettings(): LiveData<AppSettings> = local.getAppSettings() //from preferences
    override fun updateSettings(appSettings: AppSettings) {
        local.updateAppSettings(appSettings)
    }

    override fun updateArticlePersonalInfo(info: ArticlePersonalInfo) {
        local.updateArticlePersonalInfo(info)
    }
}