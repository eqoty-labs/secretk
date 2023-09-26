@file:JsModule("@happy-dom/global-registrator")
@file:JsNonModule

package jslibs.happydom


external object GlobalRegistrator {
    fun register()
    fun unregister()
}