<template>
    <nuxt-tutorial/>
</template>

<script lang="ts">
import Vue from 'vue'
import Component from "vue-class-component";
import NuxtTutorial from "~/components/Tutorial.vue";

@Component({
    components: {NuxtTutorial}
})
export default class IndexPage extends Vue {

}
</script>
