package io.eqoty

import io.eqoty.kryptools.aessiv.createWindowBroadcaster
import io.eqoty.kryptools.aessiv.destroyWindowBroadcaster
import io.eqoty.kryptools.aessiv.windowIsSetup
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


var isFirstRunAndNoWindow = !windowIsSetup.value

actual suspend fun platformBeforeEach() {
    if (isFirstRunAndNoWindow) {
        isFirstRunAndNoWindow = false
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
