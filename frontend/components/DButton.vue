<template>
    <component :is="componentType" :href="linkTo" :class="[{'with-icon': hasIcon, 'gradient': gradient}, 'button']">
        <slot></slot>
        <d-icon v-if="icon !== undefined" :icon="icon"></d-icon>
    </component>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator'
import DIcon from "~/components/DIcon.vue";

@Component({
    components: {DIcon}
})
export default class DButton extends Vue {
    @Prop({required: false, type: String})
    linkTo!: string | undefined

    @Prop({required: false, type: String})
    icon!: string | undefined

    @Prop({required: false, type: Boolean, default: true})
    gradient!: boolean

    get componentType(): string {
        return this.linkTo
            ? 'a'
            : 'button'
    }

    get hasIcon(): boolean {
        return !!this.$slots.icon
    }
}
</script>

<style lang="scss" scoped>
.button {
    @apply rounded-full block w-fit;
    @apply px-5 py-2 font-medium uppercase;
    @apply transform transition duration-200 hover:scale-105;
}

.gradient {
    @apply bg-gradient-to-r from-primary to-secondary;
}
</style>
