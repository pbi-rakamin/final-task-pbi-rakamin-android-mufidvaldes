<h1>Preview :</h1>
  
![rec news](https://github.com/pbi-rakamin/final-task-pbi-rakamin-android-mufidvaldes/assets/81525382/6857563a-0458-4f38-845f-ffd56a9c8d20)

<h2>Fitur</h2>
<ul>
  <li>Menampilkan berita utama (headlines) dalam bentuk ViewPager.</li>
  <li>Menyegarkan berita dengan fitur swipe-to-refresh.</li>
  <li>Memuat lebih banyak berita saat pengguna menggulir ke bawah.</li>
  <li>Menampilkan detail berita saat item berita diklik.</li>
</ul>
<h2>Struktur Proyek</h2>
    <pre><code>|-- src
|   |-- main
|       |-- java/com/rakamin_finaltask/news_app_final
|           |-- ui
|               |-- DetailNewsActivity.kt
|               |-- adapter
|                   |-- HeadlineAdapter.kt
|                   |-- NewsAdapter.kt
|           |-- remote
|               |-- response
|                   |-- NewsResponse.kt
|               |-- retrofit
|                   |-- ApiConfig.kt
|                   |-- ApiService.kt
|           |-- repository
|               |-- NewsRepository.kt
|           |-- utils
|               |-- DateFormatter.kt
|           |-- viewmodel
|               |-- NewsViewModel.kt
|           |-- MainActivity.kt
|       |-- res
|           |-- layout
|               |-- activity_main.xml
|               |-- activity_detail_news.xml
|               |-- item_headline.xml
|               |-- item_news.xml
|           |-- values
|               |-- strings.xml
|               |-- colors.xml
|               |-- styles.xml
|           |-- drawable
|               |-- ic_loading.xml
|               |-- ic_error.xml</code></pre>
