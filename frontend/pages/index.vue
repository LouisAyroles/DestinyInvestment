<template>
    <div class="sections h-full">
        <!--App bar-->
        <d-app-bar current-page="Home" class="fixed top-0 left-0 right-0"/>

        <!--Main section-->
        <d-section id="home" class="home-section">
            <div class="main-section-container">
                <div data-aos="fade-right" data-aos-duration="1000" class="main-left-panel">
                    <h1 class="main-title">Smart and Secure</h1>
                    <h1 class="main-title">way to invest <span class="inline sm:hidden"> in </span></h1>
                    <h1 class="main-title2 "><span class="hidden sm:inline"> in </span> <span class="slider"
                                                                                              ref="slider"> </span></h1>
                    <h3 class="main-subtitle">Reach now for the moon </h3>
                    <d-button class="mt-8 text-white" :gradient="false" icon="arrow-right-thick" link-to="/#raise">JOIN
                        US
                    </d-button>
                </div>

                <div class="main-right-panel">
                    <img data-aos="fade-left" data-aos-offset="-200" src="@/assets/infography/main.png" alt="destiny">
                </div>
            </div>
        </d-section>


        <!--Raise or invest section-->
        <d-section class="flex flex-col content-center p-6" id="raise">
            <div class="raise-or-invest-section-container">
                <div class="raise-or-invest-left-panel">
                    <h1 data-aos="fade-down" data-aos-duration="1000" class="title-1 sm:max-w-md fade-in">
                        Are you looking <b> to raise</b> capital for your startup ?
                    </h1>
                    <d-button data-aos="zoom-in-up" data-aos-duration="2000" class="raise-or-invest-button"
                              link-to="/raise" icon="arrow-right-thick">
                        APPLY TO RAISE
                    </d-button>
                </div>
                <div class="divider"></div>
                <div class="raise-or-invest-right-panel">
                    <h1 data-aos="fade-down" data-aos-duration="1000" class="title-1 sm:max-w-md">
                        Are you looking <b> to invest </b> in innovative projects?
                    </h1>
                    <d-button data-aos="zoom-in-up" data-aos-duration="2000" class="raise-or-invest-button"
                              link-to="/invest" icon="arrow-right-thick">
                        APPLY TO INVEST
                    </d-button>
                </div>
            </div>
        </d-section>


        <!--Launching soon section-->
        <d-section class="flex flex-col p-6">
            <h1 class="title-1 grow-0 m-6">Launching soon</h1>
            <h2 class="subtitle">Discover our uncut diamonds</h2>
            <div class="project-cards grow">
                <template v-for="project in projects">
                    <d-card :key="project.id" :project="project"/>
                </template>
            </div>
        </d-section>

        <!--Why choose us section-->
        <d-section class="flex flex-col content-around p-6">
            <h1 class="title-1">Why choose us ?</h1>
            <h2 class="subtitle">We’ve built a platform where startup meet capital</h2>

            <div class="cards">
                <template v-for="(info, index) in information">
                    <d-small-card :information="info" :key="index"
                                  background-color-class="bg-white dark:bg-gray-900"/>
                </template>
            </div>
        </d-section>

        <!--Timeline section-->
        <d-section class="flex flex-col content-center p-6">
            <h1 class="title-1 grow-0 uppercase">Roadmap</h1>
            <h2 class="subtitle">Our timelines details</h2>
            <d-road-map class="grow" :events="roadMapEvents"/>
        </d-section>


        <!--Mail section-->
        <d-section class="flex flex-col p-6" id="contact">
            <div class="mail-container">
                <h1 class="title-1">Are you on the list?</h1>
                <div class="button-mail-container">
                    <input class="input-mail" type="email" placeholder="Your Email"/>
                    <button class="button-mail uppercase">join</button>
                </div>
                <h1 class="contact-title uppercase">contact</h1>
                <div class="divider horizontal-only max-w-3xl"></div>
                <div class="contact-container">
                    <div class="contact-size">
                        <d-icon class="text-primary" :icon="'phone-outline'"/>
                        06 06 06 06 06
                    </div>
                    <div class="contact-size">
                        <d-icon class="text-primary" :icon="'email'"/>
                        contact@destinyinvestment.com
                    </div>
                </div>
            </div>
        </d-section>
    </div>
</template>

<script lang="ts">
import {Component} from 'vue-property-decorator'
import DSection from "~/components/DSection.vue";
import DSmallCard, {Information} from "~/components/DSmallCard.vue";
import DAppBar from "~/components/DAppBar.vue";
import DRoadMap, {RoadMapEvent} from "~/components/DRoadMap.vue";
import DCard, {Project} from "~/components/DCard.vue";
import DButton from "~/components/DButton.vue";
import DIcon from "~/components/DIcon.vue";
import aosMixin from '~/mixins/aos'
import {mixins} from "vue-class-component";

