<template>
    <div class="sections h-full">
        <d-app-bar class="fixed top-0 left-0 right-0"/>
        <d-section id="home" class="mt-20 .section">
            <h1 class="title-1">Title 1</h1>
            <h2 class="title-2">Title 2</h2>
            <h3 class="title-3">Title 3</h3>
            <h4 class="title-4">Title 4</h4>
            <h5 class="title-5">Title 5</h5>
            <p>Normal text</p>
        </d-section>

        <d-section class=".section">
            <h1 class="title-1">Projects preview</h1>
        </d-section>

        <d-section class=".section">
            <h1 class="title-1">Roadmap</h1>
            <d-road-map></d-road-map>
        </d-section>

        <d-section class=".section">
            <h1 class="title-1">Why choose us</h1>

            <div class="cards">
                <d-small-card :content="'Secure user data and transaction'" class="max-w-xs" icon="currency-usd" background-color-class="bg-gray-200 dark:bg-gray-900"/>
                <d-small-card :content="'Secure user data and transaction'" class="max-w-xs" icon="currency-usd" background-color-class="bg-gray-200 dark:bg-gray-900"/>
                <d-small-card :content="'Secure user data and transaction'" class="max-w-xs" icon="currency-usd" background-color-class="bg-gray-200 dark:bg-gray-900"/>
                <d-small-card :content="'Secure user data and transaction'" class="max-w-xs" icon="currency-usd" background-color-class="bg-gray-200 dark:bg-gray-900"/>
                <d-small-card :content="'Secure user data and transaction'" class="max-w-xs" icon="currency-usd" background-color-class="bg-gray-200 dark:bg-gray-900"/>
                <d-small-card :content="'Secure user data and transaction'" class="max-w-xs" icon="currency-usd" background-color-class="bg-gray-200 dark:bg-gray-900"/>
                <d-small-card :content="'Secure user data and transaction'" class="max-w-xs" icon="currency-usd" background-color-class="bg-gray-200 dark:bg-gray-900"/>
                <d-small-card :content="'Secure user data and transaction'" class="max-w-xs" icon="currency-usd" background-color-class="bg-gray-200 dark:bg-gray-900"/>
                <d-small-card :content="'Secure user data and transaction'" class="max-w-xs" icon="currency-usd" background-color-class="bg-gray-200 dark:bg-gray-900"/>
            </div>
        </d-section>

        <d-section class=".section">
            <h1 class="title-1">Raise or invest</h1>
        </d-section>

        <d-section id="contact" class=".section">
            <h1 class="title-1">Mail</h1>
        </d-section>
    </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import DSection from "~/components/DSection.vue";
import DSmallCard from "~/components/DSmallCard.vue";
import DAppBar from "~/components/DAppBar.vue";

@Component({
    components: {DAppBar, DSmallCard, DSection}
})
export default class IndexPage extends Vue {

}
</script>

<style lang="scss" scoped>
.sections {
    .section:nth-child(odd) {
        @apply bg-gray-200;
        @apply dark:bg-gray-900;
    }
}

.cards {
    @apply md:grid-cols-3 md:grid-rows-3;
    @apply grid grid-cols-1 md:grid-cols-3 gap-3 h-full;

    & > * {
        @apply justify-self-center self-center;
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
