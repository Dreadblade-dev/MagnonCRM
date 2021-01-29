<template>
  <div>
    <h1>Greeting component</h1>
    <p>Counter: {{ counter }}</p>
    <p>Username: {{ name }}</p>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'Greeting',
  data: () => ({
    counter: 0,
    name: '',
  }),
  methods: {
    getGreeting() {
      axios
        .get('/greeting', { params: { name: 'Anton' } })
        .then(response => {
          this.counter = response.data.id
          this.name = response.data.content
        })
        .catch(error => {
          console.log('[Error]: ', error.response.data)
        })
    },
  },
  mounted() {
    this.getGreeting()
  },
}
</script>

<style scoped></style>