@Component({
    components: {DIcon, DCard, DButton, DRoadMap, DAppBar, DSmallCard, DSection}
})
export default class IndexPage extends mixins(aosMixin) {
    readonly information: Information[] = [{
        title: 'Secure user data and transaction',
        desc: 'We have created a system and an electronic protocol to ensure the integrity and security of transactions. The main objective is to protect the transactions of your investments.',
        icon: 'secure.png'
    }, {
        title: 'Most credibility cause exclusivity',
        desc: 'A chance to be part of an exclusive network, carefully selected according to the criteria and objectives of each member. The best thing to connect our members.',
        icon: 'wall.png'
    }, {
        title: 'Grown your network',
        desc: 'You are connected with hundreds of high-calibre investors and startups that you can discuss with in complete discretion on our platform.',
        icon: 'analysis.png'
    }, {
        title: 'Invest in innovative projects',
        desc: 'All the startups integrated in our platform required a detailed analysis and a deep research of the quality of the project in relation with your criteria.',
        icon: 'invest.png'
    }, {
        title: 'Physical meeting',
        desc: 'We regularly organise meetings to encourage our networks to meet. They will be held in your cities and countries.',
        icon: 'secure.png'
    }, {
        title: '24/7 support',
        desc: 'Wherever you are, we will reply to you by email or by calling the number in the contacts section. It will be a pleasure to talk to you in person.',
        icon: 'support.png'
    }]

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
        video: "small.mp4",
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
        video: "small.mp4",
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
        video: "small.mp4",
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
    }]

    word: number = 0;

    readonly investIn: string[] = [
        "Greentech", "Sportech", "Fintech", "Blockchain", "E-commerce", "Edtech", "Cyber-security", "Artifical Intelligence"
    ]

    mounted() {
        this.next()
    }

    next() {
        const slider = this.$refs['slider'] as HTMLElement
        slider.classList.add('hide');
        setInterval(() => this.changeText(slider), 2000)
        setInterval(() => slider.classList.remove('hide'), 2000)
    }

    changeText(slider: HTMLElement) {
        slider.textContent = this.investIn[this.word];
        this.word = (this.word + 1) % this.investIn.length;
    }
}

</script>

<style lang="scss" scoped>
.sections {
    section {
        @media screen and (min-width: 1440px) {
            scroll-snap-align: start; /* Section's scroll align    */
            scroll-margin: 5em; /* Scroll margin for app bar */
        }

        &:nth-child(odd) {
            @apply bg-gray-200;
            @apply dark:bg-[#05051b];
        }
    }
}

.subtitle {
    @apply dark:text-gray-400 text-gray-400 text-center mb-8 mt-2
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

    .raise-or-invest-left-panel {
        @apply grid justify-items-center mb-10 sm:mb-0
    }

    .raise-or-invest-right-panel {
        @apply grid justify-items-center mt-6 sm:mt-0
    }

    .raise-or-invest-button {
        @apply sm:mt-20 mt-8 dark:text-black text-white
    }
}

.divider {
    @apply w-3/5 h-[1px] flex;
    @apply bg-gradient-to-r from-transparent via-black dark:via-white to-transparent;

    &:not(.horizontal-only) {
        @apply sm:absolute sm:left-2/4 sm:h-3/5 sm:w-[1px];
        @apply sm:bg-gradient-to-t;
    }
}

.mail-container {
    @apply grow flex flex-col justify-around items-center;

    .contact-title {
        @apply text-center text-3xl;
    }

    .button-mail-container {
        @apply flex justify-center rounded-lg overflow-hidden w-fit
    }

    .input-mail {
        @apply pl-3 pr-3 sm:w-96 w-52 h-14 leading-none text-gray-800  border border-transparent focus:outline-none focus:border-gray-500
    }

    .button-mail {
        @apply sm:w-24 w-20 h-14 hover:bg-indigo-600 bg-indigo-700 text-base font-medium leading-none text-white
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
    @apply mt-20 flex flex-col content-center  p-6 xl:bg-[url('@/assets/infography/bg.png')];
    background-repeat: no-repeat;
}

.main-section-container {
    @apply grow h-full grid grid-cols-1 md:grid-cols-2 place-items-center px-10 md:px-0;
    .main-left-panel {
        @apply grid justify-items-center md:justify-items-start w-full xl:ml-40 2xl:ml-96;
    }

    .button {
        @apply rounded-full block w-fit;
        @apply px-5 py-2 font-medium uppercase;
        @apply transform transition duration-200 hover:scale-105;
    }

    .main-right-panel {
        @apply md:mb-0 mt-8 scale-125 sm:scale-100
    }

    .main-title {
        @apply text-xl md:text-3xl xl:text-6xl text-center md:text-left text-black dark:text-white
    }

    .main-title2 {
        @apply text-xl md:text-3xl xl:text-6xl text-center md:text-left text-black dark:text-white;
        white-space: nowrap;
    }

    .slider {
        @apply rounded-lg text-xl md:text-3xl xl:text-6xl text-center md:text-left text-[#f9bd49] font-bold w-[45rem];
        opacity: 1;
        transition: all 1s;

        &.hide {
            opacity: 0;
        }
    }

    .main-subtitle {
        @apply mt-8 text-center text-xs md:text-lg xl:text-2xl sm:text-left
    }
}


</style>

<style>
/* Style that should be applied to all the application */

* {
    scroll-behavior: smooth;
}

html, body {
    font-family: 'Poppins', sans-serif;
    /* Common theme */
    @apply p-0 min-w-full min-h-full h-full;
    /* Light theme */
    @apply bg-gray-100 text-gray-900;
    /* Dark theme */
    @apply dark:bg-sky-900 dark:text-gray-100;

    /* Allows to scroll section by section */
    scroll-snap-type: y mandatory;
    /*scroll-padding: 5em;*/
}

#__nuxt, #__layout {
    @apply min-h-full h-full
}
</style>
