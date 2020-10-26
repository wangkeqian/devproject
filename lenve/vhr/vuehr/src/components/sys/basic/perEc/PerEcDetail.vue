<template>
  <div>
    <el-dialog
    :title="title"
    :visible.sync="dialogVisible"
    width="80%">
<div>
    <el-form :model="emp" ref="empForm">
        <el-row>
            <el-col :span="6">
              <el-form-item label="姓名:" prop="name" label-position="right" label-width='70px'>
                <el-autocomplete
                size="mini"
                fixd="right"
                v-model="state"
                tyle="width: 150px;"
                :fetch-suggestions="querySearchAsync"
                placeholder="请输入内容"
                value-key="name"
                @select="handleSelect"
              ></el-autocomplete>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="员工部门:" prop="departmentName">
                <el-input size="mini" style="width: 150px" 
                          v-model="departmentName" :disabled="true" placeholder="员工部门"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="6">
                <el-form-item label="奖惩日期:" prop="ecdate">
                    <el-date-picker
                            size="mini"
                            type="date"
                            v-model="emp.ecdate"
                            value-format="yyyy-MM-dd"
                            style="width: 150px;"
                            placeholder="奖惩日期">
                    </el-date-picker>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row>
            <el-col :span="6">
                <el-form-item label="奖惩类型:" prop="ectype">
                    <el-select  v-model="emp.ectype" placeholder="奖惩类型" size="mini" style="width: 150px;">
                        <el-option
                                v-for="item in ectype"
                                :label="item.typeName"
                                :value="item.value">
                        </el-option>
                    </el-select>
                </el-form-item>
            </el-col>
            <el-col :span="6">
                <el-form-item label="奖惩原因:" prop="ecreason">
                  <el-select  v-model="emp.ecreason"  placeholder="奖惩类型" size="mini" style="width: 150px;">
                    <el-option
                            v-for="item of ecreasonv"
                            :label="item['desc']"
                            :value="item['value']">
                    </el-option>
                </el-select>
                </el-form-item>
            </el-col>
            <el-col :span="5">
              <el-form-item label="奖惩分数:" prop="ecpoint">
                <el-input size="mini" style="width: 150px" prefix-icon="el-icon-edit"
                          v-model="emp.ecpoint" placeholder="奖惩分数"></el-input>
              </el-form-item>
          </el-col>
        </el-row>
        <el-row>
            
            <el-col :span="5">
                <el-form-item label-position="right" label-width='70px'  label="备注:" prop="remark">
                  <el-input size="lg" style="width: 200px" prefix-icon="el-icon-edit"
                            v-model="emp.remark" placeholder="备注"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
    </el-form>
</div>

<el-button @click="exitDetail">取 消</el-button>
<el-button type="primary" @click="doAddEmp" style="float: right;">确 定</el-button>
</span>
</el-dialog>
  </div>
</template>

<script>
  import {getEmployeeByArgs,getRewardPunishType} from '@/network/searchEmployee'
  import {addRecord} from '@/network/employeeec'
  export default {
    name: 'PerEcDetail',
    props: {
      dialogVisible: Boolean,
      title: String,
      editData: Object
    },
    data() {
      return {
        ectype: [
          {"typeName": "奖励",'value': 'REWARD'},
          {"typeName": '惩罚','value': 'PUNISH'}
        ],
        ecreason: {},
        emp: {
          id: '',
          eid:'',
          name: '',
          ecdate: '',
          ectype: '',
          ecreason: '',
          ecpoint: 0,
          remark: ''
        },
        restaurants: [],
        state: '',
        timeout:  null,
        departmentName: ''

      }
    },
    computed: {
      ecreasonv(){
        return this.emp.ectype == 'PUNISH' ? this.ecreason['0'] : this.ecreason['1']
      }
    },
    methods: {
      //网络请求
      getEmployeeByArgs(args){
        getEmployeeByArgs(args).then(res =>{
          this.restaurants = res.data
        })
      },
      getRewardPunishType(){
        getRewardPunishType().then(res =>{
          this.ecreason = res
        })
      },
      addRecord(emp){
        addRecord(emp).then(res =>{
          if(res){
            console.log('添加成功');
            this.exitDetail()
          }
        })
      },

      //

      doAddEmp(){
        this.addRecord(this.emp);
      },
      exitDetail(){
        this.$emit('exitDetail',false)

      },
      querySearchAsync(queryString, cb) {
        
        this.getEmployeeByArgs("name="+queryString)
        var restaurants = this.restaurants;
        var results = queryString ? restaurants.filter(this.createStateFilter(queryString)) : restaurants;
        clearTimeout(this.timeout);
        this.timeout = setTimeout(() => {
          cb(results);
        }, 2000 * Math.random());
      },
      createStateFilter(queryString) {
        return (state) => {
          return (state.name.indexOf(queryString) === 0);
        };
      },
      handleSelect(item) {
        this.departmentName = item.department.name
        this.emp.name = item.name
        this.emp.eid = item.id
        console.log(item);
      }
    },
    mounted() {
      this.getRewardPunishType()
    },
    components: {},
    watch: {
      'editData':function(newVal){
        this.emp['id'] = newVal.id
        this.emp['eid'] = newVal.eid
        this.state = newVal.employeeName
        this.emp['ecdate'] = newVal.ecdate
        this.emp['ecpoint'] = newVal.ecpoint
        this.emp['remark'] = newVal.remark
        this.departmentName = newVal.department
        this.emp['ectype'] = newVal.ectype.value
        this.emp['ecreason'] = newVal.ecreason.value
      }
    },
  }
</script>

<style scoped>

    
</style>
