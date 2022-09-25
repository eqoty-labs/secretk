package io.eqoty.types

data class FeeTable(
    var upload: StdFee,
    var init: StdFee,
    var exec: StdFee,
    var send: StdFee,
) {

    fun overwrite(newTable: FeeTable?): FeeTable {
        newTable ?: return this
        newTable.upload.let {
            upload = it
        }
        newTable.init.let {
            init = it
        }
        newTable.exec.let {
            exec = it
        }
        newTable.send.let {
            send = it
        }
        return this
    }

    companion object {
        val Default
            get() = FeeTable(
                upload = StdFee(
                    listOf(Coin("uscrt", 250_000)),
                    1_000_000
                ),
                init = StdFee(
                    listOf(Coin("uscrt", 125_000)),
                    500_000
                ),
                exec = StdFee(
                    listOf(Coin("uscrt", 50_000)),
                    200_000
                ),
                send = StdFee(
                    listOf(Coin("uscrt", 20_000)),
                    80_000
                )
            )
    }
}
