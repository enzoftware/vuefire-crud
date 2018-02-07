<template>
  <div id="app">
    <div>
      <label> Name: </label>
      <input type="text" v-model="name"/>
      <button @click="submitName()">Add</button>
    </div>
    <div>
      <ul>
        <li v-for="personName of names" v-bind:key="personName['.key']">
          <div v-if="!personName.edit">
            <p>{{ personName.name }} </p>
            <button @click="removePerson(personName['.key'])">Delete</button>
            <button @click="editPerson(personName['.key'])">Edit</button>
          </div>
          <div v-else>
            <input type="text" v-model="personName.name">
            <button @click="saveEdit(personName)">Save</button>
            <button @click="cancelEdit(personName['.key'])">Cancel</button>
          </div>
        </li>
      </ul>
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
      this.name = '';
    },
    removePerson(key){
      namesRef.child(key).remove();
    },
    editPerson(key){
      namesRef.child(key).update({ 
        edit: true,
      })
    },
    saveEdit(person){
      const key = person['.key'];
      namesRef.child(key).set({
        name: person.name,
        edit: false
      });
    },
    cancelEdit(key){
      namesRef.child(key).update({
        edit: false
      });
    }
  },
  firebase:{
    names : namesRef
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

h1 {
  font-weight: normal;
}


</style>
