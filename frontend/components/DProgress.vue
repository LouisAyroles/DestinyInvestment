<template>
    <div class="w-full">
        <div class="overall">
            <div class="done" :style="{width: `${progression}%`}"></div>
        </div>
    </div>
</template>

<script lang="ts">

import {Component, Prop, Vue} from 'vue-property-decorator'

@Component
export default class DProgress extends Vue {
    @Prop({type: Number, required: true})
    actual!: number

    @Prop({type: Number, required: true})
    goal!: number

    get progression(): number {
        return Math.round(this.actual / this.goal * 100);
    }
}
</script>

<style lang="scss" scoped>
.done {
    @apply flex bg-primary
}

.overall {
    @apply overflow-hidden h-2 text-xs flex rounded dark:bg-white
}
</style>
