package uz.gita.lesson40.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.lesson40.data.source.CardsDataSourse
import uz.gita.lesson40.data.source.CardsDataSourseImpl

@Module
@InstallIn(SingletonComponent::class)
interface CardsDataSourseModule {
    @Binds
    fun bind(cardsDataSourseImpl: CardsDataSourseImpl):CardsDataSourse
}