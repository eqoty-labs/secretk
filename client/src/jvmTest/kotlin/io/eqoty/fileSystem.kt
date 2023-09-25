package io.eqoty

import okio.FileSystem
import okio.Path
import okio.Path.Companion.toPath

actual val fileSystem: FileSystem = FileSystem.SYSTEM
actual val snip721MigratableWasmGz: Path =
    "./src/commonTest/resources/files/snip721_migratable.wasm.gz".toPath()