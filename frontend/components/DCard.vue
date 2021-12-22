<template>
    <div class="max-w-md rounded overflow-hidden shadow-lg">
        <img v-if="image" class="w-full" :src="require(`@/assets/projects/${image}`)" :alt="title">
        <div class="flex justify-around">
            <div class="w-5/6">
                <div class="flex justify-between mt-2">
                    <div class="font-bold text-xl mb-2">{{title}}</div>
                    <div class="text-md mb-2">{{available_date}}</div>
                </div>

                <p class="text-gray-700 text-base flex justify-around">
                    {{short_desc}}
                </p>
            </div>
        </div>
        <d-progress class="mt-2 mb-2" :progression="money_raise/goal_raise*100"></d-progress>
        <div v-if="money_raise && goal_raise" class="flex justify-around">
            <div class="flex w-5/6">
                <div class="text-md mb-2 text-primary">{{money_raise}} € &nbsp</div>
                <div class="text-md mb-2"> / {{goal_raise}} €</div>
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

    @Prop({type: String})
    goal_raise!: string | undefined

    @Prop({type: String})
    money_raise!: string | undefined


}
</script>

<style lang="scss" scoped>


</style>
