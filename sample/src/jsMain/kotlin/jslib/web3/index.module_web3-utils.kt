@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package web3

import kotlin.js.*
import org.khronos.webgl.*
import web3.eth.AbiItem

external interface `T$24` {
    var r: String
    var s: String
    var v: Number
}

external interface Utils {
    fun isBN(value: String): Boolean
    fun isBN(value: Number): Boolean
    fun toTwosComplement(value: Number): String
    fun toTwosComplement(value: String): String
    fun isAddress(address: String, chainId: Number = definedExternally): Boolean
    fun isHex(hex: String): Boolean
    fun isHex(hex: Number): Boolean
    fun isHexStrict(hex: String): Boolean
    fun isHexStrict(hex: Number): Boolean
    fun asciiToHex(string: String, length: Number = definedExternally): String
    fun hexToAscii(string: String): String
    fun toAscii(string: String): String
    fun bytesToHex(bytes: Array<Number>): String
    fun numberToHex(value: Number): String
    fun numberToHex(value: String): String
    fun checkAddressChecksum(address: String, chainId: Number = definedExternally): Boolean
    fun fromAscii(string: String): String
    fun fromDecimal(value: String): String
    fun fromDecimal(value: Number): String
    fun fromUtf8(string: String): String
    fun fromWei(value: String, unit: String /* "noether" | "wei" | "kwei" | "Kwei" | "babbage" | "femtoether" | "mwei" | "Mwei" | "lovelace" | "picoether" | "gwei" | "Gwei" | "shannon" | "nanoether" | "nano" | "szabo" | "microether" | "micro" | "finney" | "milliether" | "milli" | "ether" | "kether" | "grand" | "mether" | "gether" | "tether" */ = definedExternally): String
    fun fromWei(value: String): String
    fun hexToBytes(hex: String): Array<Number>
    fun hexToBytes(hex: Number): Array<Number>
    fun hexToNumber(hex: String): Number
    fun hexToNumber(hex: Number): Number
    fun hexToNumberString(hex: String): String
    fun hexToNumberString(hex: Number): String
    fun hexToString(hex: String): String
    fun hexToString(hex: Number): String
    fun hexToUtf8(string: String): String
    fun keccak256(value: String): String
    fun padLeft(value: String, characterAmount: Number, sign: String = definedExternally): String
    fun padLeft(value: String, characterAmount: Number): String
    fun padLeft(value: Number, characterAmount: Number, sign: String = definedExternally): String
    fun padLeft(value: Number, characterAmount: Number): String
    fun leftPad(string: String, characterAmount: Number, sign: String = definedExternally): String
    fun leftPad(string: String, characterAmount: Number): String
    fun leftPad(string: Number, characterAmount: Number, sign: String = definedExternally): String
    fun leftPad(string: Number, characterAmount: Number): String
    fun rightPad(string: String, characterAmount: Number, sign: String = definedExternally): String
    fun rightPad(string: String, characterAmount: Number): String
    fun rightPad(string: Number, characterAmount: Number, sign: String = definedExternally): String
    fun rightPad(string: Number, characterAmount: Number): String
    fun padRight(string: String, characterAmount: Number, sign: String = definedExternally): String
    fun padRight(string: String, characterAmount: Number): String
    fun padRight(string: Number, characterAmount: Number, sign: String = definedExternally): String
    fun padRight(string: Number, characterAmount: Number): String
    fun sha3(value: String): String?
    fun randomHex(bytesSize: Number): String
    fun utf8ToHex(string: String): String
    fun stringToHex(string: String): String
    fun toChecksumAddress(address: String, chainId: Number = definedExternally): String
    fun toDecimal(hex: String): Number
    fun toDecimal(hex: Number): Number
    fun toHex(value: Number): String
    fun toHex(value: String): String
    fun toUtf8(string: String): String
    fun toWei(param_val: String, unit: String /* "noether" | "wei" | "kwei" | "Kwei" | "babbage" | "femtoether" | "mwei" | "Mwei" | "lovelace" | "picoether" | "gwei" | "Gwei" | "shannon" | "nanoether" | "nano" | "szabo" | "microether" | "micro" | "finney" | "milliether" | "milli" | "ether" | "kether" | "grand" | "mether" | "gether" | "tether" */ = definedExternally): String
    fun toWei(param_val: String): String
    fun isBloom(bloom: String): Boolean
    fun isInBloom(bloom: String, value: String): Boolean
    fun isInBloom(bloom: String, value: Uint8Array): Boolean
    fun isUserEthereumAddressInBloom(bloom: String, ethereumAddress: String): Boolean
    fun isContractAddressInBloom(bloom: String, contractAddress: String): Boolean
    fun isTopicInBloom(bloom: String, topic: String): Boolean
    fun isTopic(topic: String): Boolean
    fun jsonInterfaceMethodToString(abiItem: AbiItem): String
    fun soliditySha3(vararg param_val: Any /* String | Number | BN | `T$25` | `T$26` | Boolean */): String?
    fun soliditySha3Raw(vararg param_val: Any /* String | Number | BN | `T$25` | `T$26` | Boolean */): String
    fun encodePacked(vararg param_val: Any /* String | Number | BN | `T$25` | `T$26` | Boolean */): String?
    fun getUnitValue(unit: String /* "noether" | "wei" | "kwei" | "Kwei" | "babbage" | "femtoether" | "mwei" | "Mwei" | "lovelace" | "picoether" | "gwei" | "Gwei" | "shannon" | "nanoether" | "nano" | "szabo" | "microether" | "micro" | "finney" | "milliether" | "milli" | "ether" | "kether" | "grand" | "mether" | "gether" | "tether" */): String
    fun unitMap(): Units
    fun testAddress(bloom: String, address: String): Boolean
    fun testTopic(bloom: String, topic: String): Boolean
    fun getSignatureParameters(signature: String): `T$24`
    fun stripHexPrefix(str: String): String
    fun toNumber(value: Number): Number
    fun toNumber(value: String): Number
}

external interface Units {
    var noether: String
    var wei: String
    var kwei: String
    var Kwei: String
    var babbage: String
    var femtoether: String
    var mwei: String
    var Mwei: String
    var lovelace: String
    var picoether: String
    var gwei: String
    var Gwei: String
    var shannon: String
    var nanoether: String
    var nano: String
    var szabo: String
    var microether: String
    var micro: String
    var finney: String
    var milliether: String
    var milli: String
    var ether: String
    var kether: String
    var grand: String
    var mether: String
    var gether: String
    var tether: String
}


