
import Vue  from "vue";
import vuex from "vuex";
import configure from "./configure"
import song from "./song"
import user from "./user"

Vue.use(vuex)

const store =new vuex.Store({
   modules :{
       configure,
       song,
       user
   }
}
)

export default store;

