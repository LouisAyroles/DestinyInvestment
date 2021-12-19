<template>
    <section class="section">
        <slot></slot>
    </section>
</template>

<script lang="ts">
import Vue from "vue";
import Component from "vue-class-component";

@Component
export default class DSection extends Vue{
}
</script>

<style lang="scss" scoped>
.section {
    @apply p-6 min-w-full min-h-full;
}
</style>
