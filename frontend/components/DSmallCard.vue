<template>
    <div data-aos="flip-right" data-aos-duration="1000" class="gradient-border">
        <div class="card" :class="backgroundColorClass">
            <img class="icon" :src="require(`@/assets/infography/${information.icon}`)" alt="">
            <p v-if="information.title" class="title">
                {{ information.title }}
            </p>
            <p v-if="information.desc" class="desc">
                {{ information.desc }}
            </p>
            <div>
                <span class="yellow">Read more </span>
                <a href class="yellow mdi mdi-arrow-right"></a>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
import {Component, Prop, Vue} from "vue-property-decorator";

export interface Information {
    title: string,
    desc: string,
    icon: string
}

@Component
export default class DSmallCard extends Vue {
    @Prop({required: true, type: String})
    backgroundColorClass!: string

    @Prop({type: Object as () => Information, required: true})
    information!: Information
}
</script>

<style lang="scss" scoped>
.gradient-border {
    @apply bg-gradient-to-tr from-primary to-secondary;
    @apply w-fit rounded-md;
    @apply p-0.5;
}

.card {
    @apply w-72 h-80 sm:w-64 md:w-80 lg:w-72 xl:w-[22rem];
    @apply p-5 rounded;
    @apply flex flex-col items-center gap-1.5;
}

.title {
    @apply text-2xl grow text-center
}

.desc {
    @apply dark:text-gray-400 text-gray-400 grow text-center text-sm xl:text-base text-justify
}

.icon {
    @apply h-16 w-16
}

.yellow {
    @apply text-yellow-400
}
</style>
