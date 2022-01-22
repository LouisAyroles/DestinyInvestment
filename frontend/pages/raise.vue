<template>
    <div class="pt-20 sections h-full">
        <d-app-bar currentPage="Raise" class="fixed top-0 left-0 right-0"/>
        <d-section class="flex flex-col">
            <div class="p-0 md:py-12 md:px-20 lg:px-32">
                <d-stepper :steps="steps" :currentStep=currentStep></d-stepper>
            </div>

            <div class="flex container-form grow items-center min-w-full">
                <div class="flex justify-center">
                    <div class="first-subcard"></div>
                    <div class="second-subcard"></div>
                </div>

                <swiper @slide-change="scrollToTheTop" ref="mySwiper" :options="swiperOptions">
                    <swiper-slide ref="first-card">
                        <div class="flex justify-center">
                            <div class="card-container self-center flex flex-col min-w-full md:min-w-0">
                                <div class="hidden md:block">
                                    <h1 class="title">Personal details</h1>
                                </div>

                                <div class="input-container">
                                    <div class="inputs">
                                        <div class="relative">
                                            <div class="relative">
                                                <input autocomplete="off" v-model="name" name="name" type="text"
                                                       class="peer placeholder-transparent px-2 h-10 w-full border-2 rounded-lg border-gray-300 text-gray-900 focus:outline-none focus:borer-rose-600"
                                                       placeholder="Email address"/>
                                                <label for="email"
                                                       class="absolute ml-2 left-0 -top-3.5 text-gray-600 text-sm peer-placeholder-shown:text-base peer-placeholder-shown:text-gray-440 peer-placeholder-shown:top-2 transition-all peer-focus:-top-5 peer-focus:text-gray-600 peer-focus:text-sm">Name</label>
                                            </div>
                                        </div>
                                        <div class="relative">
                                            <input autocomplete="off" v-model="mail" name="email" type="text"
                                                   class="peer placeholder-transparent px-2 h-10 w-full border-2 rounded-lg border-gray-300 text-gray-900 focus:outline-none focus:borer-rose-600"
                                                   placeholder="Email address"/>
                                            <label for="email"
                                                   class="absolute ml-2 left-0 -top-3.5 text-gray-600 text-sm peer-placeholder-shown:text-base peer-placeholder-shown:text-gray-440 peer-placeholder-shown:top-2 transition-all peer-focus:-top-5 peer-focus:text-gray-600 peer-focus:text-sm">Email
                                                Address</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="flex justify-end items-center gap-3">
                                    <d-button @click.native="next" icon="arrow-right-thick" class="text-white"/>
                                </div>
                            </div>
                        </div>
                    </swiper-slide>

                    <!-- Second Card -->
                    <swiper-slide ref="second-card">
                        <div class="flex justify-center">
                            <div class="card-container self-center flex flex-col min-w-full md:min-w-0">
                                <div class="hidden md:block">
                                    <h1 class="title">Company details</h1>
                                </div>
                                <span class="text-slate-500 text-center md:text-left"> What are your areas of Investment?</span>
                                <div class="input-container">
                                    <div class="inputs">
                                        <div class="relative">
                                            <div class="relative">
                                                <input autocomplete="off" v-model="companyName" name="name" type="text"
                                                       class="peer placeholder-transparent px-2 h-10 w-full border-2 rounded-lg border-gray-300 text-gray-900 focus:outline-none focus:borer-rose-600"
                                                       placeholder="Email address"/>
                                                <label for="email"
                                                       class="absolute ml-2 left-0 -top-3.5 text-gray-600 text-sm peer-placeholder-shown:text-base peer-placeholder-shown:text-gray-440 peer-placeholder-shown:top-2 transition-all peer-focus:-top-5 peer-focus:text-gray-600 peer-focus:text-sm">Name</label>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="flex justify-end items-center gap-3">
                                    <d-button @click.native="prev" icon="arrow-left-thick" class="text-white"/>
                                    <d-button @click.native="next" icon="arrow-right-thick" class="text-white"/>
                                </div>
                            </div>
                        </div>
                    </swiper-slide>

                    <!-- Third Card -->
                    <swiper-slide ref="third-card">
                        <div class="flex justify-center">
                            <div class="card-container self-center flex flex-col min-w-full md:min-w-0">
                                <div class="hidden md:block">
                                    <h1 class="title">Pitch Deck</h1>
                                </div>
                                <div class="input-container grow">
                                    <div class="inputs">
                                        <div class="flex items-center justify-center bg-grey-lighter">
                                            <label v-if="pitchDeck === ''"
                                                   class="w-64 flex flex-col items-center px-4 py-6 bg-white text-blue rounded-lg shadow-lg tracking-wide uppercase border border-blue cursor-pointer hover:bg-blue hover:text-primary-dark">
                                                <svg class="w-8 h-8" fill="currentColor"
                                                     xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
                                                    <path
                                                        d="M16.88 9.1A4 4 0 0 1 16 17H5a5 5 0 0 1-1-9.9V7a3 3 0 0 1 4.52-2.59A4.98 4.98 0 0 1 17 8c0 .38-.04.74-.12 1.1zM11 11h3l-4-4-4 4h3v3h2v-3z"/>
                                                </svg>
                                                <span class="mt-2 text-base leading-normal">Select a PDF file</span>
                                                <input type='file' class="hidden" accept=".pdf"
                                                       v-on:change="handleFileUpload($event)"/>
                                            </label>
                                            <label v-else
                                                   class="w-64 flex flex-col items-center px-4 py-6 bg-white text-blue rounded-lg shadow-lg tracking-wide uppercase border border-blue cursor-pointer hover:bg-blue hover:text-primary-dark">
                                                <span class="mt-2 text-base leading-normal"> {{ pitchDeck.name }}</span>
                                                <input type='file' class="hidden" accept=".pdf"
                                                       v-on:change="handleFileUpload($event)"/>
                                            </label>
                                        </div>
                                    </div>
                                </div>

                                <div class="flex justify-end items-center gap-3">
                                    <d-button @click.native="prev" icon="arrow-left-thick" class="text-white"/>
                                    <d-button @click.native="next" icon="arrow-right-thick" class="text-white"/>
                                </div>
                            </div>
                        </div>
                    </swiper-slide>

                    <!-- Fourth Card -->
                    <swiper-slide ref="fifth-card">
                        <div class="flex justify-center">
                            <div class="confirmation-card-container flex flex-col min-w-full md:min-w-0">
                                <div class="min-w-full min-h-full p-10">
                                    <div class="hidden md:block">
                                        <h1 class="title"> Confirmation </h1>
                                    </div>
                                    <div class="input-container grow">
                                        <div class="inputs">
                                            <div class="relative">
                                                <div class="flex flex-col">
                                                    <div class="flex flex-row my-2 ">
                                                        <span class="text-primary-dark md:text-gray-700"><b> Name : </b><span
                                                            class="text-black">&nbsp {{ name }}</span></span>

                                                    </div>
                                                    <div class="flex flex-row my-2">
                                                        <span class="text-primary-dark md:text-gray-700"> <b>Email :</b> <span
                                                            class="text-black">&nbsp {{ mail }}</span> </span>

                                                    </div>
                                                    <div class="flex flex-row my-2 ">
                                                        <span class="text-primary-dark md:text-gray-700"> <b>Company name :</b> <span
                                                            class="text-black">&nbsp {{ companyName }}</span> </span>

                                                    </div>
                                                    <div class="flex flex-row my-2 ">
                                                            <span class="text-primary-dark md:text-gray-700"> <b>Pitch deck : </b> <span
                                                                class="text-black">&nbsp {{
                                                                    pitchDeck.name
                                                                }}</span> </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="flex justify-end items-center gap-3">
                                        <d-button @click.native="prev" icon="arrow-left-thick" class="text-white"/>
                                        <d-button @click.native="submit" icon="check" class="text-white"/>
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
        centerInsufficientSlides: true,
        autoHeight: true,
        breakpoints: {
            768:
                {
                    autoHeight: false
                }
        }
    }

    //Form value
    name: string = "";
    mail: string = "";
    companyName = "";
    pitchDeck = ""

    get swiper() {
        return (this as any).$refs.mySwiper.$swiper
    }

    next() {
        console.log(this.pitchDeck)
        this.swiper.slideTo(++this.currentStep, 1000, false)
    }

    prev() {
        this.swiper.slideTo(--this.currentStep, 1000, false)
    }

    handleFileUpload(event: any) {
        this.pitchDeck = event.target.files[0];
    }

    scrollToTheTop() {
        window.scrollTo({top: 0, behavior: 'smooth'})
    }

    submit() {
        const formData = new FormData();
        formData.append("file", this.pitchDeck)
        formData.append('properties', new Blob([JSON.stringify({
            "name": this.name,
            "email": this.mail,
            "company name": this.companyName
        })], {
            type: "application/json"
        }));
        fetch('api/raise/apply', {
            method: 'POST',
            headers: {
                'Content-Type': 'undefined'
            },
            body: formData
        }).then(() => {
            this.$router.push({
                path: '/'
            })
            Vue.swal({
                icon: 'success',
                title: 'Perfect',
                text: 'Thank you for your interest !',
            })
        })
            .catch(err => Vue.swal({
                icon: 'error',
                title: 'Oops...',
                text: err.error,
            }));
    }
}
</script>

