<template>
    <div class="container">
        <div class="flip-card">
            <div class="inner">
                <div class="card-front front">
                    <img v-if="project.image"
                         class="w-full"
                         :src="require(`@/assets/projects/${project.image}`)"
                         :alt="project.title">
                    <div class="container-desc">
                        <div class="container-title">
                            <div>
                                <div class="title-date">
                                    <div class="title">{{ project.title }}</div>
                                    <div class="date">{{ project.available_date }}</div>
                                </div>
                                <p class="desc">{{ project.short_desc }}</p>
                            </div>
                        </div>
                        <div class="grow-0">
                            <d-progress class="progress" :actual="project.money_raised" :goal="project.goal_raise"/>
                            <div>
                                <span class="money-raise">{{ project.money_raised }} € &nbsp</span>
                                <span class="goal"> / {{ project.goal_raise }} €</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card-back back max-h-full">
                    <div class="grow-0">
                        <h1 class="title text-center">{{ project.title }}</h1>
                        <ul class="info-list">
                            <template v-for="(info, index) in project.information">
                                <li class="mt-4" :key="index">{{ info }}</li>
                            </template>
                        </ul>
                    </div>
                    <div class="container-button">
                        <d-button icon="chevron-right">See more</d-button>
                    </div>

                </div>
            </div>
        </div>
    </div>
</template>

<script lang="ts">

import {Component, Prop, Vue} from 'vue-property-decorator'

export interface Project {
    id: number,
    image: string,
    title: string,
    short_desc: string,
    available_date: string,
    goal_raise: number,
    money_raised: number
    information: string[]
}

@Component
export default class DCard extends Vue {
    @Prop({type: Object as () => Project, required: true})
    project!: Project
}
</script>

<style lang="scss" scoped>
.container {
    @apply flex justify-center rounded-lg w-fit;
}

.flip-card {
    @apply w-full min-h-max rounded-lg;
    @apply rounded-lg h-[24rem]  sm:h-[28rem] sm:w-[24rem] w-[18rem];
    perspective: 1000px;

    .inner {
        @apply w-full h-full relative transition-transform duration-700;
        transform-style: preserve-3d;

        .front,
        .back {
            @apply h-full w-full absolute bg-black rounded-lg justify-center;
            -webkit-backface-visibility: hidden;
            backface-visibility: hidden;
        }

        .back {
            @apply p-8 bg-black text-white;
            transform: rotateY(180deg);
        }
    }

    &:hover {
        .inner {
            transform: rotateY(180deg);
        }
    }
}

.card-front {
    @apply flex flex-col overflow-hidden
}

.card-back {
    @apply flex flex-col
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

.info-list {
    @apply overflow-hidden text-ellipsis list-disc list-inside;
    display: -webkit-box;
    -webkit-line-clamp: 10;
    line-clamp: 10;
    -webkit-box-orient: vertical;
}

.desc {
    @apply text-gray-700 text-base dark:text-white flex justify-around overflow-hidden text-ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 3;
    line-clamp: 3;
    -webkit-box-orient: vertical;
}

.container-desc {
    @apply flex flex-col justify-between grow p-3
}

.container-title {
    @apply flex grow justify-start
}

.container-button {
    @apply grow flex flex-col items-end justify-end
}

.money-raise {
    @apply text-primary
}

.goal {
    @apply mb-2
}

.progress {
    @apply mt-2 mb-2
}
</style>
