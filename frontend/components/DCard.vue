<template>
    <div class="card">
        <img v-if="image"
            class="w-full"
            :src="require(`@/assets/projects/${image}`)"
            :alt="title">
        <div class="flex justify-around">
            <div class="w-5/6">
                <div class="title-date">
                    <div class="title">{{title}}</div>
                    <div class="date">{{available_date}}</div>
                </div>
                <p class="desc">{{short_desc}}</p>
            </div>
        </div>
        <d-progress class="progress" :progression="money_raise/goal_raise*100"></d-progress>
        <div v-if="money_raise && goal_raise" class="flex justify-around">
            <div class="flex w-5/6">
                <div class="money-raise">{{money_raise}} € &nbsp</div>
                <div class="goal"> / {{goal_raise}} €</div>
            </div>
        </div>
    </div>
</template>

<script lang="ts">

import {Component, Prop, Vue} from 'vue-property-decorator'

@Component
export default class DCard extends Vue {
    @Prop({type: String})
    image!: string | undefined

    @Prop({type: String})
    title!: string | undefined

    @Prop({type: String})
    short_desc!: string | undefined

    @Prop({type: String})
    available_date!: string | undefined

    @Prop({type: Number})
    goal_raise!: number | undefined

    @Prop({type: Number})
    money_raise!: number | undefined


}
</script>

<style lang="scss" scoped>
    .card{
        @apply max-w-md rounded overflow-hidden shadow-lg
    }
    .title-date{
        @apply flex justify-between mt-2
    }
    .title{
        @apply font-bold text-xl mb-2
    }
    .date{
        @apply mb-2
    }
    .desc{
        @apply text-gray-700 text-base flex justify-around
    }
    .money-raise{
        @apply mb-2 text-primary
    }
    .goal{
        @apply mb-2
    }
    .progress{
        @apply mt-2 mb-2
    }
</style>
