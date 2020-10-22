const webpackMerge = require('webpack-merge')
const baseconfig   = require('./base.config.js')
module.exports = webpackMerge.merge(baseconfig,{
  devServer: {
    contentBase: './dist',
    inline: true
  }
})