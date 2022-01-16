<template>
    <div ref="cards" class="flex items-center">
        <d-button @click.native="previousStep" class="h-12 text-white" icon="arrow-left"></d-button>
        <slot></slot>
        <d-button @click.native="nextStep" class="h-12 text-white" icon="arrow-right"></d-button>
    </div>
</template>

<script lang="ts">
import {Component, Vue} from 'vue-property-decorator'

@Component
export default class DSlider extends Vue {
    findCards(toHide: number, toShow: number): (HTMLElement | null)[] {
        const cards = this.$refs["cards"] as HTMLElement
        const cardToHide = cards.children.item(toHide) as HTMLElement | null
        const cardToShow = cards.children.item(toShow) as HTMLElement | null

        return [cardToHide, cardToShow]
    }

    nextStep() {
        if (this.$parent.$parent.currentStep !== this.$parent.$parent.steps.length - 1) {
            switch (this.$parent.$parent.currentStep) {
                case 0: {
                    this.$parent.$parent.$refs['first-card'].classList.add('hidden')
                    this.$parent.$parent.$refs['second-card'].classList.remove('hidden')
                    this.$parent.$parent.$refs['second-card'].classList.add('relative')
                    break
                }
                case 1: {
                    this.$parent.$parent.$refs['second-card'].classList.add('hidden')
                    this.$parent.$parent.$refs['third-card'].classList.remove('hidden')
                    this.$parent.$parent.$refs['third-card'].classList.add('relative')
                    break
                }
                case 2: {
                    this.$parent.$parent.$refs['third-card'].classList.add('hidden')
                    this.$parent.$parent.$refs['fourth-card'].classList.remove('hidden')
                    this.$parent.$parent.$refs['fourth-card'].classList.add('relative')
                    break
                }
                case 3: {
                    this.$parent.$parent.$refs['fourth-card'].classList.add('hidden')
                    this.$parent.$parent.$refs['fifth-card'].classList.remove('hidden')
                    this.$parent.$parent.$refs['fifth-card'].classList.add('relative')
                    break
                }
            }
            this.$parent.$parent.currentStep = (this.$parent.$parent.currentStep + 1) % this.$parent.$parent.steps.length
        }
    }

    previousStep() {
        if (this.$parent.$parent.currentStep !== 0) {
            switch (this.$parent.$parent.currentStep) {
                case 1: {
                    this.$parent.$parent.$refs['second-card'].classList.add('hidden')
                    this.$parent.$parent.$refs['first-card'].classList.remove('hidden')
                    this.$parent.$parent.$refs['first-card'].classList.add('relative')
                    break
                }
                case 2: {
                    this.$parent.$parent.$refs['third-card'].classList.add('hidden')
                    this.$parent.$parent.$refs['second-card'].classList.remove('hidden')
                    this.$parent.$parent.$refs['second-card'].classList.add('relative')
                    break
                }
                case 3: {
                    this.$parent.$parent.$refs['fourth-card'].classList.add('hidden')
                    this.$parent.$parent.$refs['third-card'].classList.remove('hidden')
                    this.$parent.$parent.$refs['third-card'].classList.add('relative')
                    break
                }
                case 4: {
                    this.$parent.$parent.$refs['fifth-card'].classList.add('hidden')
                    this.$parent.$parent.$refs['fourth-card'].classList.remove('hidden')
                    this.$parent.$parent.$refs['fifth-card'].classList.add('relative')
                    break
                }
            }
            this.$parent.$parent.currentStep = (this.$parent.$parent.currentStep - 1) % this.$parent.$parent.steps.length
        }
    }


    showNextSlide(event: Event) {
        const el = (event.target as HTMLElement | null)?.parentElement
        const rawIndex = el?.dataset?.index ?? ""
        const index = Number.parseInt(rawIndex)
        if (isNaN(index)) {
            return
        }

        const [cardToHide, cardToShow] = this.findCards(index, index + 1)
        if (!cardToHide || !cardToShow) {
            return
        }

        cardToHide.classList.add("hidden")
        cardToShow.classList.add("shown")
        cardToHide.classList.remove("shown")
        cardToShow.classList.remove("hidden")
    }

    showPreviousSlide(event: Event) {
        const el = (event.target as HTMLElement | null)?.parentElement
        const rawIndex = el?.dataset?.index ?? ""
        const index = Number.parseInt(rawIndex)
        if (isNaN(index)) {
            return
        }

        const [cardToHide, cardToShow] = this.findCards(index, index - 1)
        if (!cardToHide || !cardToShow) {
            return
        }


        cardToHide.classList.remove("shown")
        cardToShow.classList.remove("hidden")
        cardToHide.classList.add("hidden")
        cardToShow.classList.add("shown")
    }
}
</script>

<style lang="scss" scoped>

@keyframes out-left {
    0% { left: 50% }
    100% { left: -100% }
}

@keyframes out-right {
    0% { left: 50% }
    100% { left: -100% }
}

@keyframes in-left {
    0% { left: 50% }
    100% { left: -100% }
}

@keyframes in-right {
    0% { left: 50% }
    100% { left: -100% }
}


.shown {
    animation: 2s show-animation;
}

.hide {
    animation: 2s hidden-animation;
}

.cards {
    position: relative;
}

.card {
    padding: 16px;
    color: black;
    position: absolute;
    left: 50%;
    top: 50%;
    background-color: white;
    width: 20em;
    height: 20em;
    transform: translateX(-50%) translateY(-50%);
}

button {
    background: grey;
    border-radius: 8px;
    padding: 8px;
}

</style>
