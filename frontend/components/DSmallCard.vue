<template>
    <div class="gradient-border">
        <div class="card" :class="backgroundColorClass">
            <d-icon v-if="icon" :icon="icon" class="text-5xl"/>
            <p v-if="content" class="title-2 text-center">
                {{ content }}
            </p>
        </div>
    </div>
</template>

<script lang="ts">
import {Component, Prop, Vue} from "vue-property-decorator";

@Component
export default class DSmallCard extends Vue {
    @Prop({required: true, type: String})
    backgroundColorClass!: string

    @Prop({type: String})
    icon!: string | undefined

    @Prop({type: String})
    content!: string | undefined
}
</script>

<style lang="scss" scoped>
.gradient-border {
    @apply bg-gradient-to-tr from-primary to-secondary;
    @apply w-fit rounded-md;
    @apply p-0.5;
}

.card {
    @apply w-fit rounded h-full;
    @apply p-5;
    @apply flex items-center gap-1.5;
}
</style>
