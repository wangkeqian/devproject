import {postRequest} from '../utils/api'
import {getRequest} from '../utils/api'

//添加奖惩记录
export function addRecord(args){
  return postRequest('/personEc/add',args);
}
//查询Employeeec 
export function searchEmployeeec(args){
  if(null == args) args = new Object
  args['eid'] = ''
  return postRequest('/personEc/info',args);
}