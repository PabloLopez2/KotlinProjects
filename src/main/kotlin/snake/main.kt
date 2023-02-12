import java.awt.EventQueue
import java.io.FileDescriptor
import java.io.FileOutputStream
import java.io.PrintStream
import java.nio.charset.StandardCharsets

fun main() {
    if (System.out.charset() != StandardCharsets.UTF_8)
        System.setOut(PrintStream(FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8))

    EventQueue.invokeLater(::showUI)


}
