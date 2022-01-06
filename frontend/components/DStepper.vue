<template>
    <div class="p-5">
        <div class="mx-4 p-4">
            <div class="flex items-center">
                <div class="flex items-center relative justify-around grow">
                    <div v-for="step in steps" class="step">
                        <div class="flex items-center text-center rounded-full h-12 w-12 border-2 border-white">
                            <d-icon class="grow rounded-full" :icon="step.icon"></d-icon>
                        </div>
                        <div class="absolute top-0 -ml-10 text-center mt-16 w-32 text-xs font-medium uppercase">
                            {{ step.title }}
                        </div>
                    </div>
                </div>
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
    height: 2px;
    position: absolute;
    top: 50%;
}

.step:not(:last-child)::after {
    transform: translateY(-50%);
    @include line;
}
</style>
