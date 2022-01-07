<template>
    <div class="md:mx-4 md:p-4">
        <!-- Desktop stepper -->
        <div class="hidden md:flex items-center">
            <div class="flex items-center relative justify-around grow">
                <div v-for="(step,index) in steps" class="step" :class="{'line-colored': index < currentStep}">
                    <div class="flex items-center text-center rounded-full h-12 w-12 border-2 border-white"
                         :class="{'border-primary': index <= currentStep}">
                        <d-icon class="grow rounded-full" :icon="step.icon"
                                :class="{'text-primary': index <= currentStep}"></d-icon>
                    </div>
                    <div class="absolute top-0 -ml-10 text-center mt-16 w-32 text-xs font-medium uppercase">
                        {{ step.title }}
                    </div>
                </div>
            </div>
        </div>
        <!-- Mobile stepper -->
        <div class="flex flex-col md:hidden items-center justify-center">
            <div class="flex items-center text-center rounded-full m-4 h-12 w-12 border-2 border-white grow">
                <d-icon class="grow rounded-full text-white" :icon="steps[currentStep].icon"></d-icon>
            </div>
            <div class="text-white mb-4">
                Step {{ currentStep }} of {{ steps.length }}
            </div>
            <div class=" text-center w-32 text-xs text-white font-medium uppercase">
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
.step {
    position: relative;

    &:not(:last-child) {
        @apply grow
    }
}

@mixin line {
    content: "";
    min-width: calc(100% - 3rem);
    margin-left: 3rem;
    background: white;
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


.step {
    transform: translateY(-50%);

    &.line-colored:not(:last-child)::after {
        @include line-secondary;
    }

    &:not(.line-colored):not(:last-child)::after {
        @include line;
    }
}
</style>
