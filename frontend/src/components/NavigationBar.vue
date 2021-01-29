<template>
  <div>
    <ul>
      <template v-if="isAuthenticated">
        <li>
          {{ user.username }}
        </li>

        <li>
          <router-link to="/">Home</router-link>
        </li>

        <li>
          <router-link to="/person">People list</router-link>
        </li>

        <li>
          <a href="#" @click.prevent="signOut">
            Sign out
          </a>
        </li>
      </template>

      <template v-else>
        <li>
          <router-link to="/signin">Sign in</router-link>
        </li>

        <li>
          <router-link to="/signup">Sign up</router-link>
        </li>
      </template>
    </ul>
  </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex'

export default {
  name: 'NavigationBar',
  computed: {
    ...mapGetters({
      isAuthenticated: 'auth/isAuthenticated',
      user: 'auth/user',
    }),
  },
  methods: {
    ...mapActions({
      signOutAction: 'auth/signOut',
    }),

    signOut() {
      this.signOutAction().then(() => {
        this.$router.replace({
          name: 'Greeting',
        })
      })
    },
  },
}
</script>

<style scoped></style>
