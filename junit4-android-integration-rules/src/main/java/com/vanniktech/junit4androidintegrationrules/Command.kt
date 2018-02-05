package com.vanniktech.junit4androidintegrationrules

private val LIST_OF_TRUE = listOf("plugged", "powersave", "fully", "visible")

/** This is not meant as a public API. Use it at your own risk. */
@Suppress("Detekt.UnnecessaryAbstractClass") abstract class Command(val name: String) {
  internal val map: MutableMap<String, Any> = mutableMapOf()

  internal fun asCommand() = map.mapNotNull {
    val key = it.key
    val value = it.value

    when (value) {
      is Boolean -> {
        val command = if (value) if (LIST_OF_TRUE.contains(key)) "true" else "show" else "false"
        " -e $key $command"
      }
      is EnumValue -> " -e $key ${value.value}"
      else -> " -e $key $value"
    }
  }.joinToString(separator = "")
}
