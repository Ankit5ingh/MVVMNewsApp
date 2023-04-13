package com.ankit.mvvmnewsapp.models

data class Source(
    val id: String,
    val name: String
): java.io.Serializable {
    override fun hashCode(): Int {
        var result = id.hashCode()
        if(name.isNullOrEmpty()){
            result = 31 * result + name.hashCode()
        }
        return result
    }
}