<template>
  <div>
    <h3>Greeting component</h3>
    <p>Counter: {{ counter }}</p>
    <p>Username: {{ name }}</p>
  </div>
</template>

<script>
export default {
  name: 'Greeting',
  data: () => ({
    counter: 0,
    name: '',
  }),
  methods: {
    getGreeting() {
      this.$axios
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
