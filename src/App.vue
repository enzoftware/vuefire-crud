<template>
  <div id="app">
    <div>
      <label> Name: </label>
      <input type="text" v-model="name"/>
      <button @click="submitName()">Add</button>
    </div>
  </div>
</template>

<script>

import { namesRef } from './firebase'


export default {
  name: 'app',
  data () {
    return {
      name: 'Paul'
    }  
  },
  methods:{
    submitName(){
      namesRef.push({name : this.name 
                    ,edit : false});
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #3d85ce;
  margin-top: 60px;
}

h1{
  font-weight: normal;
}

</style>
