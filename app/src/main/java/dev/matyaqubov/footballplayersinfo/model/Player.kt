package dev.matyaqubov.footballplayersinfo.model

data class Player(

    val name:String,
    val decription:String,
    val image:String,
    var expand:Boolean,
    val moreInfolink:String
)
