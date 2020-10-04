//用到node系统模块 使用npm init 得到packgae.json
const path = require('path')
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
module.exports ={
  entry: path.join(__dirname,'./src/main.js'),
  output: {
    path: path.join(__dirname,'dist'),
    filename: 'bundle.js',
    publicPath: 'dist/'
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
}