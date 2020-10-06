import axios from 'axios'
export function request(config){
  return new Promise((resolve,reject) => {
    const instance = axios.create({
      baseURL: 'http://localhost:8088',
      timeout: 5000
    })
    //发送真正的网络请求
    instance(config)
      .then(res =>{
        resolve(res)
      })
      .catch(err =>{
        reject(err)
      })
  })
}