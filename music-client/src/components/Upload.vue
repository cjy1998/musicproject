<template>
  <div class="upload">
      <p class="title">修改头像</p>
      <hr>
      <div class="section">
          <el-upload :action="uploadUrl()" drag
          :show-file-list="false"
          :on-success="handleAvatorSuccess"
          :before-upload="beforeAvatorUpload">
            <i class="el-icon-upload"></i>
            <div>
                将文件拖到此处，或<span style="color:blue">修改头像</span>
            </div>
          </el-upload>
      </div>
  </div>
</template>

<script>
import {mapGetters} from 'vuex';
import {mixin} from '../mixins';
export default {
    name: 'upload',
    mixins: [mixin],
    data(){
        return{

        }
    },
    computed:{
        ...mapGetters([
            'userId'
        ])
    },
    methods:{
        uploadUrl(){
            return `${this.$store.state.configure.HOST}/consumer/updateConsumerPic?id=${this.userId}`
        },
       handleAvatorSuccess(res,file){
           if (res.code == 1) {
               this.$store.commit('setAvator',res.avator);
               this.notify('修改成功','success');
           }else{
               this.notify('修改失败','error')
           }
       },
       beforeAvatorUpload(file){
           const isJPG = file.type == 'image/jpeg';
           const isLt10M = file.size / 1024 /1024 <10;
           if (!isJPG) {
               this.notify('上传头像图片只能是JPG格式','error');
               return false;
           }
           if(!isLt10M){
               this.notify('上传头像图片不能大于10MB','error')
               return false
           }
           return true;
       }
    }
}
</script>

</script>
<style lang="scss" scoped>
@import '../assets/css/upload.scss';
</style>