<template>
  <div>
    <div v-for="person in persons" :key="person.id">
      <p>#{{ person.id }} | Name: {{ person.name }}</p>
      <hr />
    </div>
  </div>
</template>

<script>
export default {
  name: 'Person',
  data: () => ({
    persons: [],
  }),
  mounted() {
    this.$axios
      .get('/persons')
      .then(response => {
        this.persons = response.data
      })
      .catch(error => {
        console.log('[Error]: ', error.response.data)
      })
  },
}
</script>

<style scoped></style>
