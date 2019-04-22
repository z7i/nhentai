package nhdphuong.com.manga.api

/*
 * Created by nhdphuong on 3/24/18.
 */
object ApiConstants {
    const val NHENTAI_DB = "https://raw.githubusercontent.com/duyphuong5126/NHentaiDB/master"
    const val NHENTAI_HOME = "https://id.nhent.ai"
    private const val NHENTAI_I = "https://i.bakaa.me"
    private const val NHENTAI_T = "https://kontol.nhent.ai"

    private fun getThumbnailUrl(mediaId: String): String = "$NHENTAI_T/galleries/$mediaId"

    fun getBookThumbnailById(mediaId: String, imageType: String): String = "$NHENTAI_T/galleries/$mediaId/thumb$imageType"

    fun getBookCover(mediaId: String): String = "${getThumbnailUrl(mediaId)}/cover.jpg"

    fun getThumbnailByPage(mediaId: String, pageNumber: Int, imageType: String): String = "${getThumbnailUrl(mediaId)}/${pageNumber}t.$imageType"

    private fun getGalleryUrl(mediaId: String): String = "$NHENTAI_I/galleries/$mediaId"

    fun getPictureUrl(mediaId: String, pageNumber: Int, imageType: String): String = "${getGalleryUrl(mediaId)}/$pageNumber.$imageType"
}