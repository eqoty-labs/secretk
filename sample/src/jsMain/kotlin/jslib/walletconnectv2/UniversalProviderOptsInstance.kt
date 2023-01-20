package jslib.walletconnectv2

fun UniversalProviderOptsInit(
    projectId: String?,
    logger: String? = "debug"
): UniversalProviderOpts {
    val opts: dynamic = Unit
    opts.projectId = projectId
    opts.logger = logger
    @Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
    return opts as UniversalProviderOpts
}