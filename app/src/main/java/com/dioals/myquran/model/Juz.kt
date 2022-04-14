package com.dioals.myquran.model

import com.squareup.moshi.Json

data class Juz(

	var number:Int=1,

	@Json(name="start")
	val start: String? = null,

	@Json(name="end")
	val end: String? = null,

	@Json(name="juz")
	val juz: Int? = null,

	@Json(name="verses")
	val verses: List<VersesItem>? = null
)
