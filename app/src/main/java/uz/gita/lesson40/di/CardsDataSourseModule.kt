package uz.gita.lesson40.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.lesson40.data.datasource.CardsDataSourceImpl
import uz.gita.lesson40.data.datasource.CardsDataSourse

@Module
@InstallIn(SingletonComponent::class)
interface CardsDataSourceModule {
    @Binds
    fun bind(cardsDataSourceImpl: CardsDataSourceImpl):CardsDataSourse
}