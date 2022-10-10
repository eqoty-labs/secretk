package io.eqoty

import io.eqoty.secretk.crypto.createWindowBroadcaster
import io.eqoty.secretk.crypto.destroyWindowBroadcaster
import io.eqoty.secretk.crypto.windowIsSetup
import jslibs.happydom.GlobalRegistrator
import kotlinx.browser.window
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


fun setupFakeWindow() {
    GlobalRegistrator.register()
    val crypto = js("""require('@peculiar/webcrypto');""")
    window.asDynamic().crypto = js("""new crypto.Crypto();""")
}

fun destroyFakeWindow() {
    window.asDynamic().crypto = null
    GlobalRegistrator.unregister()
}


actual suspend fun platformBeforeEach() {
    if (!windowIsSetup.value) {
        MainScope().launch {
            createWindowBroadcaster.collect {
                setupFakeWindow()
                windowIsSetup.emit(true)
            }
        }

        MainScope().launch {
            destroyWindowBroadcaster.collect {
                destroyFakeWindow()
                windowIsSetup.value = false
            }
        }
    }
}
