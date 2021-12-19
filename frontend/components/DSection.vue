<template>
    <div class="section">
        <slot></slot>
    </div>
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
    @apply p-6 min-w-full min-h-full bg-green-900
}
</style>
