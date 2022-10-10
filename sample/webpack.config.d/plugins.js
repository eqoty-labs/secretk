// https://stackoverflow.com/questions/70429654/webpack-5-errors-cannot-resolve-crypto-http-and-https-in-reactjs-proje
const webpack = require('webpack');

config.plugins.push(
    new webpack.ProvidePlugin({
        process: 'process/browser',
        Buffer: ['buffer', 'Buffer'],
    }),
);
