package jslib.walletconnectv2

fun NamespaceInit(
    methods: Array<String>,
    chains: Array<String>,
    events: Array<String>
): Namespace {
    val namespace: dynamic = Unit
    namespace.methods = methods
    namespace.chains = chains
    namespace.events = events
    @Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
    return namespace as Namespace
}