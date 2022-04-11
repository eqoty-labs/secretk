package io.eqoty.crypto.elliptic.utils

import io.eqoty.crypto.elliptic.biginteger.BN
import kotlin.math.max


fun getNAF(num: BN, w: Int, bits: Int): Array<Int> {
    var naf = Array(max(num.bitLength().toInt(), bits) + 1) { 0 }
    naf.fill(0);

    var ws = 1 shl (w + 1);
    var k = num

    for (i in naf.indices) {
        var z: Int
        var mod = k.andln(ws - 1)
        if (k.isOdd()) {
            if (mod > (ws shr 1) - 1) {
                z = (ws shr 1) - mod
            } else {
                z = mod
            }
            k = k.subtract(BN(z))
        } else {
            z = 0;
        }

        naf[i] = z;
        k = k.shr(1)
    }

    return naf;
}

fun getJSF(_k1: BN, _k2: BN): List<MutableList<Int>> {
    val jsf = listOf<MutableList<Int>>(
        mutableListOf(),
        mutableListOf()
    )

    var k1 = _k1
    var k2 = _k2
    var d1 = 0;
    var d2 = 0;
    var m8: Int
    while (k1 > -d1 || k2 > -d2) {
        // First phase
        var m14 = (k1.andln(3) + d1) and 3
        var m24 = (k2.andln(3) + d2) and 3
        if (m14 == 3)
            m14 = -1
        if (m24 == 3)
            m24 = -1
        var u1: Int
        if ((m14 and 1) == 0) {
            u1 = 0
        } else {
            m8 = (k1.andln(7) + d1) and 7
            if ((m8 == 3 || m8 == 5) && m24 == 2)
                u1 = -m14
            else
                u1 = m14
        }
        jsf[0].add(u1)

        var u2: Int
        if ((m24 and 1) == 0) {
            u2 = 0
        } else {
            m8 = (k2.andln(7) + d2) and 7
            if ((m8 == 3 || m8 == 5) && m14 == 2)
                u2 = -m24;
            else
                u2 = m24;
        }
        jsf[1].add(u2)

        // Second phase
        if (2 * d1 == u1 + 1)
            d1 = 1 - d1
        if (2 * d2 == u2 + 1)
            d2 = 1 - d2
        k1 = k1.shr(1)
        k2 = k2.shr(1)
    }

    return jsf
}