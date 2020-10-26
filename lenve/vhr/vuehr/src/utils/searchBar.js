import {getRequest} from './api'

//政治面貌
export function getAllPoliticsstatus(){
  return getRequest('/employee/basic/politicsstatus');
}
//民族
export function getAllNations(){
  return getRequest('/employee/basic/nations');
}
//职位
export function getAllPositions(){
  return getRequest('/employee/basic/positions');
}
//职称
export function getAllJoblevels(){
  return getRequest('/employee/basic/joblevels');
}
//惩罚原因
export function getRewardPunishType(){
  return getRequest('/personEc/getRewardPunishType');
}