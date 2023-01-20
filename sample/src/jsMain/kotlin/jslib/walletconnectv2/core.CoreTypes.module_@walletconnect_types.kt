@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package jslib.walletconnectv2

import kotlin.js.*
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*
//import IKeyChain
//import IKeyValueStorage
//import KeyValueStorageOptions
//
//external interface Options {
//    var projectId: String?
//        get() = definedExternally
//        set(value) = definedExternally
//    var name: String?
//        get() = definedExternally
//        set(value) = definedExternally
//    var relayUrl: String?
//        get() = definedExternally
//        set(value) = definedExternally
//    var logger: dynamic /* String? | Logger? */
//        get() = definedExternally
//        set(value) = definedExternally
//    var keychain: IKeyChain?
//        get() = definedExternally
//        set(value) = definedExternally
//    var storage: IKeyValueStorage?
//        get() = definedExternally
//        set(value) = definedExternally
//    var storageOptions: KeyValueStorageOptions?
//        get() = definedExternally
//        set(value) = definedExternally
//}

external interface Metadata {
    var name: String
    var description: String
    var url: String
    var icons: Array<String>
}