<style lang="scss" scoped>
@mixin card {
    @apply min-h-[20rem] w-[12rem] md:h-[24rem] md:w-[40rem] sm:rounded-3xl bg-transparent md:bg-slate-100;
}

.raise-container {
    @apply p-0 md:py-12 md:px-20 lg:px-32
}

.second-subcard {
    @include card;
    @apply hidden md:block absolute inset-0 bg-gradient-to-r from-primary-dark to-primary shadow-2xl transform mx-auto sm:rounded-3xl;
    top: 50%;
    transform: translateY(-50%) rotate(-6deg);
}

.first-subcard {
    @include card;
    @apply hidden md:block absolute inset-0 bg-gradient-to-r from-primary to-primary-dark shadow-2xl transform mx-auto sm:rounded-3xl;
    top: 50%;
    transform: translateY(-50%) rotate(-12deg);
}

.slider {
    margin-top: 10em;
    @apply min-h-full
}

.container-form {
    @apply relative py-3 sm:max-w-xl sm:mx-auto;
}

.card-container {
    @include card;
    @apply relative px-4 py-10 shadow-lg sm:rounded-3xl sm:p-20;
}

.title {
    @apply text-2xl font-semibold text-black
}

.confirmation-card-container {
    @include card;
    @apply relative md:shadow-lg p-4;
}

.input-container {
    @apply divide-y divide-gray-200;
}

.inputs {
    @apply py-8 text-base leading-6 space-y-4 text-gray-700 sm:text-lg sm:leading-7;
}
</style>
