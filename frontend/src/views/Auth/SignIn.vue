<template>
  <div>
    <form @submit.prevent="submitHandler">
      <h1>Sign in</h1>

      <div>
        <label for="username">
          Username
        </label>

        <input type="text" id="username" name="username" v-model="form.username" />
      </div>

      <div>
        <label for="password">
          Password
        </label>

        <input type="password" id="password" name="password" v-model="form.password" />
      </div>

      <div>
        <button type="submit">
          Sign in
        </button>
      </div>
    </form>
    <div>
      Don't have an account?
      <router-link to="/signup">
        Sign up
      </router-link>
    </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'SignIn',
  data: () => ({
    form: {
      username: '',
      password: '',
    },
  }),
  methods: {
    ...mapActions({
      signIn: 'auth/signIn',
    }),
    submitHandler() {
      this.signIn(this.form)
        .then(() => {
          this.$router.replace({
            name: 'Greeting',
          })
        })
        .catch(() => {
          console.log('failed')
        })
    },
  },
}
</script>

<style scoped></style>
