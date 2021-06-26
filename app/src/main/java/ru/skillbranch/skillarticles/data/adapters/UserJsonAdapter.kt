package ru.skillbranch.skillarticles.data.adapters

import org.json.JSONObject
import ru.skillbranch.skillarticles.data.local.User
import ru.skillbranch.skillarticles.extensions.asMap

class UserJsonAdapter() : JsonAdapter<User>{
    override fun fromJson(json: String): User? {
        TODO("Not yet implemented")
    }

    override fun toJson(obj: User?): String {
        TODO("Not yet implemented")
    }

}