package com.dioals.myquran.model

import com.squareup.moshi.Json

data class SurahList(
	@Json(name = "data")
	val surah:List<Surah>
)

data class Surah(

	@Json(name="number")
	val number: Int? = null,

	@Json(name="sequence")
	val sequence: Int? = null,

	@Json(name="numberOfVerses")
	val numberOfVerses: Int? = null,

	@Json(name="revelation")
	val revelation: Revelation? = null,

	@Json(name="name")
	val name: Name? = null,
)

data class Revelation(

	@Json(name="en")
	val en: String? = null,

	@Json(name="id")
	val id: String? = null,

	@Json(name="arab")
	val arab: String? = null
)

data class Translation(

	@Json(name="en")
	val en: String? = null,

	@Json(name="id")
	val id: String? = null
)

data class Transliteration(

	@Json(name="en")
	val en: String? = null,

	@Json(name="id")
	val id: String? = null
)

data class Name(

	@Json(name="translation")
	val translation: Translation? = null,

	@Json(name="short")
	val jsonMemberShort: String? = null,

	@Json(name="long")
	val jsonMemberLong: String? = null,

	@Json(name="transliteration")
	val transliteration: Transliteration? = null
)