<template>
    <section class="section">
        <slot></slot>
    </section>
</template>

<script lang="ts">
import {Component, Vue} from 'vue-property-decorator'

@Component
export default class DSection extends Vue {
}
</script>

<style lang="scss" scoped>
.section {
    @apply min-w-full;
    @apply bg-white dark:bg-[#030a2d];

    min-height: calc(100vh - 5rem)
}
</style>
