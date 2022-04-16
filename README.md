# MyQuran
Digital Quran in your hand

A Portfolio project for JuaraAndroid Challenge

myQuran : Digital Quran in your Hand is a digital Quran made for moslem who wants to read quran anytime and anywhere
Easily search for specific ayah or juz, with ease of click, you can read the Quran complete with translation

API used in the project can be found here:
https://github.com/gadingnst/quran-api

Currently the project's feature consist of 2 activities:
1. mode selection
2. quran reader

Mode selection offer quran reading type, whether you want to read Quran as a Juz or by Surah

Android Study Jam implemented in this project:
* ViewModel : for a good code structure, not doing logic processes in main thread but in the viewModel
* Navigation Controller : to change screen between mode selection and juz or surah selection
* Intent Extra : to send mode and selection to quran reader activity
* RecyclerView : display lists of data
* Retrofit : to communicate with APIs
* Moshi : Easily map API's JSON to model data
* ViewBinding : Binding views to codes
* DataBinding : for easilty binding Data to views
* ImageAsset : Create App Logo
* etc. where it might be mentioned in the study jam but i forgot to add here
