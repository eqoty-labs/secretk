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