<template>
    <div>
        <div>
            <search-bar :nations='nations'
                        :joblevels='joblevels'
                        :politicsstatus='politicsstatus'
                        :positions='positions'
                        @searchEmployeeec='searchEmployeeec'
                        :editData='editData'/>
        </div>  
        <per-ec-item  :employeeec='employeeec'
                      :total='total'
                      :currentPage='currentPage'
                      :pageSize='pageSize'
                      @currentChange='currentChange'
                      @editItem='editItem'/>
    </div>
</template>

<script>
    /**网络请求**/
    import {getAllPoliticsstatus, 
            getAllNations, 
            getAllPositions, 
            getAllJoblevels } from '@/utils/searchBar'
    import { searchEmployeeec } from '@/network/employeeec'
    /**组件**/
    import SearchBar from '@/components/sys/basic/SearchBar'
    import PerEcItem from '@/components/sys/basic/perEc/PerEcItem'
    export default {
        name: "PerEc",
        components: {
            SearchBar,
            PerEcItem
        },
        data(){
            return {
                nations: [],
                joblevels: [],
                politicsstatus: [],
                positions: [],
                employeeec: [],
                total: 0,
                currentPage: 1,
                pageSize: 10,
                editData: {}
            }
        },
        created() {
            this.initEmps()
        },
        methods: {
            /**
             *  初始数据
             */ 
            getAllPoliticsstatus(){
                getAllPoliticsstatus().then(res => {
                this.politicsstatus = res
                })
            },
            getAllNations(){
                getAllNations().then(res =>{
                this.nations = res
                })
            },
            getAllPositions(){
                getAllPositions().then(res =>{
                this.positions = res
                })
            },
            getAllJoblevels(){
                getAllJoblevels().then(res =>{
                this.joblevels = res
                })
            },
            initEmps(){
                this.getAllPoliticsstatus()
                this.getAllNations()
                this.getAllPositions()
                this.getAllJoblevels()
            },
            currentChange(obj){
                console.log('obj='+obj);
                
                this.searchEmployeeec(obj)
            },
            searchEmployeeec(args){
                searchEmployeeec(args).then(res =>{
                    this.employeeec = res.data
                    this.total = res.total
                })
            },
            editItem(data){
                this.editData = data
            }
        },
    }
</script>

<style scoped>

</style>