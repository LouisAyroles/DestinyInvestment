<template>
    <h1 class="title"><slot></slot></h1>
</template>

<script lang="ts">
import Vue from 'vue'
import Component from 'vue-class-component'
import { Prop } from 'vue-property-decorator'

@Component
export default class DTitle extends Vue {
    @Prop({required: false, type: Boolean, default: false})
    uppercase!: boolean
}
</script>

<style lang="scss">
.title {
    @apply text-3xl text-black dark:text-white;
}
</style>
