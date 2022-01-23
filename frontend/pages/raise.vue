<template>
    <div class="pt-20 sections h-full">
        <d-app-bar currentPage="Raise" class="appbar"/>
        <d-section class="flex flex-col">
            <div class="stepper-container">
                <d-stepper :steps="steps" :currentStep=currentStep></d-stepper>
            </div>

            <div class="container-form">
                <div class="flex justify-center">
                    <div class="first-subcard"></div>
                    <div class="second-subcard"></div>
                </div>

                <swiper @slide-change="scrollToTheTop" ref="mySwiper" :options="swiperOptions">
                    <swiper-slide ref="first-card">
                        <div class="flex justify-center">
                            <div class="card-container ">
                                <div class="hidden md:block">
                                    <h1 class="title">Personal details</h1>
                                </div>

                                <div class="input-container">
                                    <div class="inputs">
                                        <div class="relative">
                                            <input autocomplete="off" v-model="name" id="name" type="text"
                                                   :class="{'border-primary-dark' :!isNameValid && this.tryToNext}"
                                                   class="peer placeholder-transparent px-2 h-10 w-full border-2 rounded-lg text-gray-900 focus:outline-none focus:borer-rose-600"
                                                   placeholder="Name"/>
                                            <label for="name"
                                                   class="absolute ml-2 left-0 -top-3.5 text-gray-600 text-sm peer-placeholder-shown:text-base peer-placeholder-shown:text-gray-440 peer-placeholder-shown:top-2 transition-all peer-focus:-top-5 peer-focus:text-gray-600 peer-focus:text-sm">Name</label>
                                            <span class="text-sm text-primary"
                                                  v-if="!isNameValid && this.tryToNext">Please fill your name </span>
                                            <span class="text-sm"
                                                  v-if="!(!isNameValid && this.tryToNext)">&nbsp</span>
                                        </div>
                                        <div class="relative">
                                            <input autocomplete="off" v-model="mail" id="email" type="text"
                                                   :class="{'border-primary-dark' :!isMailValid && this.tryToNext}"
                                                   class="peer placeholder-transparent px-2 h-10 w-full border-2 rounded-lg text-gray-900 focus:outline-none focus:borer-rose-600"
                                                   placeholder="Email address"/>
                                            <label for="email"
                                                   class="absolute ml-2 left-0 -top-3.5 text-gray-600 text-sm peer-placeholder-shown:text-base peer-placeholder-shown:text-gray-440 peer-placeholder-shown:top-2 transition-all peer-focus:-top-5 peer-focus:text-gray-600 peer-focus:text-sm">Email
                                                Address</label>
                                            <span class="text-sm text-primary" v-if="!isMailNotEmpty && this.tryToNext">Please fill your email </span>
                                            <span class="text-sm text-primary"
                                                  v-if="!isMailValid && isMailNotEmpty && this.tryToNext">This is not a valid email </span>
                                            <span class="text-sm" v-if="!(!isMailValid && this.tryToNext)">&nbsp</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="button-container">
                                    <d-button @click.native="next" icon="arrow-right-thick" class="text-white"/>
                                </div>
                            </div>
                        </div>
                    </swiper-slide>

                    <!-- Second Card -->
                    <swiper-slide ref="second-card">
                        <div class="flex justify-center">
                            <div class="card-container">
                                <div class="hidden md:block">
                                    <h1 class="title">Company details</h1>
                                </div>
                                <span class="question">What is the name of your company?</span>
                                <div class="input-container">
                                    <div class="inputs">
                                        <div class="relative">
                                            <div class="relative">
                                                <input autocomplete="off" v-model="companyName" id="companyName"
                                                       type="text"
                                                       :class="{'border-primary-dark' :!isValidCard2 && this.tryToNext}"
                                                       class="peer placeholder-transparent px-2 h-10 w-full border-2 rounded-lg text-gray-900 focus:outline-none focus:borer-rose-600"
                                                       placeholder="Company name"/>
                                                <label for="companyName"
                                                       class="absolute ml-2 left-0 -top-3.5 text-gray-600 text-sm peer-placeholder-shown:text-base peer-placeholder-shown:text-gray-440 peer-placeholder-shown:top-2 transition-all peer-focus:-top-5 peer-focus:text-gray-600 peer-focus:text-sm">Name</label>
                                                <span class="error text-center md:text-left"
                                                      v-if="!isValidCard2 && this.tryToNext">Please fill your company name</span>
                                                <span class="error"
                                                      v-if="!(!isValidCard2 && this.tryToNext)">&nbsp</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="button-container">
                                    <d-button @click.native="prev" icon="arrow-left-thick" class="text-white"/>
                                    <d-button @click.native="next" icon="arrow-right-thick" class="text-white"/>
                                </div>
                            </div>
                        </div>
                    </swiper-slide>

                    <!-- Third Card -->
                    <swiper-slide ref="third-card">
                        <div class="flex justify-center">
                            <div class="card-container">
                                <div class="hidden md:block">
                                    <h1 class="title">Pitch Deck</h1>
                                </div>
                                <span class="error text-center md:text-left" v-if="!isValidCard3 && this.tryToNext">Please upload your pitch deck. </span>
                                <span class="error" v-if="!(!isValidCard3 && this.tryToNext)">&nbsp</span>
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

                                <div class="button-container">
                                    <d-button @click.native="prev" icon="arrow-left-thick" class="text-white"/>
                                    <d-button @click.native="next" icon="arrow-right-thick" class="text-white"/>
                                </div>
                            </div>
                        </div>
                    </swiper-slide>

                    <!-- Fourth Card -->
                    <swiper-slide ref="fifth-card">
                        <div class="flex justify-center">
                            <div class="confirmation-card-container ">
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
                                    <div class="button-container">
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


    /**************************************************
     *
     *              STEPPER & SWIPER OPTIONS
     *
     ***************************************************/

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

    currentStep = 0;

    /**************************************************
     *
     *                   FORM HANDLER
     *
     ***************************************************/

        //Form value
    name: string = "";
    mail: string = "";
    companyName = "";
    pitchDeck = ""
    tryToNext = false

    get isNameValid() {
        return !!this.name && this.name.length > 0
    }

    get isMailNotEmpty() {
        return !!this.mail && this.mail.length > 0
    }

    get isMailValid() {
        return !!this.mail && this.validEmail(this.mail)
    }

    get isMailOk() {
        return this.isMailNotEmpty && this.isMailValid
    }

    get isValidCard1() {
        return this.isNameValid && this.isMailOk
    }

    get isValidCard2() {
        return !!this.companyName && this.companyName.length > 0
    }

    get isValidCard3() {
        return !!this.pitchDeck && this.pitchDeck !== ''
    }

    get isFormValid() {
        return [this.isValidCard1, this.isValidCard2, this.isValidCard3]
    }


    /**************************************************
     *
     *            NAVIGATION HANDLER
     *
     ***************************************************/

    get swiper() {
        return (this as any).$refs.mySwiper.$swiper
    }

    next() {
        if (!this.isFormValid[this.currentStep]) {
            this.tryToNext = true
            return
        }
        this.tryToNext = false
        this.swiper.slideTo(++this.currentStep, 1000, false)
    }

    prev() {
        this.swiper.slideTo(--this.currentStep, 1000, false)
    }


    submit() {
        const formData = new FormData();
        formData.append("pitchDeck", this.pitchDeck)
        formData.append('raiseForm', new Blob([JSON.stringify({
            "name": this.name,
            "email": this.mail,
            "companyName": this.companyName
        })], {
            type: "application/json"
        }));
        fetch('api/raise/apply', {
            method: 'POST',
            body: formData
        }).then(res => {
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


    /**************************************************
     *
     *            UTILS METHODS
     *
     ***************************************************/


    handleFileUpload(event: any) {
        this.pitchDeck = event.target.files[0];
    }

    scrollToTheTop() {
        window.scrollTo({top: 0, behavior: 'smooth'})
    }

    validEmail(email: string) {
        const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test(email);
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
    @apply relative py-3 sm:max-w-xl sm:mx-auto flex  grow items-center min-w-full;
}

.card-container {
    @include card;
    @apply relative px-4 py-10 shadow-lg sm:rounded-3xl sm:p-20 self-center flex flex-col min-w-full md:min-w-0;
}

.title {
    @apply text-2xl font-semibold text-black
}

.confirmation-card-container {
    @include card;
    @apply relative md:shadow-lg p-4 flex flex-col min-w-full md:min-w-0;
}

.inputs {
    @apply py-8 text-base leading-6 space-y-4 text-gray-700 sm:text-lg sm:leading-7;
}

.error {
    @apply text-sm text-primary-dark
}

.appbar {
    @apply fixed top-0 left-0 right-0
}

.stepper-container {
    @apply p-0 md:py-12 md:px-20 lg:px-32
}

.button-container {
    @apply flex justify-end items-center gap-3
}

.question {
    @apply text-slate-500 text-center md:text-left
}
</style>
