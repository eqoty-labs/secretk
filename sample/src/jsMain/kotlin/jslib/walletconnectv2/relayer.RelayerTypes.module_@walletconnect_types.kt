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

external interface ProtocolOptions {
    var protocol: String
    var data: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface PublishOptions {
    var relay: ProtocolOptions?
        get() = definedExternally
        set(value) = definedExternally
    var ttl: Number?
        get() = definedExternally
        set(value) = definedExternally
    var prompt: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var tag: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface SubscribeOptions {
    var relay: ProtocolOptions
}

external interface UnsubscribeOptions {
    var id: String?
        get() = definedExternally
        set(value) = definedExternally
    var relay: ProtocolOptions
}

external interface PublishPayload {
    var topic: String
    var message: String
    var opts: PublishOptions?
        get() = definedExternally
        set(value) = definedExternally
}

external interface MessageEvent {
    var topic: String
    var message: String
}

external interface RpcUrlParams {
    var protocol: String
    var version: Number
    var auth: String
    var relayUrl: String
    var sdkVersion: String
    var projectId: String?
        get() = definedExternally
        set(value) = definedExternally
}