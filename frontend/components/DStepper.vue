<template>
    <div class="container">
        <!-- Desktop stepper -->
        <div class="desktop">
            <div class="desktop-container">
                <div v-for="(step,index) in steps" class="step-border" :class="{'line-colored': index < currentStep}">
                    <div class="step"
                         :class="{'border-primary': index <= currentStep}">
                        <d-icon class="icon" :icon="step.icon"
                                :class="{'text-primary': index <= currentStep}"></d-icon>
                    </div>
                    <div class="title">
                        {{ step.title }}
                    </div>
                </div>
            </div>
        </div>
        <!-- Mobile stepper -->
        <div class="mobile-container">
            <div class="mobile">
                <d-icon class="icon-mobile" :icon="steps[currentStep].icon"></d-icon>
            </div>
            <div class="">
                Step {{ currentStep }} of {{ steps.length }}
            </div>
            <div class="subtitle-mobile">
                {{ steps[currentStep].title }}
            </div>
        </div>
    </div>
</template>

<script lang="ts">

import {Component, Prop, Vue} from 'vue-property-decorator'

export interface Step {
    title: string,
    icon: string
}

@Component
export default class DStepper extends Vue {
    @Prop({type: Array as () => Step[], required: true})
    steps!: Step[]

    @Prop({required: true, type: Number})
    currentStep!: number
}
</script>

<style lang="scss" scoped>
.container {
    @apply md:mx-4 md:p-4
}

.desktop {
    @apply hidden md:flex items-center;
}

.desktop-container {
    @apply flex items-center relative justify-around grow;
}

.step-border {
    position: relative;

    &:not(:last-child) {
        @apply grow
    }
}

.step {
    @apply flex items-center text-center rounded-full h-12 w-12 border-2 dark:border-white border-slate-300 shadow-md;
    @apply transition duration-500;
    &:hover {
        @apply shadow-xl scale-110 cursor-pointer;
    }
}

.icon {
    @apply grow rounded-full
}

.title {
    @apply absolute top-0 -ml-10 text-center mt-16 w-32 text-xs font-medium uppercase
}

.mobile-container {
    @apply flex flex-col md:hidden items-center justify-center
}

.mobile {
    @apply flex items-center text-center rounded-full m-4 h-12 w-12 border-2 border-white grow
}

.icon-mobile {
    @apply grow rounded-full text-white
}

.title-mobile {
    @apply text-white mb-4
}

.subtitle-mobile {
    @apply text-center w-32 text-xs text-white font-medium uppercase
}

@mixin line {
    @apply dark:bg-white bg-slate-300;
    content: "";
    min-width: calc(100% - 3rem);
    margin-left: 3rem;
    height: 3px;
    position: absolute;
    top: 50%;
}

@mixin line-secondary {
    content: "";
    min-width: calc(100% - 3rem);
    margin-left: 3rem;
    @apply bg-primary;
    height: 3px;
    position: absolute;
    top: 50%;
}


.step-border {
    transform: translateY(-50%);

    &.line-colored:not(:last-child)::after {
        @include line-secondary;
    }

    &:not(.line-colored):not(:last-child)::after {
        @include line;
    }
}
</style>
