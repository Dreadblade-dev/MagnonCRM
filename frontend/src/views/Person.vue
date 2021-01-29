<template>
  <div>
    <div v-for="person in persons" :key="person.id">
      <p>#{{ person.id }} | Name: {{ person.name }}</p>
      <hr />
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'Person',
  data: () => ({
    persons: [],
  }),
  async mounted() {
    const response = await axios.get('/persons')
    this.persons = response.data
  },
}
</script>

<style scoped></style>
