
<template>
  <div>
    <h1>{{title | upperCase}}</h1>
    <div class="selectA" v-show="type === 'A'">{{msg1}}</div>
    <div class="selectB" v-show="type !== 'A'">{{msg2}}</div>
    <div class="changeType" @click="changeType()">Try change it!</div>
    <v-child :message="mess"></v-child>
    <div class="testCount">
      自增<button class="increment" @click="increment()">{{count}}</button>
      <br>
      异步自增<button class="incrementByAsync" @click="incrementByAsync()">{{num}}</button>
    </div>
  </div>
</template>

<script>
import child from './child/child.vue'
export default {
  data () {
    return {
      title: 'Hello unit test',
      msg1: 'Apple',
      msg2: 'Bable',
      type: 'A',
      count: 0,
      num: 0,
      mess: 'This is child vue!'
    }
  },

  components: {
    'v-child': child
  },

  computed: {},

  methods: {
    changeType () {
      if (this.type === 'A') {
        this.type = ' '
      } else {
        this.type = 'A'
      }
    },
    increment () {
      this.count++
    },
    incrementByAsync () {
      window.setTimeout(() => {
        this.num++
      }, 1000)
    }
  },
  filters: {
    upperCase (str) {
      return str.toUpperCase()
    }
  }
}

</script>
<style>
.selectA, .selectB {
  display: inline-block;
  font-size: 28px;
}
.changeType {
  display: inline-block;
  margin: 20px;
  padding: 5px;
}
.testCount {
  margin-top: 50px;
}
button{
  width: 100px;
  margin: 10px;
  font-size: 18px;
  background: #fff;
  /* border: 1px solid #4CAF50; */
  border: none;
  transition-duration: 0.4s;
}
button:hover {
  background: #4CAF50;
  color: white;
}
button:focus {
  outline: none;
}
</style>
