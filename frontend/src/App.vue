<template>
  <div id="app">
    <navigation-bar />
    <router-view />
  </div>
</template>

<script>
import NavigationBar from '@/components/NavigationBar'
export default {
  name: 'App',
  components: { NavigationBar },
}
</script>

<style scoped></style>
