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

        <d-section class="flex flex-col">
            <h1 class="title-1 grow-0">Lunching soon</h1>
            <div class="project-cards grow">
                <template v-for="project in projects">
                    <d-card :key="project.id" :project="project"/>
                </template>
            </div>
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
                <d-small-card :content="'Secure user data and transaction'" class="max-w-xs" icon="currency-usd"
                              background-color-class="bg-gray-200 dark:bg-gray-900"/>
                <d-small-card :content="'Secure user data and transaction'" class="max-w-xs" icon="currency-usd"
                              background-color-class="bg-gray-200 dark:bg-gray-900"/>
                <d-small-card :content="'Secure user data and transaction'" class="max-w-xs" icon="currency-usd"
                              background-color-class="bg-gray-200 dark:bg-gray-900"/>
                <d-small-card :content="'Secure user data and transaction'" class="max-w-xs" icon="currency-usd"
                              background-color-class="bg-gray-200 dark:bg-gray-900"/>
                <d-small-card :content="'Secure user data and transaction'" class="max-w-xs" icon="currency-usd"
                              background-color-class="bg-gray-200 dark:bg-gray-900"/>
            </div>
        </d-section>

        <d-section class="flex flex-col content-center">
            <div class="raise-or-invest-section-container">
                <div class="raise-or-invest-left-panel">
                    <h1 class="title-1 sm:max-w-md">Are you looking to raise capital for your startup?</h1>
                    <DButton class="raise-or-invest-button" icon="arrow-right-thick"> APPLY TO RAISE</DButton>
                </div>
                <div class="divider"></div>
                <div class="raise-or-invest-right-panel">
                    <h1 class="title-1 sm:max-w-md">Are you looking to invest in innovative projects?</h1>
                    <DButton class="raise-or-invest-button" icon="arrow-right-thick"> APPLY TO INVEST</DButton>
                </div>
            </div>
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
import {Project} from "~/components/DCard.vue";

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
    readonly projects: Project[] = [{
        id: 1,
        image: "first.jpg",
        title: "Psst..!",
        short_desc: "Psst..! est une application indispensable pour vos futures découvertes",
        available_date: "20/01/2022",
        money_raised: 20321,
        goal_raise: 51100,
        information: [
            'Après de nombreux Congrès de pilotage en one-to-one',
            'Nous avons décider de créer un Diagramme des best practices conceptuel',
            'Afin de Concrétiser les tendances interoperables'
        ]
    }, {
        id: 2,
        image: "second.jpg",
        title: "Doggies in town",
        short_desc: "The only app you and your lovely dog will ever need.",
        available_date: "20/01/2022",
        money_raised: 7500,
        goal_raise: 12500,
        information: [
            'Notre but: Dématérialser les key-learnings pérennes',
            'Pourquoi faire ? Prospecter un chemin de conversion composite',
            "L'avenir appartient aux personnes qui savent Boostrapper une overview à iso-périmètre",
            "L'avenir appartient aux personnes qui savent Boostrapper une overview à iso-périmètre",
            "L'avenir appartient aux personnes qui savent Boostrapper une overview à iso-périmètre",
            "L'avenir appartient aux personnes qui savent Boostrapper une overview à iso-périmètre"
        ]
    }, {
        id: 3,
        image: "third.jpg",
        title: "Towni",
        short_desc: "Towni is THE applicaiton that you need to find you dream appartment !",
        available_date: "20/01/2022",
        money_raised: 20321,
        goal_raise: 51100,
        information: [
            'Nous cherchons à Dynamiser les feedbacks appétants',
            'Afin de Boostrapper un rebilling intuitif',
            'Notre job: Fullstack transformation recruiter'
        ]
    }
    ]
}
</script>

<style lang="scss" scoped>
.sections {
    .section:nth-child(odd) {
        @apply bg-gray-200;
        @apply dark:bg-gray-900;
    }
}

.project-cards {
    @apply flex flex-wrap gap-x-8 gap-y-16 justify-around items-center;
    & > * {
        @apply justify-self-center self-center;
    }
}

.raise-or-invest-section-container {
    @apply grow h-full grid grid-cols-1 gap-6 grid-rows-1 sm:grid-cols-2 place-items-center
}

.raise-or-invest-left-panel {
    @apply order-3 sm:order-1 grid justify-items-center
}

.raise-or-invest-right-panel {
    @apply order-1 sm:order-3 grid justify-items-center
}

.raise-or-invest-button {
    @apply sm:mt-20 mt-8
}

.divider {
    @apply order-2 sm:absolute flex border-opacity-80 border-white gap-8 sm:h-3/5 sm:w-0 w-3/5 h-0 border left-auto sm:left-2/4;
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
