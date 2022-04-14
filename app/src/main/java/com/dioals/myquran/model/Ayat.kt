package com.dioals.myquran.model

import com.squareup.moshi.Json

data class Ayat(

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

	@Json(name="preBismillah")
	val preBismillah: PreBismillah? = null,

	@Json(name="verses")
	val verses: List<VersesItem>? = null
)

data class Audio(

	@Json(name="secondary")
	val secondary: List<String?>? = null,

	@Json(name="primary")
	val primary: String? = null
)

data class Text(

	@Json(name="transliteration")
	val transliteration: Transliteration? = null,

	@Json(name="arab")
	val arab: String? = null
)

data class VersesItem(

	@Json(name="number")
	val number: Number? = null,

	@Json(name="meta")
	val meta: Meta? = null,

	@Json(name="translation")
	val translation: Translation? = null,

	@Json(name="text")
	val text: Text? = null,

	@Json(name="audio")
	val audio: Audio? = null
)

data class Sajda(

	@Json(name="obligatory")
	val obligatory: Boolean? = null,

	@Json(name="recommended")
	val recommended: Boolean? = null
)

data class Meta(

	@Json(name="hizbQuarter")
	val hizbQuarter: Int? = null,

	@Json(name="ruku")
	val ruku: Int? = null,

	@Json(name="manzil")
	val manzil: Int? = null,

	@Json(name="page")
	val page: Int? = null,

	@Json(name="sajda")
	val sajda: Sajda? = null,

	@Json(name="juz")
	val juz: Int? = null
)

data class Number(

	@Json(name="inQuran")
	val inQuran: Int? = null,

	@Json(name="inSurah")
	val inSurah: Int? = null
)

data class Id(

	@Json(name="short")
	val jsonMemberShort: String? = null,

	@Json(name="long")
	val jsonMemberLong: String? = null
)

data class PreBismillah(

	@Json(name="translation")
	val translation: Translation? = null,

	@Json(name="text")
	val text: Text? = null,

	@Json(name="audio")
	val audio: Audio? = null
)
