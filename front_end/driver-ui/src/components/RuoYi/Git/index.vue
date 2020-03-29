<template>
  <div>
    <svg-icon icon-class="github" @click="goto"/>
  </div>
</template>

<script>
export default {
  name: 'leleplusGitHub',
  data() {
    return {
      url: 'https://github.com/leleplus/driver'
    }
  },
  methods: {
    goto() {
      window.open(this.url)
    }
  }
}
</script>
