package com.example.rvfinalproject

class FriendsDataSourceImpl : FriendsDataSource {

    private val sourceFriends = listOf(
        Friend(R.drawable.dimasik, "Dimasik"),
        Friend(R.drawable.lexa, "Lexa"),
        Friend(R.drawable.andrey, "Andrey"),
        Friend(R.drawable.vitek, "Vitek"),
        Friend(R.drawable.fedosik, "Fedosik"),
    )

    override fun getFriendsByIndex(index: Int): Friend {
        return sourceFriends[index]
    }
}