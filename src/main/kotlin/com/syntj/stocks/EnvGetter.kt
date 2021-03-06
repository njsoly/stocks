package com.syntj.stocks

/**
 * This class, created specifically called for calls
 * to System.getenv() and System.getProperty(),
 * was created in order to be able to mock those calls,
 * since java.lang.System is a final class.
 */
class EnvGetter {

    fun getEnv(name: String): String? {
        return System.getenv(name) ?: null
    }

    enum class Favorites(val envVarName: String) {
        finnhubApiKey("finnhub_api_key")
    }
}

fun EnvGetter.Favorites.grab() : String? {
    return EnvGetter().getEnv(this.envVarName)
}
