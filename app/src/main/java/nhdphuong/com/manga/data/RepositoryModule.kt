package nhdphuong.com.manga.data

import android.support.annotation.NonNull
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import nhdphuong.com.manga.api.BookApiService
import nhdphuong.com.manga.api.TagApiService
import nhdphuong.com.manga.data.local.BookLocalDataSource
import nhdphuong.com.manga.data.local.RecentBookDAO
import nhdphuong.com.manga.data.local.TagDAO
import nhdphuong.com.manga.data.local.TagLocalDataSource
import nhdphuong.com.manga.data.remote.BookRemoteDataSource
import nhdphuong.com.manga.data.remote.TagRemoteDataSource
import nhdphuong.com.manga.scope.Local
import nhdphuong.com.manga.scope.Remote
import javax.inject.Singleton

/*
 * Created by nhdphuong on 3/24/18.
 */
@Module
class RepositoryModule {
    @Provides
    @NonNull
    @Singleton
    @Remote
    fun provideBookRemoteDataSource(bookApiService: BookApiService): BookDataSource.Remote = BookRemoteDataSource(bookApiService)

    @Provides
    @NonNull
    @Singleton
    @Local
    fun providesBookLocalDataSource(recentBookDAO: RecentBookDAO): BookDataSource.Local = BookLocalDataSource(recentBookDAO)

    @Provides
    @NonNull
    @Singleton
    @Remote
    fun provideTagRemoteDataSource(tagApiService: TagApiService): TagDataSource.Remote = TagRemoteDataSource(tagApiService)

    @Provides
    @NonNull
    @Singleton
    @Local
    fun providesTagLocalDataSource(tagDAO: TagDAO): TagDataSource.Local = TagLocalDataSource(tagDAO, CoroutineScope(Dispatchers.IO))
}