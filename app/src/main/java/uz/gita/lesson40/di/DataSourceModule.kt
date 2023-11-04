package uz.gita.lesson40.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.lesson40.data.datasource.AuthDataSource
import uz.gita.lesson40.data.datasource.AuthDataSourceImpl

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {
    @Binds
    fun bindAuthDataSource(authDataSourceImpl: AuthDataSourceImpl): AuthDataSource
}