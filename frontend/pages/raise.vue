<template>
    <div class="pt-20 sections h-full">
        <d-app-bar currentPage="Raise" class="fixed top-0 left-0 right-0"/>
        <d-section class="raise-container">
            <d-stepper :steps="steps" :currentStep=2></d-stepper>
        </d-section>
    </div>
</template>

<script lang="ts">

import {Component, Vue} from 'vue-property-decorator'
import {Step} from "~/components/DStepper.vue";

@Component
export default class raise extends Vue {
    readonly steps: Step[] = [{
        title: "Personal details",
        icon: "account"
    }, {
        title: "Company details",
        icon: "card-account-details"
    }, {
        title: "Pitch deck",
        icon: "file-document-multiple-outline"
    }, {
        title: "Confirmation",
        icon: "check"
    }]

}
</script>

<style lang="scss" scoped>
.raise-container {
    @apply p-0 md:py-12 md:px-20 lg:px-32
}
</style>
