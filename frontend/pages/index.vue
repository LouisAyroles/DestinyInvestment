<template>
    <div class="sections h-full">
        <d-app-bar></d-app-bar>
        <d-section class=".section">
            <d-title>Main section</d-title>
            <p>test</p>
        </d-section>

        <d-section class=".section">
            <d-title>Projects preview</d-title>
        </d-section>

        <d-section class=".section">
            <d-title>Roadmap</d-title>
        </d-section>

        <d-section class=".section">
            <d-title>Why choose us</d-title>
        </d-section>

        <d-section class=".section">
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
@Component({
    components: {DSection}
})
export default class IndexPage extends Vue {

}
</script>

<style lang="scss" scoped>
.sections {
    .section:nth-child(even) {
        @apply bg-gray-200;
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
    @apply dark:bg-black dark:text-gray-100;
}

#__nuxt, #__layout {
    @apply min-h-full h-full
}
</style>
