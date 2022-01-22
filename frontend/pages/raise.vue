<template>
    <div class="pt-20 sections h-full">
        <d-app-bar currentPage="Raise" class="fixed top-0 left-0 right-0"/>
        <d-section class="raise-container">
            <d-stepper :steps="steps" :currentStep=currentStep></d-stepper>

            <div class="container-form min-w-full">
                <div class="flex justify-center min-w-full">
                    <div class="first-subcard"></div>
                    <div class="second-subcard"></div>
                </div>

                <swiper @slide-change="console.log('bonjour')" ref="mySwiper" :options="swiperOptions">
                    <swiper-slide ref="first-card">
                        <div class="flex justify-center ">
                            <div class="card-container flex flex-col">
                                <div>
                                    <h1 class="title"> Personal details </h1>
                                </div>
                                <div class="input-container grow">
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
                                <div class="flex justify-end items-center gap-3">
                                    <d-button @click.native="next" icon="arrow-right-thick" class="button"/>
                                </div>
                            </div>
                        </div>
                    </swiper-slide>

                    <!-- Second Card -->
                    <swiper-slide ref="second-card">
                        <div class="flex justify-center">
                            <div class="card-container flex flex-col">
                                <div>
                                    <h1 class="title"> Company Details</h1>
                                </div>
                                <div class="input-container grow">
                                    <div class="inputs">
                                        <div class="relative">
                                            <input autocomplete="off" name="email" type="text"
                                                   class="peer placeholder-transparent h-10 w-full border-2 rounded-lg border-gray-300 text-gray-900 focus:outline-none focus:borer-rose-600"
                                                   placeholder="Email address"/>
                                            <label for="email"
                                                   class="absolute ml-2 left-0 -top-3.5 text-gray-600 text-sm peer-placeholder-shown:text-base peer-placeholder-shown:text-gray-440 peer-placeholder-shown:top-2 transition-all peer-focus:-top-5 peer-focus:text-gray-600 peer-focus:text-sm">Company
                                                Name</label>
                                        </div>
                                    </div>
                                </div>

                                <div class="flex justify-end items-center gap-3">
                                    <d-button @click.native="prev" icon="arrow-left-thick" class="button"/>
                                    <d-button @click.native="next" icon="arrow-right-thick" class="button"/>
                                </div>
                            </div>
                        </div>
                    </swiper-slide>

                    <!-- Third Card -->
                    <swiper-slide ref="third-card" >
                        <div class="flex justify-center">
                            <div class="card-container flex flex-col">
                                <div>
                                    <h1 class="title"> Pitch Deck </h1>
                                </div>
                                <div class="input-container grow">
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

                                <div class="flex justify-end items-center gap-3">
                                    <d-button @click.native="prev" icon="arrow-left-thick" class="button"/>
                                    <d-button @click.native="next" icon="arrow-right-thick" class="button"/>
                                </div>
                            </div>
                        </div>
                    </swiper-slide>

                    <!-- Fourth Card -->
                    <swiper-slide ref="fourth-card">
                        <div class="flex justify-center">
                            <div class="card-container flex flex-col">
                                <div class="max-w-md mx-auto">
                                    <div>
                                        <h1 class="title"> Confirmation </h1>
                                    </div>
                                    <div class="input-container grow">
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
                                    <div class="flex justify-end items-center gap-3">
                                        <d-button @click.native="prev" icon="arrow-left-thick" class="button"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </swiper-slide>
                </swiper>
            </div>
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

    readonly swiperOptions = {
        allowTouchMove: false,
        slidesPerView: 1,
        spaceBetween: 10,
        centeredSlides: true,
        centerInsufficientSlides: true
    }

    get swiper() {
        return (this as any).$refs.mySwiper.$swiper
    }

    next() {
        this.swiper.slideTo(++this.currentStep, 1000, false)
    }

    prev() {
        this.swiper.slideTo(--this.currentStep, 1000, false)
    }

}
</script>

<style lang="scss" scoped>
@mixin card {
    @apply min-h-full w-[12rem] md:h-[24rem] md:w-[40rem] sm:rounded-3xl shadow-lg;
}
.raise-container {
    @apply p-0 md:py-12 md:px-20 lg:px-32
}
.second-subcard {
    @include card;
    @apply absolute inset-0 bg-gradient-to-r from-primary-dark to-primary shadow-lg transform mx-auto -rotate-6 sm:rounded-3xl;
}
.first-subcard {
    @include card;
    @apply absolute inset-0 bg-gradient-to-r from-primary to-primary-dark shadow-lg transform mx-auto -rotate-12 sm:rounded-3xl;
}
.slider {
    margin-top: 10em;
}

.container-form {
    @apply relative py-3 sm:max-w-xl sm:mx-auto;
}

.card-container {
    @include card;
    @apply relative px-4 py-10 bg-white shadow-lg sm:rounded-3xl sm:p-20;
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
