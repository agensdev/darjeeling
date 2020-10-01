package no.agens.darjeeling.android.ext

import java.io.PrintWriter
import java.io.StringWriter

fun Error.stackTraceAsString(): String {
    val stringWriter = StringWriter()
    this.printStackTrace(PrintWriter(StringWriter()))
    stringWriter.flush()
    return stringWriter.buffer.toString()
}