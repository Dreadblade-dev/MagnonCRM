<template>
  <div>
    <form @submit.prevent="submitHandler">
      <h1>Sign up</h1>
      <div>
        <input type="text" name="username" v-model="username" placeholder="Username" />
      </div>

      <div>
        <input type="text" name="email" v-model="email" placeholder="Email" />
      </div>

      <div>
        <input type="password" name="password" v-model="password" placeholder="Password" />
      </div>

      <div>
        <input type="password" v-model="confirmPassword" placeholder="Confirm password" />
      </div>

      <div>
        <button type="submit">
          Create Account
        </button>
      </div>
    </form>
    <div>
      Already have an account?
      <router-link to="/signin">
        Sign in
      </router-link>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'SignUp',
  data: () => ({
    username: '',
    email: '',
    password: '',
    confirmPassword: '',
  }),
  methods: {
    async submitHandler() {
      const response = await axios.post('/auth/signup', {
        username: this.username,
        email: this.email,
        password: this.password,
      })

      console.log(response)
    },
  },
}
</script>

<style scoped></style>
