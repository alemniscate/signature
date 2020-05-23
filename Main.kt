package signature

/**
Enter name and surname: Ian One
Enter person's status: VIP
888888888888888888888888888888888888888888888888888888888888888888888888888888888
88  ooooo                                   .oooooo.                           88
88  `888'                                  d8P'  `Y8b                          88
88   888   .oooo.   ooo. .oo.             888      888 ooo. .oo.    .ooooo.    88
88   888  `P  )88b  `888P"Y88b            888      888 `888P"Y88b  d88' `88b   88
88   888   .oP"888   888   888            888      888  888   888  888ooo888   88
88   888  d8(  888   888   888            `88b    d88'  888   888  888    .o   88
88  o888o `Y888""8o o888o o888o            `Y8bood8P'  o888o o888o `Y8bod8P'   88
88                                                                             88
88                                                                             88
88                                                                             88
88                                _  _ _ ___                                   88
88                                |  | | |__]                                  88
88                                 \/  | |                                     88
888888888888888888888888888888888888888888888888888888888888888888888888888888888
Enter name and surname: A b
Enter person's status: long participant
88888888888888888888888888888888888888888888888888888888888888888888888888888888
88                         .o.                  .o8                           88
88                        .888.                "888                           88
88                       .8"888.                888oooo.                      88
88                      .8' `888.               d88' `88b                     88
88                     .88ooo8888.              888   888                     88
88                    .8'     `888.             888   888                     88
88                   o88o     o8888o            `Y8bod8P'                     88
88                                                                            88
88                                                                            88
88                                                                            88
88  _    ____ _  _ ____      ___  ____ ____ ___ _ ____ _ ___  ____ _  _ ___   88
88  |    |  | |\ | | __      |__] |__| |__/  |  | |    | |__] |__| |\ |  |    88
88  |___ |__| | \| |__]      |    |  | |  \  |  | |___ | |    |  | | \|  |    88
88888888888888888888888888888888888888888888888888888888888888888888888888888888
Code Editor
 */

import java.io.File
import java.util.*

fun main() {
    val name = readLine()!!
    val status = readLine()!!.toLowerCase()

    val bf = BigFont()
    bf.init()

    val mf = MediumFont()
    mf.init()

    val namesize = bf.getNameSize(name)
    val statussize = mf.getNameSize(status)

    var bordersize = namesize + 8
    var prestatus = (bordersize - 4 - statussize) / 2
    var poststatus = prestatus
    if (prestatus + poststatus + 4 + statussize > bordersize) prestatus--
    if (prestatus + poststatus + 4 + statussize < bordersize) poststatus++
    var prename = 2
    var postname = 2

    if (namesize < statussize) {
        bordersize = statussize + 8
        prestatus = 2
        poststatus = 2
        prename = (bordersize - 4 - namesize) / 2
        postname = prename
        if (prename + postname + 4 + namesize > bordersize) prename--
        if (prename + postname + 4 + namesize < bordersize) postname++
    }

    println("8".repeat(bordersize))
    bf.printname(name, prename, postname)
    mf.printname(status, prestatus, poststatus)
    println("8".repeat(bordersize))
}

class BigFont {
    val font = mutableMapOf<Int, String>()
    val pos = mutableMapOf<Char, Int>()
    val len = mutableMapOf<Char, Int>()

    fun init() {
        pos[' '] = 0
        len[' '] = 10
        for (i in 0..9) {
            font[i] = " ".repeat(10)
        }

        val ft = File("D:\\Users\\nagai\\IdeaProjects\\signature3\\fonts\\roman.txt")
        var i = 0
        ft.forEachLine {
            if (i != 0) {
                var key = ' '
                var fontlength = 0
                val kind = (i - 1) % 11
                when (kind) {
                    0 -> {
                        val strs = it.split(" ")
                        key = strs[0].first()
                        fontlength = strs[1].toInt()
                        len[key] = fontlength
                    }
                    else -> {
                        font[kind - 1] += it
                    }
                }
            }
            i++
        }

        var p = 0
        for (pair in len) {
            pos[pair.key] = p
            p += len[pair.key]!!
        }
    }

    fun getNameSize(name: String): Int {
        var size = 0
        for (ch in name) {
            size += len[ch]!!
        }
        return size
    }

    fun printname(name: String, prenamesize: Int, postnamesize: Int) {
        for (i in 0..9) {
            var line = "88" + " ".repeat(prenamesize)
            for (ch in name) {
                val p = pos[ch]!!
                val l = len[ch]!!
                line += font[i]!!.substring(p, p + l)
            }
            line += " ".repeat(postnamesize) + "88"
            println(line)
        }
    }

}

class MediumFont {
    val c1 =
            "     ____ ___  ____ ___  ____ ____ ____ _  _ _  _ _  _ _    _  _ _  _ ____ ___  ____ ____ ____ ___ _  _ _  _ _ _ _ _  _ _   _ ___ "
    val c2 =
            "     |__| |__] |    |  \\ |___ |___ | __ |__| |  | |_/  |    |\\/| |\\ | |  | |__] |  | |__/ [__   |  |  | |  | | | |  \\/   \\_/    / "
    val c3 =
            "     |  | |__] |___ |__/ |___ |    |__] |  | | _| | \\_ |___ |  | | \\| |__| |    |_\\| |  \\ ___]  |  |__|  \\/  |_|_| _/\\_   |    /__"

    val pos = mutableMapOf<Char, Int>()
    val len = mapOf<Char, Int>(
            ' ' to 4,
            'a' to 4,
            'b' to 4,
            'c' to 4,
            'd' to 4,
            'e' to 4,
            'f' to 4,
            'g' to 4,
            'h' to 4,
            'i' to 1,
            'j' to 2,
            'k' to 4,
            'l' to 4,
            'm' to 4,
            'n' to 4,
            'o' to 4,
            'p' to 4,
            'q' to 4,
            'r' to 4,
            's' to 4,
            't' to 3,
            'u' to 4,
            'v' to 4,
            'w' to 5,
            'x' to 4,
            'y' to 5,
            'z' to 4
    )

    fun init() {
        var p = 0
        pos[' '] = 0
        p += len[' ']!! + 1
        for (ch in 'a'..'z') {
            pos[ch] = p
            p += len[ch]!! + 1
        }
    }

    fun getNameSize(name: String): Int {
        var size = 0
        for (ch in name) {
            size += len[ch]!! + 1
        }
        return size
    }

    fun printname(name: String, prenamesize: Int, postnamesize: Int) {
        var line = "88" + " ".repeat(prenamesize)
        for (ch in name) {
            val p = pos[ch]!!
            val l = len[ch]!!
            line += c1.substring(p, p + l) + " "
        }
        line += " ".repeat(postnamesize) + "88"
        println(line)
        line = "88" + " ".repeat(prenamesize)
        for (ch in name) {
            val p = pos[ch]!!
            val l = len[ch]!!
            line += c2.substring(p, p + l) + " "
        }
        line += " ".repeat(postnamesize) + "88"
        println(line)
        line = "88" + " ".repeat(prenamesize)
        for (ch in name) {
            val p = pos[ch]!!
            val l = len[ch]!!
            line += c3.substring(p, p + l) + " "
        }
        line += " ".repeat(postnamesize) + "88"
        println(line)
    }

}