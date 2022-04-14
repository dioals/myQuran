package com.dioals.myquran.model

import com.squareup.moshi.Json

data class Response(

	@Json(name="code")
	val code: Int? = null,

	@Json(name="message")
	val message: String? = null,

	@Json(name="status")
	val status: String? = null,

	@Json(name="data")
	val data: Any? = null
)
