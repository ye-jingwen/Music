<template>
  <div>
      <the-header></the-header>
      <the-aside></the-aside>
      <router-view></router-view>
  </div>
</template>

<script>
import TheHeader from "./TheHeader.vue";
import TheAside from "./TheAside.vue";

export default {
  components: {
    TheHeader,
    TheAside,
  },
};
</script>