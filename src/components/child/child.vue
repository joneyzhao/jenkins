<!--  -->
<template>
  <div>
    <div class="childVue">{{message}}</div>
  </div>
</template>

<script>
export default {
  props: ['message']
}
</script>
<style>
.childVue {
  margin: 20px;
  color: coral;
  font-size: 24px;
}
</style>
