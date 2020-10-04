<template>
  <div class="hello">
    
    <div class="panel panel-primary dropdown">
        <div class="panel-heading">
          <h3 class="panel-title">添加汽车品牌</h3>
        </div>
        <div class="panel-body form-inline">
          <label for="">
            TotalPrice:
            <input type="text"  class="form-control" :value=totalPrice disabled='disabled'>
        </label>
          <label for="">
              Name:
              <input type="text"  class="form-control" v-model='name'> 
          </label>
          <label for="">
            Price:
            <input type="text"  class="form-control" v-model='price'> 
          </label>
          <label for="ordinary">
              普通轿车:
              <input type="radio" id='ordinary' class="form-control" v-model='desc' value='ordinary' @keyup.enter="add"> 
          </label>
          <label for="luxury">
            豪车:
            <input type="radio" id='luxury' class="form-control" v-model='desc' value='luxury' @keyup.enter="add"> 
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
          <th>Price</th>
          <th>Ctime</th>
          <th>Desc</th>
          <th>Purchase Quantity</th>
          <th>Operation</th>
        </tr>
      </thead>
      <tbody is="transition-group"  appear>
            <tr v-for='(item,index) in list' :key='item.id'>
                <td>{{item.id}}</td>
                <td>{{item.name}}</td>
                <td>{{item.price | tofixed()}}</td>
                <td>{{item.Ctime | dateFormat()}}</td>
                <td>{{item.desc}}</td>
                <th>
                  <button @click=decrement(index) v-bind:disabled="item.purchaseQuantity == 0">-</button>
                  <label>{{item.purchaseQuantity}}</label>
                  <button @click=increment(index)>+</button>
                </th>
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
      desc: 'luxury',
      msg: '',
      id: '',
      Ctime: '',
      price: '',
      purchaseQuantity: 0,
      list: []
    }
  },
    mounted() {
      this.$axios.get('getAll')
      .then(res => {
        res.data.forEach((item,index,array) => {
          let car = {
            id: item.id, 
            name:item.name,
            price: item.price,
            Ctime:item.createDate,
            purchaseQuantity: item.purchaseQuantity,
            desc:item.desc
          };
          this.list.push(car);
        });
      })
      .catch(err => {
        console.error(err); 
      })
    },
    methods: {
      del(id){
        this.$axios.delete('del/'+id)
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
          'price':this.price,
          'purchaseQuantity':this.purchaseQuantity,
          'createDate': new Date()
        }
        this.$axios.post('/add',data)
            .then(res => {
              let car = {
                id: res.data.id, 
                name: res.data.name, 
                price: res.data.price, 
                Ctime: res.data.createDate, 
                purchaseQuantity:res.data.purchaseQuantity,
                desc: res.data.desc}
              this.list.push(car);
            })
            .catch(err => {
              console.error(err); 
            })        
      },
      decrement(index){
        this.list[index].purchaseQuantity--;
        // const price = this.list[index].price;
        // this.computedTotalPrice(price,'decrement')
      },
      increment(index){
        this.list[index].purchaseQuantity++;
        // const price = this.list[index].price;
        // this.computedTotalPrice(price,'increment')
      },
      computedTotalPrice(price,type){
        if(type === 'increment'){
          this.totalPrice += price;
        }else{
          this.totalPrice -= price;
        }
      }
    },
    computed: {
      totalPrice(){
        return this.list.reduce((prevalue,car) =>
         {return prevalue + car.price*car.purchaseQuantity},0)
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
    },
    tofixed(price){
      return '￥'+price.toFixed(2);
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

