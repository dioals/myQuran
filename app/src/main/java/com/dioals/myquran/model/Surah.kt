package com.dioals.myquran.model

import com.squareup.moshi.Json

data class SurahList(
    @Json(name = "data")
    val surah: List<Surah>
)

data class Surah(
    val id: Int,
    val bismillah_pre: Boolean,
    val name_simple: String,
    val name_complex: String,
    val name_arabic: String,
    val verses_count: Int
)

data class Chapters(
    val chapters: List<Surah>
)

data class Revelation(

    @Json(name = "en")
    val en: String? = null,

    @Json(name = "id")
    val id: String? = null,

    @Json(name = "arab")
    val arab: String? = null
)

data class Translation(

    @Json(name = "en")
    val en: String? = null,

    @Json(name = "id")
    val id: String? = null
)

data class Transliteration(

    @Json(name = "en")
    val en: String? = null,

    @Json(name = "id")
    val id: String? = null
)

data class Name(

    @Json(name = "translation")
    val translation: Translation? = null,

    @Json(name = "short")
    val jsonMemberShort: String? = null,

    @Json(name = "long")
    val jsonMemberLong: String? = null,

    @Json(name = "transliteration")
    val transliteration: Transliteration? = null
)