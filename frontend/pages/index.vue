<template>
    <div class="sections h-full">
        <!--App bar-->
        <d-app-bar current-page="Home" class="fixed top-0 left-0 right-0"/>

        <!--Main section-->
        <d-section id="home" class="home-section">
            <div class="main-section-container">
                <div data-aos="fade-right" data-aos-duration="1000" class="main-left-panel">
                    <h1 class="main-title">Smart and Secure</h1>
                    <h1 class="main-title">way to invest in <span class="inline sm:hidden"> in </span></h1>
                    <h1 class="main-title2 ">
                        <span class="slider" ref="slider">
                            <span class="slider-size-keeper" ref="slider-size-keeper"></span>
                            <span v-for="keyword in investIn" :key="keyword" class="keyword first-hide">{{
                                    keyword
                                }}</span>
                        </span>
                    </h1>
                    <h3 class="main-subtitle">Reach now for the moon </h3>
                    <d-button class="mt-8 text-white" :gradient="false"
                              icon="arrow-right-thick" link-to="/#raise">JOIN
                        US
                    </d-button>
                </div>

                <div class="main-right-panel">
                    <img data-aos="fade-left" data-aos-offset="-200" src="@/assets/infography/main.svg" alt="destiny">
                </div>
            </div>
        </d-section>


        <!--Raise or invest section-->
        <d-section class="flex flex-col content-center p-6" id="raise">
            <div class="raise-or-invest-section-container">
                <div class="raise-or-invest-left-panel">
                    <h1 data-aos="fade-down" data-aos-duration="1000" class="title-1 sm:max-w-md fade-in">
                        Are you looking <span class="text-primary"> <b> to raise</b></span> capital for your startup ?
                    </h1>
                    <d-button data-aos="zoom-in-up" data-aos-duration="2000" class="raise-or-invest-button"
                              link-to="/raise"
                              :is-nuxt-link="true"
                              icon="arrow-right-thick">
                        APPLY TO RAISE
                    </d-button>
                </div>
                <div class="divider"></div>
                <div class="raise-or-invest-right-panel">
                    <h1 data-aos="fade-down" data-aos-duration="1000" class="title-1 sm:max-w-md">
                        Are you looking <span class="text-primary"> <b> to invest</b></span> in innovative projects?
                    </h1>
                    <d-button data-aos="zoom-in-up" data-aos-duration="2000" data-aos-offset="-200"
                              class="raise-or-invest-button"
                              link-to="/invest"
                              :is-nuxt-link="true"
                              icon="arrow-right-thick">
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
                        contact@destinyconnexion.com
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
        date: "September 03, 2022",
        description: "You will be able to invest"
    },
        {
            date: "November 01, 2022",
            description: "First event in Barcelona"
        }]

    readonly projects: Project[] = [{
        id: 1,
        video: "psst.mp4",
        title: "Psst..!",
        logo: "psst.png",
        short_desc: "Increase and digitalize your business by accessing a large scale market through a unique network. Develop a relevant and impactful marketing strategy us.",
        available_date: "20/01/2022",
        money_raised: 20321,
        goal_raise: 51100
    }, {
        id: 2,
        video: "plug-heur.mp4",
        title: "PLUG'HEUR",
        logo: "plug-heur.png",
        short_desc: "Self-service external battery stations to recharge your customers' phones. Improve your customer reception to generate a positive and memorable experience.",
        available_date: "20/01/2022",
        money_raised: 7500,
        goal_raise: 12500
    }, {
        id: 3,
        video: "video3.mp4",
        title: "Towni",
        logo: "town.png",
        short_desc: "Towni is THE applicaiton that you need to find you dream appartment !",
        available_date: "20/01/2022",
        money_raised: 20321,
        goal_raise: 51100
    }]

    word: number = 0;
    firstHide = true

    readonly investIn: string[] = [
        "Greentech", "Sportech", "Fintech", "Blockchain", "E-commerce", "Edtech", "Cyber-security", "Artificial Intelligence"
    ]

    mounted() {
        document.documentElement.classList.remove('dark')
        const slider = this.$refs['slider'] as HTMLElement
        const keywords = Array.from(slider.querySelectorAll(".keyword")) as HTMLElement[]
        const sizeKeeper = this.$refs['slider-size-keeper'] as HTMLElement
        sizeKeeper.innerText = this.investIn.reduce((prev, curr) => prev.length > curr.length ? prev : curr, this.investIn[0] ?? "")

        keywords[0]?.classList.add("visible")
        this.next()
    }

    next() {
        const slider = this.$refs['slider'] as HTMLElement
        setInterval(() => this.changeText(Array.from(slider.querySelectorAll(".keyword")) as HTMLElement[]), 1500)
    }

    changeText(keywords: HTMLElement[]) {

        keywords[this.word].classList.remove('visible')
        keywords[this.word].classList.add('hide')

        this.word = (this.word + 1) % this.investIn.length

        keywords[this.word].classList.remove('hide')
        keywords[this.word].classList.add('visible')
        if (this.firstHide) {
            keywords[this.word].classList.remove('first-hide')
        }
        if (this.word === 0 && this.firstHide) {
            this.firstHide = false;
        }
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
    @apply mt-20 flex flex-col 2xl:bg-[url('@/assets/infography/bg.svg')] md:bg-[url('@/assets/infography/bg-md.svg')];
    background-repeat: no-repeat;
}

