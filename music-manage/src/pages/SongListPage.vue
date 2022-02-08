<template>
    <div class="table">
        <div class="container">
            <div class="handle-box">
                 <el-button type="primary" size="mini" @click="delAll">批量删除</el-button>
                <el-input v-model="select_word" size="mini" placeholder="筛选关键字" class="handle-input"></el-input>
                <el-button type="primary" size="mini" @click="centerDialogVisible = true">添加歌单</el-button>
            </div>
        </div>
        <el-table size="mini" border style="width:100%" height="680px" :data="data" @selection-change="handleSelectionChange">
            <!-- 多选框，批量删除 -->
             <el-table-column type="selection" label="全选" width="40px"></el-table-column>
            <el-table-column label="歌单图片" width="110" align="center">
                <template slot-scope="scope">
                    <div class="songList-img">
                        <img :src="getUrl(scope.row.pic)" style="width:100%"/>
                    </div>
                   <!-- 上传 3个函数action before-upload（上传之前要执行的函数）on-success（上传成功之后要执行的函数） -->
                    <el-upload :action="uploadUrl(scope.row.id)" :before-upload="beforeAvatorUpload" 
                        :on-success="handleAvatorSuccess">
                        <el-button size="mini">更新图片</el-button>
                    </el-upload>
                </template>
            </el-table-column>
            <el-table-column prop="title" label="标题" width="120" align="center"></el-table-column>
            <el-table-column label="简介">
                <template slot-scope="scope">
                    <p style="height:100px;overflow:scroll">{{scope.row.introduction}}</p>
                </template>
            </el-table-column>
              <el-table-column prop="style" label="风格" width="120" align="center"></el-table-column>
            <el-table-column label="歌曲管理" width="110px" align="center">
                <template slot-scope="scope">
                    <el-button size="mini" @click="songEdit(scope.row.id)">歌曲管理</el-button> 
                </template>
            </el-table-column>
            <el-table-column label="操作" width="150px" align="center">
                <template slot-scope="scope">
                   <el-button size="mini" @click="handleEdit(scope.row)">编辑</el-button> 
                    <el-button size="mini" type="danger" @click="handleDelete(scope.row.id)">删除</el-button> 
                </template>
            </el-table-column>
              
        </el-table>
        <!-- 分页 -->
        <div class="pagination">
            <el-pagination 
            background 
            layout="total,prev,pager,next" 
            :current-page="currentPage" 
            :page-size="pageSize" 
            :total="tableData.length"
            @current-change="hanfleCurrentChange"
            >
            </el-pagination>
        </div>
        <el-dialog title="添加歌单" :visible.sync="centerDialogVisible" width="400px" center>
            <el-form :model="registerForm" ref="registerForm" label-width="80px">
                <el-form-item prop="title" label="歌单名" size="mini">
                    <el-input v-model="registerForm.title" placeholder="歌单名"></el-input>
                </el-form-item>
                <el-form-item prop="introduction" label="简介" size="mini">
                    <el-input v-model="registerForm.introduction" placeholder="简介" type="textarea"></el-input>
                </el-form-item> 
                 <el-form-item prop="style" label="风格" size="mini">
                    <el-input v-model="registerForm.style" placeholder="歌单名"></el-input>
                </el-form-item>          
            </el-form>
            <span slot="footer">
                <el-button size="mini" @click="centerDialogVisible = false">取消</el-button>
                <el-button size="mini" @click="addsongList">确定</el-button>
                
            </span>
        </el-dialog>
<!-- 修改歌单的弹窗 -->
          <el-dialog title="修改歌单" :visible.sync=" editVisible" width="400px" center>
            <el-form :model="form" ref="form" label-width="80px">
                <el-form-item prop="title" label="歌单名" size="mini">
                    <el-input v-model="form.title" placeholder="歌单名"></el-input>
                </el-form-item>
                <el-form-item prop="introduction" label="简介" size="mini">
                    <el-input v-model="form.introduction" placeholder="简介" type="textarea"></el-input>
                </el-form-item>  
                   <el-form-item prop="style" label="风格" size="mini">
                    <el-input v-model="form.style" placeholder="风格"></el-input>
                </el-form-item>              
            </el-form>
            <span slot="footer">
                <el-button size="mini" @click="editVisible = false">取消</el-button>
                <el-button size="mini" @click="editSave">确定</el-button>
                
            </span>
        </el-dialog>
        <!-- //删除歌单对话框 -->
          <el-dialog title="删除歌单" :visible.sync="delVisible" width="300px" center>
          <div align="center">此操作将永久删除该文件, 是否继续?</div>
           <span slot="footer">
                <el-button size="mini" @click="delVisible = false">取消</el-button>
                <el-button size="mini" @click="deletRow">确定</el-button>
                
            </span>
        </el-dialog>
    </div>
</template>

<script>

