package io.eqoty

import okio.FileSystem
import okio.Path
import okio.Path.Companion.toPath

actual val fileSystem: FileSystem = TODO()
actual val snip721MigratableWasmGz: Path =
    "./kotlin/files/snip721_migratable.wasm.gz".toPath()