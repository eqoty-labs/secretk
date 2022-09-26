package io.eqoty

import okio.FileSystem
import okio.NodeJsFileSystem
import okio.Path
import okio.Path.Companion.toPath

actual val fileSystem: FileSystem = NodeJsFileSystem
actual val snip721ReferenceImplWasmGz: Path =
    "./kotlin/files/snip721-reference-impl.wasm.gz".toPath()