<template>
    <div class="main-container">
        <ul>
            <template v-for="(event, index) in eventsWithPosition">
                <li :key="index" :class="{'left': event.left}">
                    <div class="card">
                        <div data-aos="zoom-in-up" data-aos-duration="1000" :data-aos-delay="200*index"
                             data-aos-offset="200" :class="['background', {left: event.left}]">
                            <h3 class="title">{{ event.date }}</h3>
                            <p class="description">{{ event.description }}</p>
                        </div>
                    </div>
                </li>
            </template>
        </ul>
    </div>

</template>

<script lang="ts">

import {Component, Prop, Vue} from 'vue-property-decorator'

export interface RoadMapEvent {
    date: string,
    description: string
}

@Component
export default class DRoadMap extends Vue {
    @Prop({required: true, type: Array})
    events!: RoadMapEvent[]

    get eventsWithPosition() {
        return this.events.map((event, index) => {
            return {left: index % 2 == 0, ...event}
        })
    }
}
</script>

<style lang="scss" scoped>
* {
    box-sizing: border-box !important;
}

@mixin gradient {
    @apply bg-gradient-to-tr from-primary to-secondary;
    background-attachment: fixed;
    background-size: cover;
    background-position: center;
}

@mixin gradient-inverted {
    @include gradient;
    @apply sm:bg-gradient-to-tl;
}

.main-container {
    @apply w-full h-full p-10 grid content-center
}

.sub-container {
    @apply relative overflow-hidden p-10 w-full h-full;
}

.background {
    @apply bg-gray-900 rounded-lg px-6 py-4;
    @include gradient;

    &:not(.left) {
        @include gradient-inverted;
    }
}

ul {
    @apply m-0 p-0 w-full flex flex-col items-center;

    @mixin dot {
        content: '';
        width: 18px;
        height: 18px;
        background-color: white;
        position: absolute;
        top: 50%;
        transform: translateY(-50%);
        border-radius: 9999px;
    }

    li {
        @apply relative w-full sm:w-[calc(50%-32px)] sm:max-w-[400px] pb-4;

        .title {
            @apply mb-3 font-bold text-white text-xl
        }

        .description {
            @apply text-sm font-medium leading-snug tracking-wide text-white text-opacity-100
        }
    }

    li:not(.left) {
        @apply sm:translate-x-[calc(50%-1px)];
        border-left: 1px solid white;
        padding-left: 32px;

        &:before {
            @include dot;
            @apply left-[-9px];
        }
    }

    li.left {
        @apply sm:-translate-x-1/2;
        @apply border-white border-solid border-l-[1px] pl-[32px];
        @apply sm:border-l-0 sm:border-r-[1px] sm:pl-[0px] sm:pl-[32px] sm:pr-[32px];

        &:after {
            @include dot;
            @apply left-[-9px] sm:left-auto sm:right-[-9px];
        }

        .title {
            @apply sm:text-right
        }

        .description {
            @apply sm:text-right
        }
    }
}
</style>
