<template>
    <div class="pt-20 sections h-full">
        <d-app-bar currentPage="Raise" class="fixed top-0 left-0 right-0"/>
        <d-section class="raise-container">
            <d-stepper :steps="steps" :currentStep=2></d-stepper>

            <d-slider class="slider">


                    <div class="container-form">
                        <div class="first-subcard"></div>
                        <div class="second-subcard"></div>

                        <div class="main-card">
                            <div class="max-w-md mx-auto">
                                <div>
                                    <h1 class="title"> Personal details </h1>
                                </div>
                                <div class="input-container">
                                    <div class="inputs">
                                        <div class="relative">
                                            <input autocomplete="off" id="name" name="name" type="password" class="input" placeholder="Name" />
                                            <label for="name" class="label-input">Name</label>
                                        </div>
                                        <div class="relative">
                                            <input autocomplete="off" id="email" name="email" type="text" class="peer placeholder-transparent h-10 w-full border-2 rounded-lg border-gray-300 text-gray-900 focus:outline-none focus:borer-rose-600" placeholder="Email address" />
                                            <label for="email" class="absolute ml-2 left-0 -top-3.5 text-gray-600 text-sm peer-placeholder-shown:text-base peer-placeholder-shown:text-gray-440 peer-placeholder-shown:top-2 transition-all peer-focus:-top-3.5 peer-focus:text-gray-600 peer-focus:text-sm">Email Address</label>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
            </d-slider>
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
.second-subcard{
    @apply absolute inset-0 bg-gradient-to-r from-primary-dark to-primary shadow-lg transform -skew-y-6 sm:skew-y-0 sm:-rotate-6 sm:rounded-3xl;
}
.first-subcard{
    @apply absolute inset-0 bg-gradient-to-r from-primary to-primary-dark shadow-lg transform -skew-y-12 sm:skew-y-0 sm:-rotate-12 sm:rounded-3xl;
}
.slider {
    margin-top: 10em;
}
.container-form{
    @apply relative py-3 sm:max-w-xl sm:mx-auto;
}
.main-card{
    @apply relative px-4 py-10 bg-white shadow-lg sm:rounded-3xl sm:p-20;
}
.title{
    @apply text-2xl font-semibold text-black
}
.input-container{
    @apply divide-y divide-gray-200;
}
.inputs{
    @apply py-8 text-base leading-6 space-y-4 text-gray-700 sm:text-lg sm:leading-7;
}
.input{
    @apply placeholder-transparent h-10 w-full border-2 rounded-lg border-gray-300 text-gray-900 focus:outline-none focus:border-rose-600
}
.label-input{
    @apply absolute left-0 ml-2 -top-3.5 text-gray-600 text-sm peer-placeholder-shown:text-base peer-placeholder-shown:text-gray-440 peer-placeholder-shown:top-2 transition-all peer-focus:-top-3.5 peer-focus:text-gray-600 peer-focus:text-sm;
}
</style>
