config.resolve.fallback = {
    ...config.resolve.fallback,
    fs: require.resolve("file-system"),
    path: require.resolve("path-browserify"),
    crypto: require.resolve("crypto-browserify"),
    assert: require.resolve("assert/"),
    stream: require.resolve("stream-browserify"),
    http: require.resolve("stream-http"),
    https: require.resolve("https-browserify"),
    vm: require.resolve("vm-browserify"),
    os: require.resolve("os-browserify/browser"),
    url: require.resolve("url/"),
};
