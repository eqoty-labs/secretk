package io.eqoty

import okio.FileSystem
import okio.NodeJsFileSystem
import okio.Path
import okio.Path.Companion.toPath

actual val fileSystem: FileSystem = NodeJsFileSystem
actual val snip721MigratableWasmGz: Path =
    "./kotlin/files/snip721_migratable.wasm.gz".toPath()