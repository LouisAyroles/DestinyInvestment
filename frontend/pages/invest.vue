<template>
    <div class="pt-20 sections h-full">
        <d-app-bar currentPage="Invest" class="fixed top-0 left-0 right-0"/>
        <d-section class="invest-container">
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
                        <div ref="second-card" class="hidden card-container-checkbox">
                            <div>
                                <h1 class="title">Investment field</h1>
                            </div>
                            <span class="text-slate-500"> What are your areas of Investment?</span>
                            <div class="input-container">
                                <div class="checkboxs">
                                    <div class="flex flex-col items-center justify-center">
                                        <div class="grid grid-cols-3">
                                            <div v-for="invest in investmentFields">
                                                <label class="inline-flex items-center mt-3">
                                                    <input type="checkbox"
                                                           class="form-checkbox h-5 w-5 text-gray-600"><span
                                                    class="ml-2 text-gray-700">{{ invest }}</span>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Third Card -->
                        <div ref="third-card" class="hidden card-container-checkbox">
                            <div>
                                <h1 class="title">Investment field</h1>
                            </div>
                            <span class="text-slate-500"> Which company stage is more interesting for you?</span>
                            <div class="mt-10">
                                <label class="inline-flex items-center mt-3">
                                    <input type="checkbox"
                                           class="form-checkbox h-5 w-5 text-gray-600"><span
                                    class="ml-2 text-gray-700">Earlier stage with higher return potential</span>
                                </label>
                                <label class="inline-flex items-center mt-3">
                                    <input type="checkbox"
                                           class="form-checkbox h-5 w-5 text-gray-600"><span
                                    class="ml-2 text-gray-700">Later stage growth companies with market traction</span>
                                </label>
                            </div>
                        </div>

                        <!-- Fourth Card -->
                        <div ref="fourth-card" class="hidden card-container-checkbox">
                            <div>
                                <h1 class="title">Portfolio size</h1>
                            </div>
                            <span class="text-slate-500">What is your investment portfolio size?</span>
                            <div class="mt-10 flex flex-col">
                                <label class="inline-flex items-center mt-3">
                                    <input type="checkbox"
                                           class="form-checkbox h-5 w-5 text-gray-600"><span
                                    class="ml-2 text-gray-700"> Less than 500 000€</span>
                                </label>
                                <label class="inline-flex items-center mt-3">
                                    <input type="checkbox"
                                           class="form-checkbox h-5 w-5 text-gray-600"><span
                                    class="ml-2 text-gray-700">500 000€ to 1 000 000€</span>
                                </label>
                                <label class="inline-flex items-center mt-3">
                                    <input type="checkbox"
                                           class="form-checkbox h-5 w-5 text-gray-600"><span
                                    class="ml-2 text-gray-700">1 000 000 to 5 000 000€</span>
                                </label>
                                <label class="inline-flex items-center mt-3">
                                    <input type="checkbox"
                                           class="form-checkbox h-5 w-5 text-gray-600"><span
                                    class="ml-2 text-gray-700">more than 5M</span>
                                </label>
                            </div>
                        </div>

                        <!-- Fifth Card -->
                        <div ref="fifth-card" class="hidden card-container">
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
export default class invest extends Vue {
    currentStep = 0;
    readonly steps: Step[] = [{
        title: "Personal details",
        icon: "account"
    }, {
        title: "Investment field (1/2)",
        icon: "card-account-details"
    }, {
        title: "Investment field (2/2)",
        icon: "card-account-details"
    }, {
        title: "Portfolio size",
        icon: "briefcase-variant"
    }, {
        title: "Confirmation",
        icon: "check"
    }]

    readonly investmentFields: string[] = [
        "Sportech", "Greentech", "Fintech", "Blockchain", "Biotech", "E-commerce", "Edtech", "Cybersécurité", "Others", "Artificial Intelligence"]

}
</script>

<style lang="scss" scoped>
.invest-container {
    @apply p-0 md:py-12 md:px-20 lg:px-32
}

.second-subcard {
    @apply absolute inset-0 bg-gradient-to-r from-primary-dark to-primary shadow-lg transform -rotate-6 sm:rounded-3xl;
}

.first-subcard {
    @apply absolute inset-0 bg-gradient-to-r from-primary to-primary-dark shadow-lg transform -rotate-12 sm:rounded-3xl;
}

.slider {
    margin-top: 10em;
}

.container-form {
    @apply relative py-3 sm:max-w-xl sm:mx-auto;
}

.card-container {
    @apply relative px-4 py-10 bg-white shadow-lg sm:rounded-3xl sm:p-20 h-[20rem] w-[12rem] md:h-[20rem] md:w-[40rem];
}

.card-container-checkbox {
    @apply relative px-4 py-10 bg-white shadow-lg sm:rounded-3xl h-[20rem] w-[40rem];
}

.title {
    @apply text-2xl font-semibold text-black
}


.inputs {
    @apply py-8 text-base leading-6 space-y-4 text-gray-700 sm:text-lg sm:leading-7;
}

.checkboxs {
    @apply py-4 text-base leading-6 space-y-4 text-gray-700 sm:text-lg sm:leading-7;
}
</style>
