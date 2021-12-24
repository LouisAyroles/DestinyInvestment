<template>
    <div class="sections h-full">
        <d-app-bar class="fixed left-0 top-0 right-0"></d-app-bar>
        <d-section id="home" class=".section">
            <d-title class="pt-20">Main section</d-title>
            <p>test</p>
        </d-section>

        <d-section id="raise" class=".section">
            <d-title>Projects preview</d-title>
        </d-section>

        <d-section id="invest" class=".section">
            <d-title>Roadmap</d-title>
        </d-section>

        <d-section id="blog" class=".section">
            <d-title>Why choose us</d-title>
        </d-section>

        <d-section id="contact" class=".section">
            <d-title>Raise or invest</d-title>
        </d-section>

        <d-section class=".section">
            <d-title>Mail</d-title>
        </d-section>
    </div>
</template>

<script lang="ts">
import Vue from 'vue'
import Component from "vue-class-component";
import DSection from "~/components/DSection.vue";
import DAppBar from "~/components/DAppBar.vue";
import DTitle from "~/components/DTitle.vue";
@Component({
    components: {DTitle, DAppBar, DSection}
})
export default class IndexPage extends Vue {

}
</script>

<style lang="scss" scoped>
.sections {
    section:nth-child(odd) {
        @apply bg-gray-300;
        @apply dark:bg-gray-900;
    }
}
</style>

<style>
/* Style that should be applied to all the application */

* {
    scroll-behavior: smooth;
}

html, body {
    /* Common theme */
    @apply p-0 min-w-full min-h-full h-full;
    /* Light theme */
    @apply bg-gray-100 text-gray-900;
    /* Dark theme */
    @apply dark:bg-black dark:text-gray-200;
}

#__nuxt, #__layout {
    @apply min-h-full h-full
}
</style>
