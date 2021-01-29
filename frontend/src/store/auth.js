import axios from 'axios'

export default {
  namespaced: true,
  state: {
    token: null,
    user: null,
  },
  mutations: {
    setToken(state, token) {
      state.token = token
    },

    setUser(state, data) {
      state.user = data
    },
  },
  getters: {
    isAuthenticated(state) {
      return state.token && state.user
    },

    user(state) {
      return state.user
    },
  },
  actions: {
    async signIn({ dispatch }, credentials) {
      const response = await axios.post('auth/signin', credentials)

      return dispatch('attempt', response.data)
    },

    async attempt({ commit, state }, token) {
      if (token) {
        commit('setToken', token)
      }

      if (!state.token) {
        return
      }

      try {
        let response = await axios.get('auth/me')

        commit('setUser', response.data)
      } catch (e) {
        commit('setToken', null)
        commit('setUser', null)
      }
    },

    signOut({ commit }) {
      return axios.post('auth/signout').then(() => {
        commit('setToken', null)
        commit('setUser', null)
      })
    },
  },
}
