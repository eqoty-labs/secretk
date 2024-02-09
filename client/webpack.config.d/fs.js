config.resolve.fallback = {
    ...config.resolve.fallback,
    fs: require.resolve("file-system"),
    path: require.resolve("path-browserify"),
    crypto: require.resolve("crypto-browserify"),
    buffer: require.resolve("buffer"),
    stream: require.resolve("stream-browserify"),
    os: require.resolve("os-browserify/browser")
};