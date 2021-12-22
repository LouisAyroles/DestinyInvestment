<template>
    <div class="flex justify-center">
        <div class="overall">
            <div class="done" :style="{width: progression +  '%'}" ></div>
        </div>
    </div>
</template>

<script lang="ts">

import {Component, Prop, Vue} from 'vue-property-decorator'

@Component
export default class DProgress extends Vue {
    @Prop({type: Number})
    progression!: int | undefined
}
</script>

<style lang="scss" scoped>
    .done{
        @apply flex bg-primary
    }
    .overall{
        @apply overflow-hidden w-5/6  h-2 text-xs flex rounded bg-secondary
    }
</style>