import {getAllSongList,setSongList,updateSongList,deleteSongList} from '../api/index';
import {mixin} from '../mixins/index';
export default {
    mixins: [mixin],
    data(){
        return{
            centerDialogVisible: false,//添加弹窗是否显示
            editVisible: false,     //编辑弹窗是否显示
            delVisible: false,  //删除弹窗是否显示
            //  options: provinceAndCityData,
        selectedOptions: [],
            registerForm:{      //添加框
                title: '',
                introduction: '',
                style: ''
            },
            form:{      //编辑框
                id:'',
                title: '',
                introduction: '',
                style: ''
            },
            //查询到的歌单数据
            tableData: [],
            tempData: [],
            //搜索框已经输入了哪些文字
            select_word:'',
            pageSize: 5,//分页每页大小
            currentPage: 1, //当前页
            idx : -1,//删除歌单的id
            multipleSelection:[],//被选中的项

        }
    },
    computed:{
        //计算当前搜索结果表里的数据
        data (){
            return this.tableData.slice((this.currentPage - 1)*this.pageSize,this.currentPage * this.pageSize)
        }
    },
    watch:{
// 对select_word的值进行监控
select_word: function(){
    // 如果搜索框没有内容，那么 this.tableData = this.tempData;就是数据不变
    if(this.select_word == ''){
        this.tableData = this.tempData;
    }else{
        // 如果搜索框有内容，先把tableData制空，也就是歌单信息显示框指控，然后遍历tempData赋值给item，如果搜索框里的内容包含在item里，那么tableData.push(item)
        this.tableData = [];
        for(let item of this.tempData){
            if(item.title.includes(this.select_word)){
                this.tableData.push(item);
            }
        }
    }
}
    },
    created(){
        this.getData();
    },
    methods:{
        //获取当前页
        hanfleCurrentChange(val){
            this.currentPage = val;
        },
        //查询所有歌单
        getData(){
             this.tempData = [];
            this.tableData = [];
            getAllSongList().then(res =>{
                this.tempData = res;
               this.tableData = res;
                this.currentPage = 1;

            })
        },
    //     handleChange () {
    //     var loc = "";
    //     for (let i = 0; i < this.selectedOptions.length; i++) {
    //         loc += CodeToText[this.selectedOptions[i]];
    //     }
    //      this.registerForm.location = loc;
    //     console.log(loc)//打印区域码所对应的属性值即中文地址
    //   },
        //添加歌单
        addsongList(){
            let params = new URLSearchParams()
            params.append('title',this.registerForm.title)
           params.append('pic','/img/songListPic/user.png')
            params.append('introduction',this.registerForm.introduction)
             params.append('style',this.registerForm.style)
           
           setSongList(params)
          .then((res) => {
                if(res.code == 1){
                     this.getData();
                    this.notify("添加成功","success");
                }else{
                    this.notify("添加失败","error");
                }
            })
            .catch(err => {
                console.log(err);
            });
            this.centerDialogVisible = false;
        },
        //弹出编辑歌单信息页面
        handleEdit(row){
            this.editVisible = true;
            this.form = {
                id: row.id,
                title: row.title,
                introduction: row.introduction,
                style: row.style
            }
        },
      
        //保存修改歌单信息
        editSave(){
            let params = new URLSearchParams()
            params.append('id',this.form.id)
            params.append('title',this.form.title)
            params.append('introduction',this.form.introduction)
              params.append('style',this.form.style)

           updateSongList(params)
          .then((res) => {
                if(res.code == 1){
                    this.getData();
                    this.notify("修改成功","success");
                }else{
                    this.notify("修改失败","error");
                }
            })
            .catch(err => {
                console.log(err);
            });
            this.editVisible  = false;
        },
         
        //单个删除歌单
      deletRow(){
           deleteSongList(this.idx)
              .then((res) => {
                if(res){
                    this.getData();
                    this.notify("删除成功","success");
                }else{
                    this.notify("删除失败","error");
                }
            })
            .catch(err => {
                console.log(err);
            });
            this.delVisible  = false;
      },
         //更新图片
        uploadUrl(id){
            return `${this.$store.state.HOST}/songList/updateSongListPic?id=${id}`
        },
        // areaHandleChange () {
        //     let loc = this.selectedOptions;
        //   let a=  CodeToText[loc[0]]+loc[value[1]];
        //   return this.registerForm.location=a;
      //这里可以把获取到的value值赋值给后台字段做存储使用
      //value是数组，如 绑定值：[ "330000", "330100", "330106" ]
      //只需要把区存到后台数据库即可，即取到value[2]即可，在数据回显时，便可以自动显示整个省市区
      //非常方便简介
      //CodeToText是个大对象，属性是区域码，属性值是汉字 用法例如：CodeToText['110000']输出北京市
      //TextToCode是个大对象，属性是汉字，属性值是区域码 用法例如：TextToCode['北京市'].code输出110000,TextToCode['北京市']['市辖区'].code输出110100,TextToCode['北京市']['市辖区']['朝阳区'].code输出110105     
      //想获取到省市区中文的话，就这样写：CodeToText[value[0]]+CodeToText[value[1]]+CodeToText[value[2]];
    // }
    //转向歌曲管理页面
    songEdit(id,name){
            this.$router.push({path:`/ListSong`,query:{id}});
    }
    }
}
</script>

<style scoped>
    .handle-box{
        margin-bottom: 20px;
    }
    .songList-img{
        width: 100%;
        height: 80px;
        border-radius: 5px;
        margin-bottom: 5px;
        overflow: hidden;
    }
    .handle-input{
        width: 300px;
        display: inline-block;
    }
    .pagination{
        display: flex;
        justify-content: center;
    }
</style>