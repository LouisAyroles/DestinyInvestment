<template>
    <div ref="cards" class="flex justify-center items-center">
        <slot></slot>
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
        const parent = this.$parent.$parent as any
        if (parent.currentStep !== parent.steps.length - 1) {
            switch (parent.currentStep) {
                case 0: {
                    parent.$refs['first-card'].classList.add('hidden')
                    parent.$refs['second-card'].classList.remove('hidden')
                    parent.$refs['second-card'].classList.add('relative')
                    break
                }
                case 1: {
                    parent.$refs['second-card'].classList.add('hidden')
                    parent.$refs['third-card'].classList.remove('hidden')
                    parent.$refs['third-card'].classList.add('relative')
                    break
                }
                case 2: {
                    parent.$refs['third-card'].classList.add('hidden')
                    parent.$refs['fourth-card'].classList.remove('hidden')
                    parent.$refs['fourth-card'].classList.add('relative')
                    break
                }
                case 3: {
                    parent.$refs['fourth-card'].classList.add('hidden')
                    parent.$refs['fifth-card'].classList.remove('hidden')
                    parent.$refs['fifth-card'].classList.add('relative')
                    break
                }
            }
            parent.currentStep = parent.currentStep + 1
        }
    }

    previousStep() {
        const parent = this.$parent.$parent as any
        if (parent.currentStep !== 0) {
            switch (parent.currentStep) {
                case 1: {
                    parent.$refs['second-card'].classList.add('hidden')
                    parent.$refs['first-card'].classList.remove('hidden')
                    parent.$refs['first-card'].classList.add('relative')
                    break
                }
                case 2: {
                    parent.$refs['third-card'].classList.add('hidden')
                    parent.$refs['second-card'].classList.remove('hidden')
                    parent.$refs['second-card'].classList.add('relative')
                    break
                }
                case 3: {
                    parent.$refs['fourth-card'].classList.add('hidden')
                    parent.$refs['third-card'].classList.remove('hidden')
                    parent.$refs['third-card'].classList.add('relative')
                    break
                }
                case 4: {
                    parent.$refs['fifth-card'].classList.add('hidden')
                    parent.$refs['fourth-card'].classList.remove('hidden')
                    parent.$refs['fifth-card'].classList.add('relative')
                    break
                }
            }
            parent.currentStep = parent.currentStep - 1
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
