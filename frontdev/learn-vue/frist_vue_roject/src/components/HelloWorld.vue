<template>
  <div class="hello">
    
    <div class="panel panel-primary">
        <div class="panel-heading">
          <h3 class="panel-title">添加汽车品牌</h3>
        </div>
        <div class="panel-body form-inline">
          <label for="">
              Name:
              <input type="text"  class="form-control" v-model='name'> 
          </label>
          <label for="">
              Desc:
              <input type="text" class="form-control" v-model='desc'> 
          </label>
          <label >
              <input type='button' value="添加" class="btn btn-primary"  @click="add"> 
          </label>
        </div>
    </div>
    
    <table class="table table-bordered table-hover table-striped">
      <thead>
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Ctime</th>
          <th>Desc</th>
          <th>Operation</th>
        </tr>
      </thead>
      <tbody is="transition-group"  appear>
            <tr v-for='item in list' :key='item.id'>
                <td>{{item.id}}</td>
                <td>{{item.name}}</td>
                <td>{{item.Ctime | dateFormat()}}</td>
                <td>{{item.desc}}</td>
                <td><a href="" @click.prevent="del(item.id)">删除</a></td>
            </tr> 
      </tbody>
    </table>
    
  </div>
</template>

<script>

export default {//过滤器

  data () {
    return {
      name: '',
      desc: '',
      msg: '',
      id: '',
      Ctime: '',
      list: []
    }
  },
    mounted() {
      this.$axios.get('/getAll')
      .then(res => {
        res.data.forEach((item,index,array) => {
          let car = {id: item.id, name:item.name, Ctime:item.createDate, desc:item.desc};
          this.list.push(car);
        });
      })
      .catch(err => {
        console.error(err); 
      })
    },
    methods: {
      del(id){
        this.$axios.delete('/del/'+id)
            .then(res => {
              var index = this.list.findIndex(item=>{
                if(item.id==id){
                    console.log(id)
                    return true;
                }
            });
            this.list.splice(index,1);
            })
            .catch(err => {
              console.error(err); 
            }) 

      },
      add(){
        let data = {
          'name':this.name,
          'desc':this.desc,
          'createDate': new Date()
        }
        this.$axios.post('/add',data)
            .then(res => {
              let car = {id: res.data.id, name:res.data.name, Ctime:res.data.createDate, desc:res.data.desc}
              this.list.push(car);
            })
            .catch(err => {
              console.error(err); 
            })        
      }  
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
        return `${year}-${month}-${day}  ${hours}:${minuter}:${second}`;
    }
  }

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .v-enter,
  .v-leave-to{
    opacity: 0;
    transform: translateY(220px);
  }
  .v-enter-active,
  .v-enter-active-leave-active{
    transition: all 1s ease;
  }
  td:hover{
            background-color: #1dc5a3;
            transition: all 1s ease;
        }
</style>

