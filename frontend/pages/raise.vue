<template>
    <div class="pt-20 sections h-full">
        <d-app-bar currentPage="Raise" class="fixed top-0 left-0 right-0"/>
        <d-section class="raise-container">
            <d-stepper :steps="steps" :currentStep=currentStep></d-stepper>

            <d-slider class="slider">

                <div class="container-form">
                    <div class="first-subcard"></div>
                    <div class="second-subcard"></div>

                    <div class="main-cards">

                        <!-- First Card -->
                        <div ref="first-card" class="card-container">
                            <div class="">
                                <div>
                                    <h1 class="title"> Personal details </h1>
                                </div>
                                <div class="input-container">
                                    <div class="inputs">
                                        <div class="relative">
                                            <div class="relative">
                                                <input autocomplete="off" id="name" name="name" type="text"
                                                       class="peer placeholder-transparent h-10 w-full border-2 rounded-lg border-gray-300 text-gray-900 focus:outline-none focus:borer-rose-600"
                                                       placeholder="Email address"/>
                                                <label for="email"
                                                       class="absolute ml-2 left-0 -top-3.5 text-gray-600 text-sm peer-placeholder-shown:text-base peer-placeholder-shown:text-gray-440 peer-placeholder-shown:top-2 transition-all peer-focus:-top-5 peer-focus:text-gray-600 peer-focus:text-sm">Name</label>
                                            </div>
                                        </div>
                                        <div class="relative">
                                            <input autocomplete="off" id="email" name="email" type="text"
                                                   class="peer placeholder-transparent h-10 w-full border-2 rounded-lg border-gray-300 text-gray-900 focus:outline-none focus:borer-rose-600"
                                                   placeholder="Email address"/>
                                            <label for="email"
                                                   class="absolute ml-2 left-0 -top-3.5 text-gray-600 text-sm peer-placeholder-shown:text-base peer-placeholder-shown:text-gray-440 peer-placeholder-shown:top-2 transition-all peer-focus:-top-5 peer-focus:text-gray-600 peer-focus:text-sm">Email
                                                Address</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Second Card -->
                        <div ref="second-card" class="hidden card-container">
                            <div>
                                <h1 class="title"> Company Details</h1>
                            </div>
                            <div class="input-container">
                                <div class="inputs">
                                    <div class="relative">
                                        <input autocomplete="off" id="email" name="email" type="text"
                                               class="peer placeholder-transparent h-10 w-full border-2 rounded-lg border-gray-300 text-gray-900 focus:outline-none focus:borer-rose-600"
                                               placeholder="Email address"/>
                                        <label for="email"
                                               class="absolute ml-2 left-0 -top-3.5 text-gray-600 text-sm peer-placeholder-shown:text-base peer-placeholder-shown:text-gray-440 peer-placeholder-shown:top-2 transition-all peer-focus:-top-5 peer-focus:text-gray-600 peer-focus:text-sm">Company
                                            Name</label>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Third Card -->
                        <div ref="third-card" class="hidden card-container">
                            <div class="max-w-md mx-auto">
                                <div>
                                    <h1 class="title"> Pitch Deck </h1>
                                </div>
                                <div class="input-container">
                                    <div class="inputs">
                                        <div class="flex items-center justify-center bg-grey-lighter">
                                            <label
                                                class="w-64 flex flex-col items-center px-4 py-6 bg-white text-blue rounded-lg shadow-lg tracking-wide uppercase border border-blue cursor-pointer hover:bg-blue hover:text-primary-dark">
                                                <svg class="w-8 h-8" fill="currentColor"
                                                     xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
                                                    <path
                                                        d="M16.88 9.1A4 4 0 0 1 16 17H5a5 5 0 0 1-1-9.9V7a3 3 0 0 1 4.52-2.59A4.98 4.98 0 0 1 17 8c0 .38-.04.74-.12 1.1zM11 11h3l-4-4-4 4h3v3h2v-3z"/>
                                                </svg>
                                                <span class="mt-2 text-base leading-normal">Select a file</span>
                                                <input type='file' class="hidden"/>
                                            </label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Fourth Card -->
                        <div ref="fourth-card" class="hidden card-container">
                            <div class="max-w-md mx-auto">
                                <div>
                                    <h1 class="title"> Confirmation </h1>
                                </div>
                                <div class="input-container">
                                    <div class="inputs">
                                        <div class="relative">
                                            <div class="flex flex-col">
                                                <div class="flex flex-row">
                                                    <span> Name : </span>
                                                    <span> Bonjour</span>
                                                </div>
                                                <div class="flex flex-row">
                                                    <span> Email : </span>
                                                    <span> Bonjour</span>
                                                </div>
                                                <div class="flex flex-row">
                                                    <span> Company name : </span>
                                                    <span> Bonjour</span>
                                                </div>
                                                <div class="flex flex-row">
                                                    <span> Pitch deck : </span>
                                                    <span> Bonjour</span>
                                                </div>
                                            </div>
                                        </div>
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
    currentStep = 0;

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

.container-form {
    @apply relative py-3 sm:max-w-xl sm:mx-auto;
}

.card-container {
    @apply relative px-4 py-10 bg-white shadow-lg sm:rounded-3xl sm:p-20 h-[20rem] w-[35rem];
}

.title {
    @apply text-2xl font-semibold text-black
}
.input-container{
    @apply divide-y divide-gray-200;
}
.inputs{
    @apply py-8 text-base leading-6 space-y-4 text-gray-700 sm:text-lg sm:leading-7;
}
</style>
