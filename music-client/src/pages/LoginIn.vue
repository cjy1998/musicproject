<template>
   <div class="login"> 
       <div class="login-head">
           <span>登录</span>
           </div>
           <el-form :model="registerForm" ref="registerForm"  :rules="rules">
       <el-form-item prop="username" label="用户名">
        <el-input
  placeholder="请输入账号"
  v-model="registerForm.input"
  clearable>
</el-input>
</el-form-item>
   <el-form-item prop="password" label="密码">
<div  class="input-password">
    <el-input placeholder="请输入密码" 
    v-model="registerForm.password" show-password>
    </el-input>
    </div>
</el-form-item>
 
  <div class="button">
  <el-button type="primary" @click="handleLoginIn" round>登录</el-button>
  <el-button type="success" @click="goSignUp" round>注册</el-button>
  </div>
  </el-form>
  <div class="icon">
    <span>其它方式登录</span>
      <img src="../assets/img/external_qq.svg" alt="" width="30px" height="30px">
       <img src="../assets/img/weixin.svg" alt="" width="30px" height="30px">
        <img src="../assets/img/Github.svg" alt="" width="30px" height="30px">
  </div>
    </div>
</template>
 
<script>
import {rules} from '../assets/data/form'
import {mixin} from '../mixins'
import { loginIn } from "../api/index";
export default {
    name: 'Login',
    mixins: [mixin],
    data(){
        return{
            registerForm:{
            input: '',
            password: ''
            },
            rules: {},
           
        }
    },
    mounted(){
        this.changeIndex('登录')
    },
    methods:{
        goSignUp(){
            this.$router.push({path:'/sign-up'});
            this.changeIndex('注册')
        },
        changeIndex(value){
          this.$store.commit('setActiveName',value)
        },
        handleLoginIn(){
           let _this = this;
           let params = new URLSearchParams();
           params.append('username',this.registerForm.input);
           params.append('password',this.registerForm.password);
           loginIn(params)
                .then(res =>{
                    if(res.code == 1){
                        _this.notify('登录成功','success');
                        _this.$store.commit('setLoginIn',true);
                        _this.$store.commit('setUserId',res.userMsg.id);
                        _this.$store.commit('setUsername',res.userMsg.username);
                        _this.$store.commit('setAvator',res.userMsg.avator);
                        
                        setTimeout(function(){
                            _this.changeIndex('首页')
                            _this.$router.push('/');
                        },2000);
                    }else{
                        _this.notify('登录失败','error');
                    }
                }) 
                .catch(error => {
                    _this.notify('用户名或密码错误','error')
                })
        }

    }

}
</script>

<style lang="scss" scoped>
@import '../assets/css/login-in.scss';
.input-password{
      margin-top: 30px;
      margin-bottom: 30px;
    }
    .button{
        padding: 0 60px;
        margin-bottom: 30px ;
    }
    // .icon span{
    //     // text-align: center;
    //     padding-top: -100px;
    //     display: inline-block;
    // }
   
    .icon img{
        padding: 0 10px;
    }
</style>