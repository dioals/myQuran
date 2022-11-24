package com.dioals.myquran.model

data class VersesItem(
	val id:Int,
	val verse_number:Int,
	val text_indopak:String,
	val sajdah:String?,
	val text_madani:String
)

data class Verses(
	val verses:List<VersesItem>,
	val pagination:Pagination
)

data class Pagination(
	val current_page:Int,
	val next_page:Int?,
	val prev_page:Int?,
	val total_pages:Int,
	val total_count:Int
)
