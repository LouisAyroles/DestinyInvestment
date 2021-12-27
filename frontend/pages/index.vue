<template>
    <div class="sections h-full">
        <d-app-bar class="fixed top-0 left-0 right-0"/>
        <d-section id="home" class="home-section">
            <div class="main-section-container">
                <div class="main-left-panel">
                    <h1 class="main-title ">Smart and Secure way<br>to invest !</h1>
                    <h3 class="mt-8 text-center text-2xl sm:text-left">Choose between<br>Currency or Crypto</h3>
                    <d-button class="mt-8" icon="arrow-right-thick">JOIN US</d-button>
                </div>
                <img class="main-right-panel rounded-lg lg:scale-125 md:mb-0 mb-16" src="@/assets/infography/main.png"
                     alt="destiny">
            </div>
        </d-section>

        <d-section class="flex flex-col content-center">
            <div class="raise-or-invest-section-container">
                <div class="raise-or-invest-left-panel">
                    <h1 class="title-1 sm:max-w-md">Are you looking to raise capital for your startup?</h1>
                    <d-button class="raise-or-invest-button" icon="arrow-right-thick">APPLY TO RAISE</d-button>
                </div>
                <div class="dividers">
                    <div class="demi-divider"></div>
                    <div class="demi-divider"></div>
                </div>
                <div class="raise-or-invest-right-panel">
                    <h1 class="title-1 sm:max-w-md">Are you looking to invest in innovative projects?</h1>
                    <d-button class="raise-or-invest-button" icon="arrow-right-thick">APPLY TO INVEST</d-button>
                </div>
            </div>
        </d-section>


        <d-section class="flex flex-col">
            <h1 class="title-1 grow-0 m-6">Launching soon</h1>
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

        <d-section class="flex flex-col content-around">
            <h1 class="title-1">Why choose us ?</h1>
            <h2 class="subtitle">We’ve built a platform where startup meet capital</h2>

            <div class="cards">
                <template v-for="information in informations">
                    <d-small-card background-color-class="bg-gray-200 dark:bg-gray-900" :information="information"/>
                </template>
            </div>
        </d-section>

        <d-section class="flex flex-col" id="contact">
            <div class="mail-container">
                <h1 class="title-1">Are you on the list?</h1>
                <div class="button-mail-container">
                    <input class="input-mail" type="email" placeholder="Your Email"/>
                    <button class="button-mail uppercase">join</button>
                </div>
                <h1 class="contact-title uppercase">contact</h1>
                <div class="contact-container">
                    <div class="contact-size">
                        <d-icon :icon="'phone-outline'"/>
                        06 06 06 06 06
                    </div>
                    <div class="contact-size">
                        <d-icon :icon="'email'"/>
                        contact@destinyinvestment.com
                    </div>
                </div>

            </div>
        </d-section>
    </div>
</template>

<script lang="ts">
import {Component, Vue} from 'vue-property-decorator'
import DSection from "~/components/DSection.vue";
import DSmallCard, {Information} from "~/components/DSmallCard.vue";
import DAppBar from "~/components/DAppBar.vue";
import DRoadMap, {RoadMapEvent} from "~/components/DRoadMap.vue";
import DCard, {Project} from "~/components/DCard.vue";
import DButton from "~/components/DButton.vue";
import DIcon from "~/components/DIcon.vue";

@Component({
    components: {DIcon, DCard, DButton, DRoadMap, DAppBar, DSmallCard, DSection}
})
export default class IndexPage extends Vue {
    readonly informations: Information[] = [{
        title: 'Secure user data and transaction',
        desc: 'Lorem ipsum dolor sit amet, consect adipiscing elit, sed do eiusmod tempor incidiunt ut labore et dolore',
        icon: 'secure.png'
    }, {
        title: 'Most credibility cause exclusivity',
        desc: 'Lorem ipsum dolor sit amet, consect adipiscing elit, sed do eiusmod tempor incidiunt ut labore et dolore',
        icon: 'wall.png'
    }, {
        title: 'Grown your network',
        desc: 'Lorem ipsum dolor sit amet, consect adipiscing elit, sed do eiusmod tempor incidiunt ut labore et dolore',
        icon: 'analysis.png'
    }, {
        title: 'Invest in innovative projects',
        desc: 'Lorem ipsum dolor sit amet, consect adipiscing elit, sed do eiusmod tempor incidiunt ut labore et dolore',
        icon: 'invest.png'
    }, {
        title: 'Physical meeting',
        desc: 'Lorem ipsum dolor sit amet, consect adipiscing elit, sed do eiusmod tempor incidiunt ut labore et dolore',
        icon: 'secure.png'
    }, {
        title: '24/7 support',
        desc: 'Lorem ipsum dolor sit amet, consect adipiscing elit, sed do eiusmod tempor incidiunt ut labore et dolore',
        icon: 'secure.png'
    },]
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

.subtitle {
    @apply dark:text-gray-400 text-center mb-8 mt-2
}

.project-cards {
    @apply flex flex-wrap gap-x-8 gap-y-16 justify-around items-center;
    & > * {
        @apply justify-self-center self-center;
    }
}

.raise-or-invest-section-container {
    @apply grow flex flex-col justify-center items-center gap-16;
    @apply sm:grid sm:grid-cols-2;
}

.raise-or-invest-left-panel {
    @apply grid justify-items-center
}

.raise-or-invest-right-panel {
    @apply grid justify-items-center
}

.raise-or-invest-button {
    @apply sm:mt-20 mt-8
}

.dividers {
    @apply w-3/5 h-[1px] flex;
    @apply sm:absolute sm:left-2/4 sm:h-3/5 sm:w-[1px];
    @apply sm:flex-col;

    & > .demi-divider {
        @apply w-1/2 h-[1px] bg-gradient-to-r from-transparent to-white;
        @apply sm:w-[1px] sm:h-1/2 sm:bg-gradient-to-b;

        &:last-child {
            transform: rotateY(180deg);
            @apply sm:rotate-180;
        }
    }
}

.mail-container {
    @apply grow grid content-around;

    .contact-title {
        @apply text-center text-3xl sm:underline-offset-[4rem] underline-offset-[2rem] underline mb-8
    }

    .button-mail-container {
        @apply flex justify-center
    }

    .input-mail {
        @apply pl-3 pr-3 sm:w-96 w-52 h-14 rounded-lg rounded-r-none leading-none text-gray-800  border border-transparent focus:outline-none focus:border-gray-500
    }

    .button-mail {
        @apply sm:w-24 w-20 h-14 rounded-l-none hover:bg-indigo-600 bg-indigo-700 rounded text-base font-medium leading-none text-white
    }

    .contact-container {
        @apply grid grid-cols-1 sm:grid-cols-2 justify-items-center
    }

    .contact-size {
        @apply sm:text-xl lg:text-3xl
    }
}

.cards {
    @apply md:grid-rows-2 grow;
    @apply grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-8;

    & > * {
        @apply justify-self-center self-center;
    }
}

.home-section {
    @apply mt-20 flex flex-col content-center
}

.main-section-container {
    @apply grow h-full grid grid-cols-1 grid-rows-1 md:grid-cols-2 place-items-center p-10;
}

.main-left-panel {
    @apply order-2 md:order-1 grid justify-items-center md:justify-items-start
}

.main-right-panel {
    @apply order-1 md:order-2
}

.main-title {
    @apply text-6xl text-center md:text-left text-black dark:text-white
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
    @apply dark:bg-sky-900 dark:text-gray-100;
}

#__nuxt, #__layout {
    @apply min-h-full h-full
}
</style>
