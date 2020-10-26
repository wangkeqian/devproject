<template>
  <div style="margin-top: 10px">
    <el-table
            :data="employeeec"
            stripe
            border
            v-loading="loading"
            element-loading-text="正在加载..."
            element-loading-spinner="el-icon-loading"
            element-loading-background="rgba(0, 0, 0, 0.8)"
            style="width: 100%">
        <el-table-column
                type="selection"
                width="55">
        </el-table-column>
        <el-table-column
                prop="employeeName"
                fixed
                align="center"
                label="姓名"
                width="100">
        </el-table-column>
        <el-table-column
                prop="department"
                label="员工部门"
                align="center"
                width="100">
        </el-table-column>
        <el-table-column
                prop="ecDate"
                label="奖惩日期"
                align="center"
                width="150">
                <template slot-scope="scope">
                  {{scope.row.ecdate | dateFormat}}
                </template>
        </el-table-column>
        <el-table-column
                prop="ecpoint"
                width="95"
                align="center"
                label="奖惩分数">
        </el-table-column>
        <el-table-column
                prop="ectype"
                width="70"
                align="center"
                label="奖惩类型">
                <template slot-scope="scope">
                  {{scope.row.ectype.typeName}}
                </template>
        </el-table-column>
        <el-table-column
                prop="ecreason"
                width="120"
                align="center"
                label="奖惩原因">
                <template slot-scope="scope">
                  {{scope.row.ecreason.typeName}}
                </template>
        </el-table-column>
        <el-table-column
                prop="remark"
                width="350"
                align="center"
                label="备注">
        </el-table-column>

        <el-table-column

                width="200"
                align="center"
                fixed="right"
                label="操作">
            <template slot-scope="scope">
                <el-button @click="showEditEmpView(scope.row)" style="padding: 3px" size="mini">编辑</el-button>
                <el-button style="padding: 3px" size="mini" type="primary">查看高级资料</el-button>
                <el-button style="padding: 3px" size="mini" type="danger">删除</el-button>
            </template>
        </el-table-column>
    </el-table>
    <div style="display: flex;justify-content: flex-end">
        <el-pagination style="float:right"
                background
                @current-change="currentChange"
                @size-change="sizeChange"
                layout="sizes, prev, pager, next, jumper, ->, total, slot"
                :total="total">
        </el-pagination>
    </div>
</div>        
</template>

<script>

  export default {
    name: 'PerEcItem',
    props: {
      employeeec: Array,
      total: Number,
      currentPage: Number,
      pageSize: Number
    },
    data() {
      return {
        loading: false,
      }
    },
    methods: {

      sizeChange(){
        console.log('sizeChange');
      },
      currentChange(currentPage){
        this.currentPage = currentPage
        console.log('currentPage='+currentPage);
        
        let obj = new Object
        obj['page'] = this.currentPage
        obj['size'] = this.pageSize
        this.$emit('currentChange',obj)
      },
      showEditEmpView(data){
        this.$emit('editItem',data)
        
      }
    },
    components: {
    
    },
    filters:{
      dateFormat:function(dateStr){
        let df = new Date(dateStr);
        let year = df.getFullYear();
        let month = df.getMonth()+1;
        let day = df.getDate();
        let hours = df.getHours();
        let minuter = df.getMinutes();
        let second = df.getSeconds().toString().padStart(2,'0');
        //return year+'-'+month+'-'+day;
        // return `${year}-${month}-${day}  ${hours}:${minuter}:${second}`;
        return `${year}-${month}-${day}`;
    },
  }
}
</script>

<style scoped>
</style>
