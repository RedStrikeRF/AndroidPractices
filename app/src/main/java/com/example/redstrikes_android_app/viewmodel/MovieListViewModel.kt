package com.example.redstrikes_android_app.viewmodel

import androidx.lifecycle.ViewModel
import com.example.redstrikes_android_app.data.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor() : ViewModel() {
    val movies = listOf(
        Movie(
            id = 1,
            title = "Начало",
            year = 2010,
            rating = 8.8,
            genre = "Научная фантастика, Боевик",
            director = "Кристофер Нолан",
            synopsis = "Кобб — талантливый вор, лучший из лучших в опасном искусстве извлечения: он крадет ценные секреты из глубин подсознания во время сна, когда человеческий разум наиболее уязвим.",
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/1629390/8ab9a119-dd74-44f0-baec-0629797483d7/600x900",
            duration = "148 мин"
        ),
        Movie(
            id = 2,
            title = "Темный рыцарь",
            year = 2008,
            rating = 9.0,
            genre = "Боевик, Драма, Криминал",
            director = "Кристофер Нолан",
            synopsis = "Бэтмен поднимает ставки в войне с преступностью. С помощью лейтенанта Джима Гордона и прокурора Харви Дента он намерен очистить улицы от преступности, отравляющей город.",
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/1599028/0fa5bf50-d5ad-446f-a599-b26d070c8b99/600x900",
            duration = "152 мин"
        ),
        Movie(
            id = 3,
            title = "Интерстеллар",
            year = 2014,
            rating = 8.6,
            genre = "Научная фантастика, Драма",
            director = "Кристофер Нолан",
            synopsis = "Когда засуха приводит человечество к продовольственному кризису, коллектив исследователей и учёных отправляется сквозь червоточину в путешествие, чтобы превзойти прежние ограничения для космических путешествий человека.",
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/1600647/78c36c0f-aefd-4102-bc3b-bac0dd4314d8/3840x",
            duration = "169 мин"
        ),
        Movie(
            id = 4,
            title = "1+1",
            year = 2011,
            rating = 8.8,
            genre = "Драма, Комедия",
            director = "Оливье Накаш, Эрик Толедано",
            synopsis = "Пострадав в результате несчастного случая, богатый аристократ Филипп нанимает в помощники человека, который менее всего подходит для этой работы, — молодого жителя предместья Дрисса, только что освободившегося из тюрьмы.",
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/1946459/5c758ac0-7a5c-4f00-a94e-1a5607020850/600x900",
            duration = "112 мин"
        ),
    )
}