.main-section-container {
    @apply relative h-full grow grid grid-rows-2 lg:grid-rows-1 md:grid-cols-2 place-items-center md:px-0 overflow-x-hidden;

    .main-left-panel {
        @apply flex flex-col grow items-center md:ml-20 md:mt-20 lg:ml-0 lg:mt-0 md:items-start lg:h-full lg:justify-center;
        @apply z-30;
    }

    .main-right-panel {
        @apply absolute bottom-0 right-0 max-w-[100%] sm:max-w-[80%] md:max-w-[60%] lg:max-w-[50%] overflow-x-hidden;
    }

    .button {
        @apply rounded-full block w-fit;
        @apply px-5 py-2 font-medium uppercase;
        @apply transform transition duration-200 hover:scale-105;
    }

    .main-title {
        @apply text-3xl md:text-5xl xl:text-6xl text-center md:text-left text-black dark:text-white
    }

    .main-title2 {
        @apply text-xl md:text-3xl xl:text-6xl text-center md:text-left text-black dark:text-white;
        white-space: nowrap;
    }

    #raise {
        padding-top: 5rem;
        margin-top: -5rem;
    }

    .slider {
        @apply relative rounded-lg text-3xl md:text-5xl xl:text-6xl text-center md:text-left text-[#f9bd49] font-bold w-[45rem];

        .slider-size-keeper {
            opacity: 0 !important;
        }

        .keyword {
            @apply absolute top-2/4 left-0;
            @media (max-width: 767px) {
                transform: translate(-50%, -50%);
                left: 50%;
            }
            transform: translateY(-50%);
            opacity: 1;
            transition: all 1s;
        }


        @keyframes hide-keys {
            0% {
                transform: translateY(-50%);
                opacity: 1
            }
            50% {
                opacity: 1
            }
            100% {
                transform: translateY(40%);
                opacity: 0
            }
        }

        @keyframes hide-keys-centered {
            0% {
                transform: translate(-50%, -50%);
                opacity: 1
            }
            50% {
                opacity: 1
            }
            100% {
                transform: translate(-50%, 40%);
                opacity: 0
            }
        }

        .first-hide {
            opacity: 0;
        }

        .hide {
            opacity: 0;
            @media (max-width: 767px) {
                animation: 1s hide-keys-centered;
            }
            animation: 1s hide-keys;
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
    @apply p-0 min-w-full min-h-full h-full scroll-pt-20 xl:scroll-pt-0;
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
