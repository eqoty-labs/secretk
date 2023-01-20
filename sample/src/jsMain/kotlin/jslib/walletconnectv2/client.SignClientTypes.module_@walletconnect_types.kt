@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)

package jslib.walletconnectv2

//import SessionTypes.Namespaces
//import tsstdlib.Omit
//import ProposalTypes.Struct
//import `T$78`
//import ICore
//import jslib.walletconnectv2.Struct

external interface BaseEventArgs<T> {
    var id: Number
    var topic: String
    var params: T
}

external interface BaseEventArgs__0 : BaseEventArgs<Any>

//external interface `T$111` {
//    var namespaces: Namespaces
//}
//
//external interface `T$112` {
//    var method: String
//    var params: Any
//}
//
//external interface `T$113` {
//    var request: `T$112`
//    var chainId: String
//}
//
//external interface `T$114` {
//    var name: String
//    var data: Any
//}
//
//external interface `T$115` {
//    var event: `T$114`
//    var chainId: String
//}
//
//external interface `T$116` {
//    var id: Number
//}
//
//external interface EventArguments {
//    var session_proposal: Omit<BaseEventArgs<Struct>, String /* "topic" */>
//    var session_update: BaseEventArgs<`T$111`>
//    var session_extend: Omit<BaseEventArgs__0, String /* "params" */>
//    var session_ping: Omit<BaseEventArgs__0, String /* "params" */>
//    var session_delete: Omit<BaseEventArgs__0, String /* "params" */>
//    var session_expire: `T$78`
//    var session_request: BaseEventArgs<`T$113`>
//    var session_event: BaseEventArgs<`T$115`>
//    var proposal_expire: `T$116`
//}

//external interface Options : jslib.walletconnectv2.CoreTypes.Options {
//    var core: ICore?
//        get() = definedExternally
//        set(value) = definedExternally
//    var metadata: Metadata?
//        get() = definedExternally
//        set(value) = definedExternally
//}