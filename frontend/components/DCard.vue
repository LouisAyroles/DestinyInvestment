<template>
    <div v-observe-visibility="playVideoOnMobile" @mouseover="playVideo" @mouseleave="pauseVideo" @blur="pauseVideo"
         class="relative card-front front rounded-lg">
        <video ref="video" loop muted>
            <source
                :src="require(`@/assets/projects/${project.video}`)"
                type="video/mp4"/>
        </video>
        <div class="logo-container">
            <img class="logo" :alt="project.title" :src="require(`@/assets/projects/${project.logo}`)"/>
        </div>
        <div class=" container-desc">
            <div class="container-title">
                <div>
                    <div class="title-date">
                        <div class="title">{{ project.title }}</div>
                    </div>
                    <p class="desc">{{ project.short_desc }}</p>
                </div>
            </div>
            <div class="grow-0">
                <div>
                    <span> Start in 30 days </span>
                </div>
                <d-progress class="progress" :actual="project.money_raised" :goal="project.goal_raise"/>
                <div class="container-bottom">
                    <div class="container-goal">
                        <span class="money-raise">Target </span>
                        <span class="goal">{{ project.goal_raise }} €</span>
                    </div>
                    <div class="flex flex-col">
                        <span class="money-raise">Investors </span>
                        <span class="money-raise">waiting</span>
                        <span>12 </span>
                    </div>
                    <div class="flex items-end">
                        <d-button link-to="/invest" icon="account-star"></d-button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script lang="ts">

import {Component, Prop, Vue} from 'vue-property-decorator'
import DButton from "~/components/DButton.vue";
import DProgress from "~/components/DProgress.vue";


export interface Project {
    id: number,
    video: string,
    title: string,
    logo: string,
    short_desc: string,
    available_date: string,
    goal_raise: number,
    money_raised: number
    information: string[]
}

@Component({
    components: {DProgress, DButton}
})
export default class DCard extends Vue {
    @Prop({type: Object as () => Project, required: true})
    project!: Project

    playVideoOnMobile(isVisible: boolean) {
        if (screen.width < 1024) {
            if (isVisible) {
                this.playVideo()
            } else {
                this.pauseVideo()
            }
        }
    }

    playVideo() {
        const video = this.$refs['video'] as HTMLVideoElement
        video.play()
    }

    pauseVideo() {
        const video = this.$refs['video'] as HTMLVideoElement
        video.pause()
    }


}
</script>

<style lang="scss" scoped>

.card-front {
    @apply flex flex-col overflow-hidden h-[28rem] w-[17rem] sm:h-[31rem] sm:w-[24rem] dark:shadow-none shadow-xl shadow-primary transform transition duration-500 dark:bg-[#05051b];
    &:hover {
        @apply dark:md:shadow-none md:shadow-2xl md:shadow-primary cursor-pointer  md:scale-110
    }
}

.logo-container {
    @apply flex justify-center absolute rounded-full h-12 w-12 right-28 top-32 sm:right-44 sm:top-48 bg-slate-100 shadow-lg shadow-slate-500
}

.logo {
    @apply h-8 w-8 place-self-center;
}

.title-date {
    @apply flex justify-between
}

.title {
    @apply font-bold dark:text-primary text-xl
}

.date {
    @apply mb-2
}

.desc {
    @apply text-gray-400 text-base dark:text-white flex justify-around overflow-hidden text-ellipsis line-clamp-3;
    display: -webkit-box;
    -webkit-box-orient: vertical;
}

.container-desc {
    @apply flex flex-col justify-between grow p-3 pt-8
}

.container-title {
    @apply flex grow justify-start
}

.money-raise {
    @apply text-primary
}

.goal {
    @apply mb-2
}

.container-bottom {
    @apply flex flex-row justify-between
}

.container-goal {
    @apply flex flex-col justify-between
}

.progress {
    @apply mt-2 mb-8
}
</style>
