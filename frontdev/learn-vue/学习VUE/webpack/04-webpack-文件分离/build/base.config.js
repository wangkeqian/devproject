//用到node系统模块 使用npm init 得到packgae.json
const path = require('path')
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const VueLoaderPlugin = require('vue-loader/lib/plugin')
const HtmlWebpackPlugin  = require('html-webpack-plugin')
module.exports ={
  entry: path.join(__dirname,'../src/main.js'),
  output: {
    path: path.join(__dirname,'../dist'),
    filename: 'bundle.js',
    // publicPath: 'dist/'
  },
  mode: 'development',
  module: {
    rules: [
      {
          test: /\.css$/,
          use : [
              { loader: "style-loader" },
              { loader: "css-loader" }
          ]
      },
      {
        test: /\.vue$/,
        use: ['vue-loader']
      },
      {
        test: /\.(png|jpg|gif|jpeg)$/,
        use: [
          {
            loader: 'url-loader',
            options: {
              limit: 13000,
              name: 'img/[name].[hash:8].[ext]'
            },
          
          }
        ]
      }
  ]
  },
  //安装vue，使用vue要用的
  resolve: {
    alias: {
      'vue$':'vue/dist/vue.esm.js'
    },
    extensions: ['.js','.css','.vue']
  },
  plugins:[
    new VueLoaderPlugin(),
    new HtmlWebpackPlugin({
      template: 'index.html'
    })
  ],
}