import {getRequest} from '../utils/api'

//搜索人
export function getEmployeeByArgs(args){
  return getRequest('/employee/basic/?'+args);
}
//惩罚原因
export function getRewardPunishType(){
  return getRequest('/personEc/getRewardPunishType');
}