<template>
    <div class="pt-20 sections h-full">
        <d-app-bar currentPage="Invest" class="fixed top-0 left-0 right-0"/>
        <d-section>
            <d-stepper :steps="steps" :currentStep=1></d-stepper>
        </d-section>

    </div>
</template>

<script lang="ts">

import {Component, Vue} from 'vue-property-decorator'
import {Step} from "~/components/DStepper.vue";

@Component
export default class invest extends Vue {
    readonly steps: Step[] = [{
        title: "Personal details",
        icon: "account"
    }, {
        title: "Professional details",
        icon: "card-account-details"
    }, {
        title: "Your strengths",
        icon: "arm-flex"
    }, {
        title: "Confirmation",
        icon: "check"
    }]

}
</script>

<style lang="scss" scoped>

</style>
