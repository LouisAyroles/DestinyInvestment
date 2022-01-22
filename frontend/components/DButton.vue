<template>
    <component :is="componentType" :href="linkTo" :class="[{'with-icon': hasIcon, 'gradient': gradient}, 'button']">
        <slot></slot>
        <d-icon v-if="icon !== undefined" :icon="icon"></d-icon>
    </component>
</template>

<script lang="ts">
import {Component, Prop, Vue} from 'vue-property-decorator'
import DIcon from "~/components/DIcon.vue";

@Component({
    components: {DIcon}
})
export default class DButton extends Vue {
    /**
     * Link to which this button should redirect.
     *
     * If set, the button is rendered by an <a> tag.
     *
     * Style is kept no matter which tag is used to render the button.
     */
    @Prop({required: false, type: String})
    linkTo!: string | undefined

    /**
     * Icon to be rendered on the right of the button.
     *
     * Should be taken from this list : {@link https://materialdesignicons.com/}.
     *
     * Note that you just need to enter the name of the icon. You shouldn't include the `mdi` prefix.
     *
     * For example, the `arrow-right-thick` should be passed as-is, not 'mdi-arrow-right-thick'.
     */
    @Prop({required: false, type: String})
    icon!: string | undefined


    /**
     * Should the background be rendered as a gradient.
     * @default true
     */
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

:not(.gradient) {
    .mdi {
        @apply bg-transparent
    }
    @apply bg-primary-dark;
}
</style>
