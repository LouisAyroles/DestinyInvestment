<template>
    <div class="sections h-full">
        <d-app-bar class="fixed top-0 left-0 right-0"/>
        <d-section id="home" class="home-section">
            <div class="main-section-container">
                <div class="main-left-panel">
                    <h1 class="main-title title-1 ">Smart and Secure way<br> to invest!</h1>
                    <h3 class="mt-8">Choose between <br>Currency or Crypto</h3>
                    <DButton class="mt-8" icon="arrow-right-thick"> JOIN US</DButton>
                </div>
                <img class="main-right-panel" src="@/assets/infography/main.jpg" alt="destiny">
            </div>
        </d-section>

        <d-section>
            <h1 class="title-1">Projects preview</h1>
        </d-section>

        <d-section class="flex flex-col content-center">
            <h1 class="title-1 grow-0">Roadmap</h1>
            <d-road-map class="grow" :events="roadMapEvents"/>
        </d-section>

        <d-section class=".section">
            <h1 class="title-1">Why choose us</h1>

            <div class="cards">
                <d-small-card :content="'Secure user data and transaction'" class="max-w-xs" icon="currency-usd"
                              background-color-class="bg-gray-200 dark:bg-gray-900"/>
                <d-small-card :content="'Secure user data and transaction'" class="max-w-xs" icon="currency-usd"
                              background-color-class="bg-gray-200 dark:bg-gray-900"/>
                <d-small-card :content="'Secure user data and transaction'" class="max-w-xs" icon="currency-usd"
                              background-color-class="bg-gray-200 dark:bg-gray-900"/>
                <d-small-card :content="'Secure user data and transaction'" class="max-w-xs" icon="currency-usd"
                              background-color-class="bg-gray-200 dark:bg-gray-900"/>
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
import {Component, Vue} from 'vue-property-decorator'
import DSection from "~/components/DSection.vue";
import DSmallCard from "~/components/DSmallCard.vue";
import DAppBar from "~/components/DAppBar.vue";
import DRoadMap, {RoadMapEvent} from "~/components/DRoadMap.vue";

@Component({
    components: {DRoadMap, DAppBar, DSmallCard, DSection}
})
export default class IndexPage extends Vue {
    readonly roadMapEvents: RoadMapEvent[] = [{
        date: "February 2, 2022",
        description: "Project is raising stars"
    }, {
        date: "May 01, 2022",
        description: "Projects available"
    }, {
        date: "November 01, 2021",
        description: "You will be able to invest"
    }, {
        date: "September 03, 2021",
        description: "First event in Barcelona"
    }]
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

.home-section {
    @apply mt-20 flex flex-col content-center
}

.main-section-container {
    @apply grow h-full grid grid-cols-1 grid-rows-1 sm:grid-cols-2 place-items-center
}

.main-left-panel {
    @apply order-2 sm:order-1 grid justify-items-center sm:justify-items-start
}

.main-right-panel {
    @apply order-1 sm:order-2
}

.main-title {
    @apply text-center sm:text-left text-black dark:text-white
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
