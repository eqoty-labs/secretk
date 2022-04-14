package io.eqoty.encoding

import com.ionspin.kotlin.bignum.integer.BigInteger
import com.ionspin.kotlin.crypto.util.encodeToUByteArray
import io.eqoty.response.TypeValue
import io.eqoty.types.StdFee
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

inline fun <reified T> makeSignBytes(
    msgs: List<TypeValue<T>>,
    fee: StdFee,
    chainId: String,
    memo: String,
    accountNumber: BigInteger,
    sequence: BigInteger,
): UByteArray {
    val signJson = SignJson<T>(
        // eslint-disable-next-line @typescript-eslint/camelcase
        account_number = accountNumber.toString(),
        // eslint-disable-next-line @typescript-eslint/camelcase
        chain_id = chainId,
        fee = fee,
        memo = memo,
        msgs = msgs,
        sequence = sequence.toString(),
    )
    //val signMsg = sortJson(signJson);
    val test = Json.encodeToString(signJson)
    return test.encodeToUByteArray()
}